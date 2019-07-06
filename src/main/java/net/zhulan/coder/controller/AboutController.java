package net.zhulan.coder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {

	public AboutController() {}

	@RequestMapping("/about")
	public String aboutView() {
		return "about";
	}
}
