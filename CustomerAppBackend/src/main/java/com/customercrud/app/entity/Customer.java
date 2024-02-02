package com.customercrud.app.entity;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cust_id")
	Long id;
	
	@Column(name="firstname")
	String first_name;
	
	@Column(name="lastname")
	String last_name;
	
	@Column(name="street")
	String street;
	
	@Column(name="address")
	String address;
	
	@Column(name="city")
	String city;
	
	@Column(name="state")
	String state;
	
	@Column(name="email")
	String email;
	
	@Column(name="phone")
	String phone;

	public Customer(Long id, String first_name, String last_name, String street, String address, String city,
			String state, String email, String phone) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.street = street;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phone = phone;
	}
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getStreet() {
		return street;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setId(	Long id) {
		this.id = id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", street=" + street
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", email=" + email + ", phone="
				+ phone + "]";
	}



	
	

	
	
	
	
	
	
	
	
	

}
