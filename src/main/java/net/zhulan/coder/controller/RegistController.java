package net.zhulan.coder.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.zhulan.coder.entity.User;
import net.zhulan.coder.service.IUserService;
import net.zhulan.coder.utils.AccountValidatorUtils;

@Controller
public class RegistController {

	@Autowired
	private IUserService userService;

	public RegistController() {
	}

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registView() {
		return "regist";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public ModelAndView regist(ModelAndView view, HttpSession session, @RequestParam Map<String, String> user) {
		String username = user.get("username");
		String email = user.get("email");
		String number = user.get("number");
		String password = user.get("password");
		String code = user.get("code");

		if (username == null || username.equals("") || email == null || email.equals("") || number == null
				|| number.equals("") || password == null || password.equals("") || code == null || code.equals("")) {
			view.setViewName("regist");
			view.addObject("info", "请填写注册信息");
		} else {
			if (session.getAttribute("vcode").equals(code)) {
				
				User u = new User();

				if (AccountValidatorUtils.isUsername(username)) {
					u.setUsername(username);
				}

				if (AccountValidatorUtils.isEmail(email)) {
					u.setEmail(email);
				}

				if (AccountValidatorUtils.isMobile(number)) {
					u.setNumber(number);
				}

				if (AccountValidatorUtils.isPassword(password)) {
					u.setPassword(password);
				}

				if (u.getNumber() != null && u.getEmail() != null && u.getUsername() != null
						&& u.getPassword() != null) {
					if (userService.addUser(u)) {
						view.setViewName("regist");
						view.addObject("info", "注册成功请登录<a href=\"login\">登录</a>");
					} else {
						view.setViewName("regist");
						view.addObject("info", "注册失败，账号已存在");
					}

				} else {
					view.setViewName("regist");
					view.addObject("info", "信息不符合规范");
				}
			} else {
				view.setViewName("regist");
				view.addObject("info", "验证码错误");
			}

		}
		return view;
	}
}
