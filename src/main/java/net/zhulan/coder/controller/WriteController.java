package net.zhulan.coder.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.User;
import net.zhulan.coder.service.IArticleService;

@Controller
public class WriteController {

	@Autowired
	private IArticleService articleService;

	public WriteController() {
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public ModelAndView writeView(ModelAndView view, HttpSession session) {
		if (session.getAttribute("user") == null) {
			view.setViewName("redirect:login");
		} else {
			User u = (User) session.getAttribute("user");
			if (u.getPermission().getPublish()) {
				view.setViewName("write");
				view.addObject("categorys", articleService.findAllCategory());
				view.addObject("tags", articleService.findAllTags());
			} else {
				view.setViewName("redirect:/");
			}
		}

		return view;
	}

	@ResponseBody
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public Map<String, Object> addArticle(HttpSession session, @RequestBody Article article) {
		Map<String, Object> m = new HashMap<>();
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			if (u.getPermission().getPublish()) {

				if (article.getCategory() == null || article.getTitle() == null || article.getContent() == null) {
					m.put("state", 500);
					m.put("msg", "无内容");
				} else {
					article.setAid(0L);
					article.setAuthor(u);
					if (articleService.addArticle(article)) {
						m.put("state", 200);
						m.put("msg", "添加成功");
					} else {
						m.put("state", 500);
						m.put("msg", "添加失败");
					}
				}
			} else {
				m.put("state", 500);
				m.put("msg", "无权限");
			}
		} else {
			m.put("state", 500);
			m.put("msg", "无权限");
		}
		return m;
	}

}
