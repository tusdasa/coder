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
@Table(name = "address")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Address implements Serializable {
	
	@Transient
	private static final long serialVersionUID = -8432165184627182312L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer did;
	
	@Basic
	@Column(unique=true)
	private String address;
	
	@Basic
	private String title;
	
	public Address() {
	}
	
	public Address(int did, String address, String title) {
		this.did=did;
		this.address=address;
		this.title = title;
	}
	
	public Address(String address, String title) {
		this.address=address;
		this.title = title;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
