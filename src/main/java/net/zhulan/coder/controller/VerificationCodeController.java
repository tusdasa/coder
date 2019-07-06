package net.zhulan.coder.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.zhulan.coder.utils.CodeUtils;
@Controller
public class VerificationCodeController {

	public VerificationCodeController() {
	}
	
	@RequestMapping("/code")
	public void getVerificationCode(HttpSession session, HttpServletResponse resp) throws IOException {
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/png");
		int width = 80;
		// 图片高
		int height = 35;
		// 在内存中创建一个图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取一个画笔
		Graphics g = image.getGraphics();
		// 设置画笔颜色，用灰色做背景
		g.setColor(Color.GRAY);
		// 向Image中填充灰色
		g.fillRect(0, 0, width, height);

		Random r = new Random();

		// 设置3条干扰线
		for (int i = 0; i < 3; i++) {
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(80));
		}

		// 设置验证码字符串的颜色
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		// 设置字符的大小
		g.setFont(new Font("serif", Font.BOLD, 24));
		// 在图片中写入验证码字符串
		String code=CodeUtils.getCode();
		session.setAttribute("vcode", code);
		g.drawString(code, 15, 20);
		// 将Image对象以PNG格式输出给所有的客户端
		ImageIO.write(image, "PNG", resp.getOutputStream());
	}

}
