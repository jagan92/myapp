package com.myapp.controller;

import com.myapp.auditor.AuditorAwareService;
import com.myapp.constants.AppConstants;
import com.myapp.dto.UserVO;
import com.myapp.entity.User;
import com.myapp.logging.LogManager;
import com.myapp.logging.Logger;
import com.myapp.service.UserService;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/auth")
public class AuthenticationController {

	@Autowired
	private AuditorAwareService auditorAwareService;

	@Autowired
	HttpSession httpSession;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String login(@RequestParam(required = false) String error, ModelMap model,
			RedirectAttributes redirectAttrs) {
		if (error != null) {
			if (error.equals("1")) {
				model.addAttribute("ui_error", error);
			}
		}		
		return "auth/login";
	}
	
	@RequestMapping(value = "register.htm", method = RequestMethod.GET)
	public String register(@RequestParam(required = false) String error, ModelMap model,
			RedirectAttributes redirectAttrs) {
		UserVO userVO = new UserVO();
		model.addAttribute("userVO", userVO);
		return "auth/register";
	}
	
	@RequestMapping(value = "register.htm", method = RequestMethod.POST)
	public String register_post(@ModelAttribute UserVO userVO,
			RedirectAttributes redirectAttrs) {
		userService.saveUser(userVO);
		return "redirect:login.htm";
	}

}
