package net.zhulan.coder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	public LogoutController() {
		
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView loginout(ModelAndView view ,HttpSession session) {
		view.setViewName("redirect:/");
		session.invalidate();
		return view;
	}

}
