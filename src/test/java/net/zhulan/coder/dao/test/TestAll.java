package net.zhulan.coder.dao.test;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.zhulan.coder.dao.IArticleDao;
import net.zhulan.coder.entity.Address;
import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.ArticleCategory;
import net.zhulan.coder.entity.Page;
import net.zhulan.coder.entity.Tags;
import net.zhulan.coder.service.IAddressService;
import net.zhulan.coder.utils.MD5Encrypt;



public class TestAll {
	
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
	
	@Test
	public void TestF() {
		//System.out.println(MD5Encrypt.Encrypt("3988978349"));
		IArticleDao ad = (IArticleDao) ac.getBean("articleDao");
		ad.findAllByPageByUser(1L);
		
		/*
		Article ar = new Article();
		Set<Tags> tags = new HashSet<>();
		tags.add(new Tags(1,""));
		tags.add(new Tags(2,""));
		tags.add(new Tags(3,""));
		ar.setTags(tags);
		ar.setAid(1);
		ar.setCategory(new ArticleCategory(1, ""));
		ar.setContent("111111");
		ar.setDate(new Date());
		ar.setTitle("111");
		ad.updateByPrimaryKey(ar);
		*/
		//List<Article> ar = ad.tagFindArticle(1, new Page());
		//System.out.println(ar.get(0).getTitle());
	}
		
	
		
		/*
		EntityManagerUtils eUtils = (EntityManagerUtils) ac.getBean("entityManagerUtils");
		EntityManager em = eUtils.getEntityManager();
		DaoUtils<Article> dao = new DaoUtils<>(); //inner join fetch pojo.tbs tb where tb.name='tb1'
		System.out.println(dao.selectList(em, "SELECT article FROM Article article inner join fetch article.tags tag where tag.tid=?1", 1, 1));
		dao.colose(em);
		*/
		/*	
		IArticleDao ad = (IArticleDao) ac.getBean("artocleDao");
		Article article = new Article();
		User user = new User();
		user.setUid(2);
		article.setAuthor(user);
		article.setCategory(new ArticleCategory(3, "0o"));
		article.setContent("11111111111");
		article.setDate(new Date());
		article.setTitle("11111111111");
		ad.addModel(article);
	*/
		/*
		 * User user = new User(); user.setUid(2); Article article = new Article();
		 * article.setAuthor(user); article.setCategory(new ArticleCategory(3, "0o"));
		 * article.setContent("11111111111"); article.setDate(new Date());
		 * article.setTitle("11111111111"); System.out.println("------");
		 */

}
