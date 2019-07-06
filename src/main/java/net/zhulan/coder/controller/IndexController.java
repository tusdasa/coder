package net.zhulan.coder.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.ArticleCategory;
import net.zhulan.coder.service.IAddressService;
import net.zhulan.coder.service.IArticleService;
import net.zhulan.coder.utils.PageUtils;


@Controller
public class IndexController {
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private IAddressService addressService;
	
	@RequestMapping(value = "/")
	public ModelAndView indexView(ModelAndView view , @RequestParam Map<String, String> page) {
		view.setViewName("index");
		List<Article> ar = articleService.findAll(PageUtils.checkPage(page));
		List<ArticleCategory> ac = articleService.findAllCategory();
		view.addObject("articles", ar);
		view.addObject("categorys", ac);
		view.addObject("addresss", addressService.findAll());
		view.addObject("page", PageUtils.getPagetoal(articleService.count(), PageUtils.pagesize));
		return view;
	}
	
}
