package net.zhulan.coder.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.zhulan.coder.entity.Article;
import net.zhulan.coder.service.IArticleService;
import net.zhulan.coder.utils.PageUtils;

@Controller
public class SearchController {
	
	@Autowired
	private IArticleService articleService;
	
	public SearchController() {}
	
	@RequestMapping(value="/search")
	public ModelAndView serchView(ModelAndView view, @RequestParam Map<String, String> param) {
		
		String key = param.get("key");
		
		if(key !=null && !key.equals("")) {
			
			List<Article> ar = articleService.searchArticleByTitle(key, PageUtils.checkPage(param));
			
			view.setViewName("search");
			
			view.addObject("articles", ar);
			
			view.addObject("page", PageUtils.getPagetoal(articleService.countByKey(key), PageUtils.pagesize));
			
			view.addObject("key", key);
		}else {
			view.setViewName("404");
		}
		
		return view;
	}

}
