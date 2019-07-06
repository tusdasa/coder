package net.zhulan.coder.controller;

import java.util.Date;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.zhulan.coder.entity.Comment;
import net.zhulan.coder.entity.User;
import net.zhulan.coder.service.IArticleService;

@Controller
public class CommentController {

	@Autowired
	private IArticleService articleService;
	
	public CommentController() {}
	
	@RequestMapping(value="/comment",method=RequestMethod.POST)
	public ModelAndView comment(ModelAndView view, HttpSession session, @RequestParam(name="comment") String contentm, @RequestParam(name="aid") long aid) {
		if(session.getAttribute("user")!=null) {
			User u = (User) session.getAttribute("user");
			Comment c = new Comment(u,new Date(),contentm);
			if(aid!=0) {
				articleService.addComments(aid, c);
				view.setViewName("redirect:article?aid="+aid);
			}else {
				view.setViewName("redirect:login");
			}
			
		}else {
			view.setViewName("redirect:login");
		}
		return view;
	}

}
