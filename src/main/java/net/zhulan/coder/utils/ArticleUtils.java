package net.zhulan.coder.utils;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.Comment;
import net.zhulan.coder.entity.Tags;

public class ArticleUtils extends DaoUtils<Article> {
	
	public boolean addArticle(EntityManager em, Article article) {
		
		int result=0;
		
		Article backup = new Article();
		
		backup.setAuthor(article.getAuthor());
		backup.setCategory(article.getCategory());
		backup.setContent(article.getContent());
		backup.setDate(article.getDate());
		backup.setTitle(article.getTitle());
		
		Set<Tags> tags = article.getTags();
		
		
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		try {

			em.persist(backup);
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			return false;
		}
		
		transaction.begin();
		
		for (Tags tag : tags) {
			try {
				
				Query query = em.createNativeQuery("INSERT INTO article_tags (Article_aid, tags_tid) VALUES (?1,?2)");
				
				query.setParameter(1, article.getAid());
				
				query.setParameter(2, tag.getTid());
				
				result = query.executeUpdate();
				
				transaction.commit();
				
			}catch (Exception e) {
				e.printStackTrace();
				if (transaction.isActive()) {
					transaction.rollback();
				}
				break;
			}
		}
		
		if(result>0) {
			return false;
		}else {
			return true;
		}
	}
	
public boolean addComment(EntityManager em, Long aid,Comment comment) {
		
		int result=0;
		
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		try {

			em.persist(comment);
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
		
		transaction.begin();
		
		try {
			
			Query query = em.createNativeQuery("INSERT INTO article_comments(Article_aid, comments_coid) VALUES (?1, ?2)");
			
			query.setParameter(1, aid);
			
			query.setParameter(2, comment.getCoid());
			
			result = query.executeUpdate();
			
			transaction.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
		
		if(result>0) {
			return false;
		}else {
			return true;
		}

	}

public boolean updateTags(EntityManager em, Long aid,Set<Tags> tags) {
	
	EntityTransaction transaction = em.getTransaction();

	transaction.begin();
	
	try {
		
		Query q1 = em.createNativeQuery("DELETE FROM article_tags WHERE Article_aid=?1");
		q1.setParameter(1, aid);
		q1.executeUpdate();
		transaction.commit();
		
	} catch (Exception e) {
		e.printStackTrace();
		if (transaction.isActive()) {
			transaction.rollback();
		}
		return false;
	}
	
	transaction.begin();
	
	try {
		
		
		for (Tags tag : tags) {
			Query q2 = em.createNativeQuery("INSERT INTO article_tags (Article_aid, tags_tid) VALUES (?1, ?2)");
			q2.setParameter(1, aid);
			q2.setParameter(2, tag.getTid());
			q2.executeUpdate();
		}
		transaction.commit();
		
	} catch (Exception e) {
		e.printStackTrace();
		if (transaction.isActive()) {
			transaction.rollback();
		}
		return false;
	}
	
	return true;
}

}
