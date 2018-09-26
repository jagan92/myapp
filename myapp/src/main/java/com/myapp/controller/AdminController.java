package com.myapp.controller;

import com.myapp.service.AdminService;
import com.myapp.service.UserService;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myapp.auditor.AuditorAwareService;
import com.myapp.constants.AppConstants;
import com.myapp.dto.AbsentDetailVO;
import com.myapp.dto.AttendanceVO;
import com.myapp.dto.MasterDetailVO;
import com.myapp.dto.StudentDetailVO;
import com.myapp.dto.UserPreferences;
import com.myapp.dto.UserVO;

@Controller
public class AdminController {

	@Autowired
	private AuditorAwareService auditorAwareService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;

	@Autowired
	private UserPreferences pref;

	@RequestMapping(value = "/home.htm")
	public String statusCheck(Principal principal, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {
		return "redirect:/dashboard.htm";
	}
	
	@RequestMapping(value = "/dashboard.htm", method = RequestMethod.GET)
	public String dashboard(HttpSession session, ModelMap model) {
		return "dashboard";
	}
	
	@RequestMapping(value = "/allusers.htm", method = RequestMethod.GET)
	public String allusers(HttpSession session, ModelMap model) {
		List<UserVO> userVOs = userService.allUsers();
		model.addAttribute("userVOs", userVOs);
		return "allusers";
	}
	
	@RequestMapping(value = "/addUser.htm", method = RequestMethod.GET)
	public String adduser(HttpSession session, ModelMap model) {
		UserVO userVO = new UserVO();
		model.addAttribute("userVO", userVO);
		List<MasterDetailVO> departments = adminService.listMasterDetailVOByType("department");
		model.addAttribute("departments", departments);
		List<MasterDetailVO> courses = adminService.listMasterDetailVOByType("course");
		model.addAttribute("courses", courses);
		List<MasterDetailVO> periods = adminService.listMasterDetailVOByType("period");
		model.addAttribute("periods", periods);
		List<MasterDetailVO> sections = adminService.listMasterDetailVOByType("section");
		model.addAttribute("sections", sections);
		return "adduser";
	}
	
	@RequestMapping(value = "/saveUser.htm", method = RequestMethod.POST)
	public String saveuser(@ModelAttribute UserVO userVO, RedirectAttributes redirectAttrs) {
		userService.saveUser(userVO);
		return "redirect:/allusers.htm";
	}
	
	@RequestMapping(value = "/addDepartment.htm", method = RequestMethod.GET)
	public String adddepartment(HttpSession session, ModelMap model) {
		MasterDetailVO masterDetailVO = new MasterDetailVO("department");
		model.addAttribute("masterDetailVO", masterDetailVO);
		return "adddepartment";
	}
	
	@RequestMapping(value = "/saveDepartment.htm", method = RequestMethod.POST)
	public String savedepartment(@ModelAttribute MasterDetailVO masterDetailVO, RedirectAttributes redirectAttrs) {
		adminService.saveMasterDetail(masterDetailVO);
		return "redirect:/addDepartment.htm";
	}
	
	@RequestMapping(value = "/addCourse.htm", method = RequestMethod.GET)
	public String addcourse(HttpSession session, ModelMap model) {
		MasterDetailVO masterDetailVO = new MasterDetailVO("course");
		model.addAttribute("masterDetailVO", masterDetailVO);
		List<MasterDetailVO> departments = adminService.listMasterDetailVOByType("department");
		model.addAttribute("departments", departments);
		return "addcourse";
	}
	
	@RequestMapping(value = "/saveCourse.htm", method = RequestMethod.POST)
	public String saveCourse(@ModelAttribute MasterDetailVO masterDetailVO, RedirectAttributes redirectAttrs) {
		adminService.saveMasterDetail(masterDetailVO);
		return "redirect:/addCourse.htm";
	}
	
	@RequestMapping(value = "/attendance.htm", method = RequestMethod.GET)
	public String attendace(HttpSession session, ModelMap model) {
		StudentDetailVO studentDetailVO = new StudentDetailVO();
		model.addAttribute("studentDetailVO", studentDetailVO);
		
		List<MasterDetailVO> departments = adminService.listMasterDetailVOByType("department");
		model.addAttribute("departments", departments);
		List<MasterDetailVO> courses = adminService.listMasterDetailVOByType("course");
		model.addAttribute("courses", courses);
		List<MasterDetailVO> periods = adminService.listMasterDetailVOByType("period");
		model.addAttribute("periods", periods);
		List<MasterDetailVO> sections = adminService.listMasterDetailVOByType("section");
		model.addAttribute("sections", sections);
		
		model.addAttribute("pagetype", 1);
		return "attendance";
	}
	
	@RequestMapping(value = "/addattendance.htm", method = RequestMethod.POST)
	public String addattendace(@ModelAttribute StudentDetailVO studentDetailVO, HttpSession session, ModelMap model) {
		List<MasterDetailVO> departments = adminService.listMasterDetailVOByType("department");
		model.addAttribute("departments", departments);
		List<MasterDetailVO> courses = adminService.listMasterDetailVOByType("course");
		model.addAttribute("courses", courses);
		List<MasterDetailVO> periods = adminService.listMasterDetailVOByType("period");
		model.addAttribute("periods", periods);
		List<MasterDetailVO> sections = adminService.listMasterDetailVOByType("section");
		model.addAttribute("sections", sections);
		
//		List<AbsentDetailVO> absentDetailVOs = adminService.listUsersForAttendance(studentDetailVO);
//		AttendanceVO attendanceVO = new AttendanceVO(absentDetailVOs);
//		model.addAttribute("attendanceVO", attendanceVO);
		session.setAttribute("attendanceFilter", studentDetailVO);
		//model.addAttribute("pagetype", 2);
		return "redirect:/updateattendance.htm";
	}
	
	@RequestMapping(value = "/updateattendance.htm", method = RequestMethod.GET)
	public String attendaceupdate(HttpSession session, ModelMap model) {
		StudentDetailVO studentDetailVO = (StudentDetailVO)session.getAttribute("attendanceFilter");
		List<MasterDetailVO> departments = adminService.listMasterDetailVOByType("department");
		model.addAttribute("departments", departments);
		List<MasterDetailVO> courses = adminService.listMasterDetailVOByType("course");
		model.addAttribute("courses", courses);
		List<MasterDetailVO> periods = adminService.listMasterDetailVOByType("period");
		model.addAttribute("periods", periods);
		List<MasterDetailVO> sections = adminService.listMasterDetailVOByType("section");
		model.addAttribute("sections", sections);
		
		model.addAttribute("pagetype", 2);
		List<AbsentDetailVO> absentDetailVOs = adminService.listUsersForAttendance(studentDetailVO);
		AttendanceVO attendanceVO = new AttendanceVO(absentDetailVOs);
		model.addAttribute("attendanceVO", attendanceVO);
		model.addAttribute("studentDetailVO", studentDetailVO);
		model.addAttribute("absentDetailVOs", absentDetailVOs);
		return "attendance";
	}
	
	
	@RequestMapping(value = "/saveattendance.htm", method = RequestMethod.POST)
	public String saveattendace(@ModelAttribute AttendanceVO attendanceVO, HttpSession session, ModelMap model, RedirectAttributes redirectAttributes) {
		model.addAttribute("pagetype", 2);
		adminService.saveAttendance(attendanceVO);
		redirectAttributes.addFlashAttribute("message", "Attendance Updated...");
		return "redirect:/attendance.htm";
	}
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
