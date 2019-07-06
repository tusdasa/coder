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
public class LoginController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginView() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView view, HttpSession session, @RequestParam Map<String, String> user) {
		String account = user.get("text");
		String password = user.get("password");
		String code = user.get("code");

		if (session.getAttribute("user") != null) {
			view.setViewName("redirect:/");
		} else {

			if (account.equals("") || password.equals("") || code.equals("")) {
				view.setViewName("login");
				view.addObject("info", "请填写信息");
				return view;
			} else {
				if (session.getAttribute("vcode").equals(code)) {

					User u = null;

					if (AccountValidatorUtils.isUsername(account)) {
						u = userService.loginByUsername(account, password);
					}

					if (AccountValidatorUtils.isMobile(account)) {
						u = userService.loginByPhone(account, password);
					}

					if (AccountValidatorUtils.isEmail(account)) {
						u = userService.loginByEmail(account, password);
					}

					if (u != null) {
						if(u.getStatus()==0) {
							view.setViewName("login");
							view.addObject("info", "账号被禁用");
						}else {
							view.setViewName("redirect:/");
							session.setAttribute("user", u);
						}
					} else {
						view.setViewName("login");
						view.addObject("info", "用户名、邮箱、手机号或密码错误");
					}

				} else {
					view.setViewName("login");
					view.addObject("info", "验证码不正确");
				}
			}
		}
		return view;
	}

}
