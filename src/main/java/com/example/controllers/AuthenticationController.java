package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(final Model model) {
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(final Model model) {
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String error403(final Model model) {
		return "error403";
	}
}
