package com.gatepass.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="gpa_visitor")
@NamedQueries({ @NamedQuery(name="getAllVisitors", query="FROM Visitor"),
				@NamedQuery(name="removeVisitor", query="DELETE FROM Visitor WHERE visitornumber=:visitorNum") })
public class Visitor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer visitornumber;
	
	@Column
	private String visitorName;
	
	@Column
	private String visitorType;
	
	@Column
	private String address;
	
	@Column
	private String purpose;
	
	@Column
	private String comingFrom;
	
	@Column
	private String contactPerson;
	
	@Column
	private String contactNumber;
	
	@Column
	private String vehicleNumber;
	
	@Column
	private String timeIn;
	
	@Column
	private String timeOut;
	
	@Column
	private String helmetIssued;
	
	@Column
	private String numberOfVisitors;
	
	@Column
	private String date;
	
	@Column(nullable=true) 
	private Blob photo;
	
	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public Integer getVisitornumber() {
		return visitornumber;
	}

	public void setVisitornumber(Integer visitornumber) {
		this.visitornumber = visitornumber;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorType() {
		return visitorType;
	}

	public void setVisitorType(String visitorType) {
		this.visitorType = visitorType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getComingFrom() {
		return comingFrom;
	}

	public void setComingFrom(String comingFrom) {
		this.comingFrom = comingFrom;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	public String getHelmetIssued() {
		return helmetIssued;
	}

	public void setHelmetIssued(String helmetIssued) {
		this.helmetIssued = helmetIssued;
	}

	public String getNumberOfVisitors() {
		return numberOfVisitors;
	}

	public void setNumberOfVisitors(String numberOfVisitors) {
		this.numberOfVisitors = numberOfVisitors;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
	
		StringBuffer sb = new StringBuffer(); 
		sb.append("visitorNumber="+visitornumber);
		sb.append(", visitorName="+visitorName);
		sb.append(", visitorType="+visitorType);
		sb.append(", address="+address);
		sb.append(", purpose="+purpose);
		sb.append(", comingFrom="+ comingFrom);
		sb.append(", contactPerson="+contactPerson);
		sb.append(", contactNumber="+ contactNumber);
		sb.append(", vehicleNumber="+vehicleNumber);
		sb.append(", timeIn="+timeIn);
		sb.append(", timeOut="+ timeOut);
		sb.append(", helmetIssued ="+ helmetIssued);
		sb.append(", numberOfVisitors ="+ numberOfVisitors);
		sb.append(", date ="+ date);
		
		return sb.toString();
	}
}