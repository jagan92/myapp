package com.myapp.controller;

import com.myapp.service.UserService;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.auditor.AuditorAwareService;
import com.myapp.constants.AppConstants;
import com.myapp.dto.UserPreferences;

@Controller
public class AdminController {

	@Autowired
	private AuditorAwareService auditorAwareService;

	@Autowired
	private UserService userService;

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
	
	@RequestMapping(value = "/addUser.htm", method = RequestMethod.GET)
	public String adduser(HttpSession session, ModelMap model) {
		return "adduser";
	}
	
	@RequestMapping(value = "/addDepartment.htm", method = RequestMethod.GET)
	public String adddepartment(HttpSession session, ModelMap model) {
		return "adddepartment";
	}
	
	@RequestMapping(value = "/addCourse.htm", method = RequestMethod.GET)
	public String addcourse(HttpSession session, ModelMap model) {
		return "addcourse";
	}

}
