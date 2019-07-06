package net.zhulan.coder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.zhulan.coder.service.IArticleService;

@Controller
public class ArticleController {

	@Autowired
	private IArticleService articleService;
	
	public ArticleController() {}
	
	@RequestMapping("/article")
	public ModelAndView singleView(ModelAndView view, @RequestParam(name="aid") long aid) {
		if(aid==0) {
			aid=1;
		}
		view.setViewName("single");
		view.addObject("article", articleService.findArticleById(aid));
		view.addObject("aid", aid);
		
		return view;
	}

}
