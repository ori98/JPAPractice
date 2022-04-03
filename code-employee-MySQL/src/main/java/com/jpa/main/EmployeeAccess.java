package com.jpa.main;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Access_Card_DATA")
public class EmployeeAccess {
	private int id;
	@Temporal(TemporalType.DATE)
	private Date issueDate;
	private boolean isActive;
	private String firmwareVersion;
	
	private Employee owner;
	@OneToOne(cascade= {CascadeType.ALL})// , mappedBy = "card")
	public Employee getOwner() {
		return owner;
	}
	public void setOwner(Employee owner) {
		this.owner = owner;
	}
	@Id
	@Column(name="card_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="issue_date")
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	@Column(name="is_active")
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Column(name="firmware_version")
	public String getFirmwareVersion() {
		return firmwareVersion;
	}
	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}
	@Override
	public String toString() {
		return "EmployeeAccess [id=" + id + ", issueDate=" + issueDate + ", isActive=" + isActive + ", firmwareVersion="
				+ firmwareVersion + ", Owner ID: " + owner.getEmpId() + " " + "]";
	}
	
	
}
