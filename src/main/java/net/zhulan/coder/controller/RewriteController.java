package net.zhulan.coder.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.User;
import net.zhulan.coder.service.IArticleService;

@Controller
public class RewriteController {

	@Autowired
	private IArticleService articleService;

	public RewriteController() {
	}

	@RequestMapping(value = "/rewrite", method = RequestMethod.GET)
	public ModelAndView rewriteView(HttpSession session, ModelAndView view,
			@RequestParam(name = "aid", required = true) Long aid) {
		if (session.getAttribute("user") == null) {
			view.setViewName("redirect:login");
		} else {
			User u = (User) session.getAttribute("user");
			if (u.getPermission().getPublish()) {
				view.setViewName("rewrite");
				view.addObject("article", articleService.findArticleById(aid));
				view.addObject("categorys", articleService.findAllCategory());
				view.addObject("tags", articleService.findAllTags());
				view.addObject("aid", aid);

			} else {
				view.setViewName("redirect:/");
			}
		}

		return view;
	}

	@ResponseBody
	@RequestMapping(value = "/rewrite", method = RequestMethod.POST)
	public Map<String, Integer> rewrite(HttpSession session, @RequestBody Article article) {
		Map<String, Integer> map = new HashMap<>();

		if (session.getAttribute("user") == null) {
			map.put("state", 500);
		} else {
			User u = (User) session.getAttribute("user");
			if (u.getPermission().getPublish()) {
				if(articleService.upArticle(article)) {
					map.put("state", 200);
				}else {
					map.put("state", 500);
				}
			} else {
				map.put("state", 500);
			}
		}

		return map;
	}

}
