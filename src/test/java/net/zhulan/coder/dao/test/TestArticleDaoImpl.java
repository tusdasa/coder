package net.zhulan.coder.dao.test;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import net.zhulan.coder.dao.IArticleDao;
import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.ArticleCategory;
import net.zhulan.coder.entity.Comment;
import net.zhulan.coder.entity.Page;
import net.zhulan.coder.entity.Tags;
import net.zhulan.coder.entity.User;

public class TestArticleDaoImpl extends TestCase {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
	private IArticleDao ad = (IArticleDao) ac.getBean("artocleDao");

	public void testDeleteByPrimaryKey() {
		ad.deleteByPrimaryKey(Long.valueOf(CodeUtils.getRandomInt()));
		
	}

	public void testAddModel() {
		Article article = new Article();
		User u = new User();
		u.setUid(2);
		article.setAuthor(u);
		ArticleCategory c = new ArticleCategory();
		c.setAcid(20);
		article.setCategory(c);
		article.setContent("11111");
		article.setDate(new Date());
		article.setTitle("2222");
		Comment cc = new Comment();
		cc.setCoid(1);
		Set<Comment> comments = new LinkedHashSet<>();
		comments.add(cc);
		article.setComments(comments);
		ad.addModel(article);
		
	}

	public void testSelectByPrimaryKey() {
		ad.selectByPrimaryKey(1L);
	}

	public void testUpdateByPrimaryKey() {
		Article article = new Article();
		User u = new User();
		u.setUid(2);
		article.setAuthor(u);
		ArticleCategory c = new ArticleCategory();
		c.setAcid(21);
		article.setCategory(c);
		article.setContent("33333");
		article.setDate(new Date());
		article.setTitle("55555");
		Comment cc = new Comment();
		cc.setCoid(2);
		Set<Comment> comments = new LinkedHashSet<>();
		comments.add(cc);
		article.setComments(comments);
		ad.updateByPrimaryKey(article);
	}

	public void testFindAll() {
		ad.findAll();
	}

	public void testFindAllByPage() {
		ad.findAllByPage(new Page());
	}

	public void testFindAllByPageByKeyWord() {
		ad.findAllByPageByKeyWord("1",new Page());
	}

	public void testFindAllByPageByUser() {
		ad.findAllByPageByUser(1L);
	}

	public void testCount() {
		ad.count();
	}

	public void testCountByUser() {
		ad.countByUser(1);
	}

	public void testFindAllPageNoContent() {
		ad.findAllPageNoContent();
	}

	public void testFindAllPageNoContentByPage() {
		ad.findAllPageNoContentByPage(new Page());
	}

	public void testUpdateContent() {
		Article ar = new Article();
		ar.setAid(2);
		ar.setContent("32323232");
		ad.updateContent(ar);
	}

	public void testUpdateTitle() {
		Article ar = new Article();
		ar.setAid(2);
		ar.setTitle("title");
		ad.updateTitle(ar);
	}

	public void testUpdateCategory() {
		Article ar = new Article();
		ar.setCategory(new ArticleCategory(10, ""));
		ad.updateCategory(ar);
	}

	public void testUpdateComments() {
		User u = new User();
		u.setUid(1L);
		Comment cc = new Comment(u,new Date(),"1111");
		ad.addComments(2L,cc);
	}

	public void testUpdateTags() {
		Article ar = new Article();
		Set<Tags> tag = new LinkedHashSet<>();
		Tags t = new Tags();
		t.setTid(9);
		tag.add(t);
		ar.setTags(tag);
		ad.updateTags(ar);
	}

	public void testTagFindArticle() {
		ad.tagFindArticle(1, new Page());
	}

}
