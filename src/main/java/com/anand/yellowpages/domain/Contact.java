package com.anand.yellowpages.domain;

/**
 * Contact POJO class
 * 
 * @author A Anand
 *
 */
public class Contact {
	
	private Long contactId;
	private Long contactUserId;
	private String contactName;
	private String contactPhoneNumber;
	private String contactEmailAddress;
	private String contactAddress;
	private String contactRemark;

	public Contact() {
		super();
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public Long getContactUserId() {
		return contactUserId;
	}

	public void setContactUserId(Long contactUserId) {
		this.contactUserId = contactUserId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public String getContactEmailAddress() {
		return contactEmailAddress;
	}

	public void setContactEmailAddress(String contactEmailAddress) {
		this.contactEmailAddress = contactEmailAddress;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactRemark() {
		return contactRemark;
	}

	public void setContactRemark(String contactRemark) {
		this.contactRemark = contactRemark;
	}

}
