package net.zhulan.coder.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "article")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Article implements Serializable {

	@Transient
	private static final long serialVersionUID = 3251308835105879275L;

	/**
	 * 文章aid
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aid;

	/**
	 * 文章标题
	 */
	@Basic
	private String title;

	/**
	 * 发布时间
	 */
	@Basic
	private Date date;

	/**
	 * tags
	 */
	@ManyToMany(fetch=FetchType.EAGER)
	@Column(nullable=true)
	private Set<Tags> tags;

	/**
	 * 文章内容
	 */
	@Basic
	@Column(columnDefinition = "text", length = 65535)
	private String content;

	/**
	 * 发表用户
	 */
	@OneToOne(targetEntity=User.class)
	private User author;

	/**
	 * 文章分类
	 */
	@OneToOne(targetEntity = ArticleCategory.class)
	private ArticleCategory category;
	
	@OneToMany(fetch=FetchType.EAGER)
	@Column(nullable=true)
	private Set<Comment> comments;

	public Article() {
	}

	public Article(long aid, String title, Date date, String content, User author) {
		this.aid = aid;
		this.title = title;
		this.date = date;
		this.content = content;
		this.author = author;
	}
	
	public Article(long aid,int acid) {
		this.aid=aid;
		this.category= new ArticleCategory();
		category.setAcid(acid);
	}

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArticleCategory getCategory() {
		return category;
	}

	public void setCategory(ArticleCategory category) {
		this.category = category;
	}

	public Set<Tags> getTags() {
		return tags;
	}

	public void setTags(Set<Tags> tags) {
		this.tags = tags;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
}
