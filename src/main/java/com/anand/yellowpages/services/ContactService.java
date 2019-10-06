package com.anand.yellowpages.services;

import java.util.List;

import com.anand.yellowpages.domain.Contact;

/**
 * Interface specifies all Business operation for Contact entity
 * 
 * @author A Anand
 *
 */
public interface ContactService {

	/**
	 * Creates a new contact
	 * 
	 * @param contact
	 * 			the contact to be created
	 */
	public void saveContact(Contact contact);
	
	/**
	 * Updates an existing Contact
	 * 
	 * @param contact
	 * 			the contact to be updated
	 */
	public void updateContact(Contact contact);
	
	/**
	 * Deletes a contact from database
	 * 
	 * @param contactId
	 * 			the Id of the contact to be deleted
	 */
	public void deleteSingleContact(Long contactId);
	
	/**
	 * Deletes multiple Contacts from the database
	 * 
	 * @param contactIds
	 * 			the array of contact ids to be deleted
	 */
	public void deleteMultipleContacts(Long[] contactIds);
	
	/**
	 * Returns all the Contacts for the currently logged in User
	 * 
	 * @param userId
	 * 			the id of the currently logged in user
	 * @return
	 * 			all User contacts
	 */
	public List<Contact> findUserContact(Long userId);
	
	/**
	 * Searches for Contacts for a user based on the given free text criteria
	 * 
	 * @param userId
	 * 			the id of the currently logged in user
	 * @param freeTextCriteria
	 * 			the search criteria to be used
	 * @return
	 * 			all user contacts satisfying the specified free text criteria
	 */
	public List<Contact> findUserContact(Long userId, String freeTextCriteria);
	
	public Contact findContactById(Long contactId);
}
