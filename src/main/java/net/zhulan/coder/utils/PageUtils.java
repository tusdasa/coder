package net.zhulan.coder.utils;

import java.util.Map;

import net.zhulan.coder.entity.Page;

public class PageUtils {
	public static int pagesize = 3;

	public PageUtils() {
	}

	public static Page checkPage(Page page) {
		if (page.getPageNum() < 0 || page.getPageSize() <= 0) {
			return new Page(0);
		}
		return page;
	}

	public static Page checkPage(Map<String, String> page) {
		String pageNum = page.get("page");
		if (page == null || pageNum == null) {
			return new Page();
		} else {
			int pagenum = 0;
			try {
				pagenum = Integer.valueOf(pageNum);
			} catch (Exception e) {
				return new Page(0);
			}

			if (pagenum <= 0) {
				return new Page(0);
			}
			return new Page(pagenum);
		}

	}
	
	public static int getPagetoal(long pagetoal,int size) {
		if(pagetoal<size) {
			return 1;
		}else {
			if(pagetoal>size) {
				return (int) Math.ceil((double) pagetoal/size );
			}else {
				return 1;
			}
		}
	}

}
