package com.anand.yellowpages.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.anand.yellowpages.dao.BaseDAO;
import com.anand.yellowpages.dao.DAO;
import com.anand.yellowpages.domain.Contact;
import com.anand.yellowpages.rowmappers.ContactRowMapper;

@SuppressWarnings("unchecked")
public class ContactServiceImpl extends BaseDAO implements ContactService{

	@Autowired
	@Qualifier(value = "contactDAOImpl")
	private DAO contactDAOImpl;
	
	@Override
	public void saveContact(Contact contact) {
		contactDAOImpl.save(contact);
	}

	@Override
	public void updateContact(Contact contact) {
		contactDAOImpl.update(contact);
	}

	@Override
	public void deleteSingleContact(Long contactId) {
		contactDAOImpl.deleteById(contactId);
	}

	@Override
	public void deleteMultipleContacts(Long[] contactIds) {
		contactDAOImpl.deleteMultiple(contactIds);
	}

	@Override
	public List<Contact> findUserContact(Long userId) {
		return (List<Contact>) contactDAOImpl.findByProperty("C_USERID", userId);
	}

	@Override
	public List<Contact> findUserContact(Long userId, String freeTextCriteria) {
		String findUserContactQuery = "SELECT C_CONTACTID, C_USERID, C_NAME, C_PHONENUMBER, C_EMAILADDRESS, C_ADDRESS, C_REMARK"
				+ " FROM CONTACT WHERE C_USERID = :C_USERID AND (C_NAME LIKE '%:freeTextCriteria%' OR C_PHONENUMBER LIKE '%:freeTextCriteria%' OR C_EMAILADDRESS LIKE '%:freeTextCriteria%' OR C_ADDRESS LIKE '%:freeTextCriteria%' OR C_REMARK LIKE '%:freeTextCriteria%')";
		
		Map<String, Object> bindMap = new HashMap<>();
		bindMap.put("C_USERID", userId);
		bindMap.put("freeTextCriteria", freeTextCriteria);
		
		return getNamedParameterJdbcTemplate().query(findUserContactQuery, bindMap, new ContactRowMapper());
	}

}
