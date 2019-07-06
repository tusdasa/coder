package net.zhulan.coder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.zhulan.coder.entity.User;
import net.zhulan.coder.service.IArticleService;

@Controller
public class AuthorController {

	@Autowired
	private IArticleService articleService;
	
	public AuthorController() {}
	
	@RequestMapping(value = "/author")
	public ModelAndView authorView(ModelAndView view, HttpSession session) {
	
		if(session.getAttribute("user")!=null) {
			
			User u = (User) session.getAttribute("user");
			
			if(u.getPermission().getPublish()) {
				
				view.setViewName("author");
				view.addObject("articles", articleService.findArticleByUser(u));
				
			}else {
				view.setViewName("redirect:/");
			}
			
			
		}else {
			view.setViewName("redirect:login");
		}
		
		return view;
	}

}
