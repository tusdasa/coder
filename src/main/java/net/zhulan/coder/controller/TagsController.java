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
public class TagsController {
	
	@Autowired
	private IArticleService articleService;
	
	public TagsController() {}
	
	@RequestMapping(value="/tags")
	public ModelAndView tagsView(ModelAndView view, @RequestParam Map<String, String> param) {
		Integer tid=1;
		if(param.get("tags")!=null && !param.get("tags").equals("")) {
			tid = SafeType.toInteger(param.get("tags"));
		}
		view.setViewName("tags");
		view.addObject("tid",tid);
		view.addObject("categorys",articleService.findAllCategory());
		view.addObject("page", PageUtils.checkPage(param).getPageNum());
		view.addObject("articles", articleService.findArticleByTags(tid, PageUtils.checkPage(param)));
		return view;
	}

}
