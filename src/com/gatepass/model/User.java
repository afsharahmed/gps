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
@Table(name="gpa_user")
@NamedQueries({ @NamedQuery(name="findUserByUsername", query="FROM User WHERE username=:uname AND password=:pwd"),
				@NamedQuery(name="removeUser", query="DELETE FROM User WHERE userId=:userId")
			 // @NamedQuery(name="Contact.findById", query="select distinct c from Contact c left join fetch c.contactTelDetails t left join fetch c.hobbies h where c.id = :id"),
			 // @NamedQuery(name="Contact.findAllWithDetail", query="select distinct c from Contact c left join fetch c.contactTelDetails t left join fetch c.hobbies h")
})
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String username;
	
	@Column
	private String password;

	@Column
	private String role;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		sb.append("{Username="+username);
		sb.append(", password="+ password);		
		sb.append(", role="+role);
		sb.append("}");
		return sb.toString();
	}
}
