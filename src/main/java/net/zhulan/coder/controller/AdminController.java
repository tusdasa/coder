package net.zhulan.coder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.zhulan.coder.entity.User;
import net.zhulan.coder.service.IAddressService;
import net.zhulan.coder.service.IArticleService;
import net.zhulan.coder.service.IUserService;

@Controller
public class AdminController {
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IAddressService addressService;
	
	@RequestMapping(value="/admin")
	public ModelAndView adminView(ModelAndView view,HttpSession session) {
		
		if(session.getAttribute("user")==null) {
			view.setViewName("redirect:login");
		}else {
			User u = (User) session.getAttribute("user");
			if(u.getPermission().getAdmin()) {
				view.setViewName("admin");
				view.addObject("categorys", articleService.findAllCategory());
				view.addObject("articles", articleService.findAll());
				view.addObject("tags",articleService.findAllTags());
				view.addObject("users",userService.findAll());
				view.addObject("per",userService.findAllPermission());
				view.addObject("addresss",addressService.findAll());
			}else {
				view.setViewName("redirect:/");
			}
		}
		return view;
	}
}
