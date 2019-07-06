package net.zhulan.coder.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.zhulan.coder.entity.User;
import net.zhulan.coder.utils.CodeUtils;

@Controller
public class FileUploadController {
	private static final String[] AllowExt = { "gif", "jpg", "jpeg", "png", "tiff", "bmp", "mp3", "wmv", "wma", "rmvb",
			"rm", "avi", "flv", "txt", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "zip", "rar", "pdf" };
	private final String UPLOAD_REALITY_IMAGE_PATH = "WEB-INF/static/imgs";

	public FileUploadController() {}

	@Autowired
	private ServletContext servletcontext;

	@RequestMapping(value = "/upimg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> upImages(HttpSession session,@RequestParam(name = "upload") CommonsMultipartFile file) throws IOException {
		
		Map<String, Object> m = new HashMap<>();
		
		if(session.getAttribute("user")!=null) {
			User u = (User) session.getAttribute("user");
			if(!u.getPermission().getPublish()) {
				return m;
			}
		}

		String[] extension = file.getOriginalFilename().split("\\.");

		if (extension == null || extension.length < 2) {
			return m;
		}

		boolean flag = false;

		for (String string : AllowExt) {
			if (string.equals(extension[extension.length - 1].toLowerCase())) {
				flag = true;
				break;
			}
		}

		if (flag) {
			String filename = CodeUtils.getRandom();
			File newFile = new File(servletcontext.getRealPath("") + "/" + UPLOAD_REALITY_IMAGE_PATH + "/" + filename
					+ "." + extension[extension.length - 1]);
			file.transferTo(newFile);

			m.put("url", newFile.getName());
			m.put("errno", 0);

		} else {
			m.put("errno", 1);
		}
		return m;
	}

}
