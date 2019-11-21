package com.minds.lms.springboot2jpacrud.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "content_model")

public class Content {
	public Content(String name, String discription, String language, List<DataOrg> ownerOrganizations, String type,
			String startDate, String status , String endDate, String contactName, String contactNumber, byte[] pic) {
		super();
		this.name = name;
		this.discription = discription;
		this.language = language;
		this.ownerOrganizations = ownerOrganizations;
		this.status = status;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.pic = pic;
	}

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String discription;

	private String language;

	private String type;
	
	private String status;

	private String startDate;

	private String endDate;

	private String contactName;

	private String contactNumber;

	@Lob
	private byte[] pic;
	
		
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="content_id")
	private List<DataOrg> ownerOrganizations;

	public Content() {
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	public List<DataOrg> getOwnerOrganizations() {
		return ownerOrganizations;
	}

	public void setOwnerOrganizations(List<DataOrg> ownerOrganizations) {
		this.ownerOrganizations = ownerOrganizations;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public byte[] getPic() {
		return this.pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}