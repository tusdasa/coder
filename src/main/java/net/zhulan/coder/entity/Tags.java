package net.zhulan.coder.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="tags")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Tags implements Serializable {
	
	@Transient
	private static final long serialVersionUID = -1892521688684243755L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;
	
	@Basic
	@Column(unique=true)
	private String content;
	
	
	public Tags() {}
	
	public Tags(int tid,String content) {
		this.tid = tid;
		this.content = content;
	}
	
	public Tags(String content) {
		this.content = content;
	}
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
