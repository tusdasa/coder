package net.zhulan.coder.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.zhulan.coder.service.IArticleService;
import net.zhulan.coder.utils.PageUtils;
import net.zhulan.coder.utils.SafeType;

@Controller
public class CategoryController {
	@Autowired
	private IArticleService articleService;
	
	@RequestMapping(value = "/category")
	public ModelAndView categoryView(ModelAndView view, @RequestParam Map<String, String> param) {
		Integer acid=1;
		if(param.get("ac")!=null && !param.get("ac").equals("")) {
			acid = SafeType.toInteger(param.get("ac"));
		}
		view.setViewName("category");
		view.addObject("articles", articleService.findArticleByCategory(acid, PageUtils.checkPage(param)));
		view.addObject("categorys", articleService.findAllCategory());
		view.addObject("page", PageUtils.getPagetoal(articleService.count(acid), PageUtils.pagesize));
		view.addObject("ac", acid);
		return view;
	}
	/*
	public ModelAndView tidView(ModelAndView view, @RequestParam Map<String, String> param) {
		Integer tid=1;
		if(param.get("tid")!=null && !param.get("tid").equals("")) {
			tid = SafeType.toInteger(param.get("ac"));
		}
		view.addObject("", articleService.findArticleByTags(tid));
		return view;
	}
	*/
}
