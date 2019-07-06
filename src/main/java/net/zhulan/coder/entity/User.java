package net.zhulan.coder.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="user")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User implements Serializable {
	@Transient
	private static final long serialVersionUID = -5900012802151932770L;
	/**
	 * uid
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long uid;
	/**
	 * 用户名
	 */
	@Basic
	@Column(unique=true)
	private String username;
	/**
	 * 电子邮件
	 */
	@Basic
	@Column(nullable=true,unique=true)
	private String email;
	/**
	 * 电话号码
	 */
	@Basic
	@Column(nullable=true,unique=true)
	private String number;
	/**
	 * 密码
	 */
	@Basic
	private String password;
	/**
	 * 账号状态
	 */
	@Basic
	private int status=1;
	/**
	 * 权限
	 */
	@OneToOne
	private Permission permission = new Permission();
	
	public User() {}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
}
