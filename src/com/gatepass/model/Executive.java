package com.gatepass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="gpa_executive")
@NamedQueries({ @NamedQuery(name="getExecutiveByUserId", query="FROM Executive WHERE userId=:userId"), 
				@NamedQuery(name="getAllExecutives", query="FROM Executive where role != 'ADMIN'"),
				@NamedQuery(name="removeExecutive", query="DELETE FROM Executive WHERE executiveId=:exId"),
				@NamedQuery(name="getUserByUsername", query="FROM Executive WHERE username=:uname AND password=:pwd")
})
public class Executive 
{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer executiveId;
	
	@Column
	private Long userId;
	
	@Column
	private String username;
	
	@Column
	private String password;

	@Column
	private String role;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String dob;
	
	@Column
	private Integer gender;  // TODO Convert later to Enum
	
	@Column
	private String address;
	
	@Column
	private String mobile;
	
	@Column
	private String qualification;


	public Integer getExecutiveId() {
		return executiveId;
	}
	public void setExecutiveId(Integer executiveId) {
		this.executiveId = executiveId;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append("{id="+executiveId);
		sb.append("username="+username);
		sb.append(", firstname="+firstName);
		sb.append(", lastname="+lastName);
		sb.append(", dob="+dob);
		sb.append(", gender="+gender);
		sb.append(", address="+ address);
		sb.append(", mobile="+mobile);
		sb.append(", qualification="+ qualification);
		sb.append("}");
	
		return sb.toString();
	}
}