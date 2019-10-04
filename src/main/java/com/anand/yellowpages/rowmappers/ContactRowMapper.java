package com.anand.yellowpages.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.anand.yellowpages.domain.Contact;

/**
 * 
 * @author A Anand
 *
 */
public class ContactRowMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setContactId(rs.getLong("C_CONTACTID"));
		contact.setContactAddress(rs.getString("C_ADDRESS"));
		contact.setContactEmailAddress(rs.getString("C_EMAILADDRESS"));
		contact.setContactName(rs.getString("C_NAME"));
		contact.setContactPhoneNumber(rs.getString("C_PHONENUMBER"));
		contact.setContactRemark(rs.getString("C_REMARK"));
		contact.setContactUserId(rs.getLong("C_USERID"));
		return contact;
	}

}
