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
@Table(name="category")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ArticleCategory implements Serializable {
	@Transient
	private static final long serialVersionUID = 3957913174536998126L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int acid;
	@Basic
	@Column(unique=true)
	private String acname;
	
	public ArticleCategory() {}
	
	public ArticleCategory(int acid,String acname) {
		this.acid=acid;
		this.acname=acname;
	}
	
	public int getAcid() {
		return acid;
	}
	public void setAcid(int acid) {
		this.acid = acid;
	}
	public String getAcname() {
		return acname;
	}
	public void setAcname(String acname) {
		this.acname = acname;
	}
	
	

}
