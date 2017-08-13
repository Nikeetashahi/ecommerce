package com.ecommerce.model;

import javax.persistence.*;


@Entity
public class Supplier {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int Sid;
	@Column(name="name")
	private String Sname;
	@Column(name="contact")
	private String Scontact;
	@Column(name="address")
	private String Saddress;
	public int getSid() {
		return Sid;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getScontact() {
		return Scontact;
	}
	public void setScontact(String scontact) {
		Scontact = scontact;
	}
	public String getSaddress() {
		return Saddress;
	}
	public void setSaddress(String saddress) {
		Saddress = saddress;
	}
	public void setSid(int sid) {
		Sid = sid;
	}
	

}
