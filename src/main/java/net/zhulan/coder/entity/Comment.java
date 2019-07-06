package net.zhulan.coder.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "comments")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Comment implements Serializable {
	
	@Transient
	private static final long serialVersionUID = -1706993216007957820L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long coid;
	@OneToOne
	private User user;
	@Basic
	private Date created;
	@Basic
	private String comment;

	public Comment() {
	}
	
	public Comment(User user,Date created, String comment) {
		this.user=user;
		this.created=created;
		this.comment=comment;
	}

	public long getCoid() {
		return coid;
	}

	public void setCoid(long coid) {
		this.coid = coid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
