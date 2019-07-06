package net.zhulan.coder.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.zhulan.coder.entity.Address;
import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.ArticleCategory;
import net.zhulan.coder.entity.Tags;
import net.zhulan.coder.entity.User;
import net.zhulan.coder.service.IAddressService;
import net.zhulan.coder.service.IArticleService;
import net.zhulan.coder.service.IUserService;
import net.zhulan.coder.utils.AccountValidatorUtils;
import net.zhulan.coder.utils.SafeType;

@Controller
public class APIController {
	/**
	 * 创建（Create）、更新（Update）、读取（Retrieve）和删除（Delete）
	 * 
	 * 
	 */

	@Autowired
	private IUserService userService;

	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private IAddressService addressService;
	
	@ResponseBody
	@RequestMapping(value = "/api/check")
	public Map<String, Integer> check(@RequestParam(name = "action", required = true) String key,
			@RequestParam(name = "value", required = true) String value) {

		Map<String, Integer> result = new HashMap<>();

		if (AccountValidatorUtils.isEmpty(key) || AccountValidatorUtils.isEmpty(value)) {
			result.put("state", 500);
			return result;
		}
		switch (key) {
		case "cu":
			if(AccountValidatorUtils.isUsername(value)) {
				if (userService.cheackUsername(value)) {
					result.put("state", 200);
				} else {
					result.put("state", 500);
				}
			}else {
				result.put("state", 500);
			}
			
			break;
		case "ce":
			if(AccountValidatorUtils.isEmail(value)) {
				if (userService.cheackEmail(value)) {
					result.put("state", 200);
				} else {
					result.put("state", 500);
				}
			}else {
				result.put("state", 500);
			}
			break;
		case "cp":
			if(AccountValidatorUtils.isMobile(value)) {
				if (userService.cheackNumber(value)) {
					result.put("state", 200);
				} else {
					result.put("state", 500);
				}
			}else {
				result.put("state", 500);
			}
			break;
		default:
			result.put("state", 500);
			break;
		}

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/api/add")
	public Map<String, Integer> add(HttpSession session, @RequestParam(name = "action", required = true) String key,
			@RequestParam(name = "value", required = true) String value) {
		Map<String, Integer> result = new HashMap<>();

		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			if (!u.getPermission().getAdmin()) {
				result.put("state", 500);
				return result;
			}
		} else {
			result.put("state", 500);
			return result;
		}

		if (AccountValidatorUtils.isEmpty(key) || AccountValidatorUtils.isEmpty(value)) {
			result.put("state", 500);
			return result;
		}

		switch (key) {
		case "category":
			if (articleService.addArticleCategory(value)) {
				result.put("state", 200);
			} else {
				result.put("state", 500);
			}
			break;
		case "tag":
			if (articleService.addTag(value)) {
				result.put("state", 200);
			} else {
				result.put("state", 500);
			}
			break;
		default:
			result.put("state", 500);
			break;
		}

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/api/del")
	public Map<String, Integer> del(HttpSession session, @RequestParam(name = "action", required = true) String key,
			@RequestParam(name = "value", required = true) String value) {
		Map<String, Integer> result = new HashMap<>();

		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			if(!u.getPermission().getPublish()) {
				result.put("state", 500);
				return result;
			}else {
				if (!u.getPermission().getAdmin()) {
					result.put("state", 500);
					return result;
				}
			}
			
		} else {
			result.put("state", 500);
			return result;
		}

		Long v = 0L;
		Integer d = 0;

		if (AccountValidatorUtils.isEmpty(key) || AccountValidatorUtils.isEmpty(value)) {
			result.put("state", 500);
			return result;

		}

		v = SafeType.toLong(value);
		
		d = SafeType.toInt(value);

		if (v == 0 || d== 0) {
			result.put("state", 500);
			return result;
		}

		switch (key) {
		case "darticle":
			if (articleService.delArticle(v)) {
				result.put("state", 200);
			} else {
				result.put("state", 500);
			}
			break;
		case "daddress":
			if (addressService.delAddress(d)) {
				result.put("state", 200);
			} else {
				result.put("state", 500);
			}
			break;
		default:
			result.put("state", 500);
			break;
		}

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/api/user")
	public Map<String, Integer> op(HttpSession session, @RequestParam(name = "action", required = true) String key,
			@RequestParam(name = "value", required = true) String value) {
		Map<String, Integer> result = new HashMap<>();

		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			if (!u.getPermission().getAdmin()) {
				result.put("state", 500);
				return result;
			}
		} else {
			result.put("state", 500);
			return result;
		}

		Long v = 0L;

		if (AccountValidatorUtils.isEmpty(key) || AccountValidatorUtils.isEmpty(value)) {
			result.put("state", 500);
			return result;

		}

		v = SafeType.toLong(value);

		if (v == 0) {
			result.put("state", 500);
			return result;
		}

		switch (key) {
		case "disable":
			if (userService.diseble(v)) {
				result.put("state", 200);
			} else {
				result.put("state", 500);
			}
			break;
		case "enable":
			if (userService.enable(v)) {
				result.put("state", 200);
			} else {
				result.put("state", 500);
			}
			break;
		default:
			result.put("state", 500);
			break;
		}

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/api/addAddress")
	public Map<String, Integer> addAddress(HttpSession session, @RequestBody Address address){
		Map<String, Integer> result = new HashMap<>();
		
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			if (!u.getPermission().getAdmin()) {
				result.put("state", 500);
				return result;
			}
		} else {
			result.put("state", 500);
			return result;
		}
		
		if(addressService.addAddress(address)) {
			result.put("state", 200);
		}else {
			result.put("state", 500);
		}
		
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/api/upAddress")
	public Map<String, Integer> updateAddress(HttpSession session,@RequestBody Address address){
		Map<String, Integer> result = new HashMap<>();
		
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			if (!u.getPermission().getAdmin()) {
				result.put("state", 500);
				return result;
			}
		} else {
			result.put("state", 500);
			return result;
		}
		
		if(address.getDid()==0 || address.getAddress()==null || address.getTitle()==null) {
			result.put("state", 500);
			return result;
		}
		
		if(addressService.upAddress(address)) {
			result.put("state", 200);
		}else {
			result.put("state", 500);
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/api/update")
	public Map<String, Integer> update(HttpSession session,@RequestParam(value="action") String action,@RequestParam(value="id") String id ,@RequestParam(value="value") String value){
		
		Map<String, Integer> result = new HashMap<>();
		
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			if(!u.getPermission().getPublish()) {
				result.put("state", 500);
				return result;
			}else {
				if (!u.getPermission().getAdmin()) {
					result.put("state", 500);
					return result;
				}
			}
		} else {
			result.put("state", 500);
			return result;
		}
		int k1 =0;
		long k2 =0L;
		k1 = SafeType.toInt(id);
		k2 = SafeType.toLong(id);
		
		if(AccountValidatorUtils.isEmpty(value) || AccountValidatorUtils.isEmpty(id) || AccountValidatorUtils.isEmpty(action)) {
			result.put("state", 500);
			return result;
		}
		
		if(k1==0 || k2==0) {
			result.put("state", 500);
			return result;
		}
		
		switch (action) {
		case "uc":
			ArticleCategory category = new ArticleCategory(k1, value);
			if(articleService.upArticleCategory(category)) {
				result.put("state", 200);
			}else {
				result.put("state", 500);
			}
			
			break;
		case "ua":
			Article article = new Article(k1,SafeType.toInteger(value));
			if(articleService.updateArticleCategory(article)) {
				result.put("state", 200);
			}else {
				result.put("state", 500);
			}
			break;
		case "ut":
			Tags tag = new Tags(k1,value);
			if(articleService.upTag(tag)) {
				result.put("state", 200);
			}else {
				result.put("state", 500);
			}
			break;
		case "uu":
			if(userService.upPermission(k1, SafeType.toInteger(value))) {
				result.put("state", 200);
			}else {
				result.put("state", 500);
			}
			break;
		default:
			result.put("state", 500);
			break;
		}
		
		
		return result;
	}

}
