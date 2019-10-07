package com.anand.yellowpages.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.anand.yellowpages.domain.Contact;
import com.anand.yellowpages.rowmappers.ContactRowMapper;
import com.anand.yellowpages.utilities.Constants;
import com.anand.yellowpages.utilities.StringUtils;

/**
 * 
 * @author A Anand
 *
 */
@Repository
public class ContactDAOImpl extends BaseDAO implements DAO{

	@Override
	public void save(Object object) {
		Contact contact = (Contact) object;

		String saveQuery = "INSERT INTO CONTACT "
				+ "(C_NAME, C_PHONENUMBER, C_EMAILADDRESS, C_ADDRESS, C_REMARK, C_USERID)"
				+ "VALUES (:C_NAME, :C_PHONENUMBER, :C_EMAILADDRESS, :C_ADDRESS, :C_REMARK, :C_USERID)";

		Map<String, Object> bindMap = new HashMap<>();
		bindMap.put("C_NAME", contact.getContactName());
		bindMap.put("C_PHONENUMBER", contact.getContactPhoneNumber());
		bindMap.put("C_EMAILADDRESS", contact.getContactEmailAddress());
		bindMap.put("C_ADDRESS", contact.getContactAddress());
		bindMap.put("C_REMARK", contact.getContactRemark());
		bindMap.put("C_USERID", contact.getContactUserId());

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(bindMap);
		super.getNamedParameterJdbcTemplate().update(saveQuery, sqlParameterSource, keyHolder);
		contact.setContactId(keyHolder.getKey().longValue());
	}

	@Override
	public void update(Object object) {
		Contact contact = (Contact) object;

		String updateQuery = "UPDATE CONTACT SET " + "C_NAME=:C_NAME, "
				+ "C_PHONENUMBER=:C_PHONENUMBER, " + "C_EMAILADDRESS=:C_EMAILADDRESS, " + "C_ADDRESS=:C_ADDRESS, "
				+ "C_REMARK=:C_REMARK " + "WHERE C_CONTACTID=:C_CONTACTID";

		Map<String, Object> bindMap = new HashMap<>();
		bindMap.put("C_NAME", contact.getContactName());
		bindMap.put("C_PHONENUMBER", contact.getContactPhoneNumber());
		bindMap.put("C_EMAILADDRESS", contact.getContactEmailAddress());
		bindMap.put("C_ADDRESS", contact.getContactAddress());
		bindMap.put("C_REMARK", contact.getContactRemark());
		bindMap.put("C_CONTACTID", contact.getContactId());

		super.getNamedParameterJdbcTemplate().update(updateQuery, bindMap);
	}

	@Override
	public void delete(Object object) {
		this.deleteById(((Contact) object).getContactId());
	}

	@Override
	public void deleteById(Object object) {
		String deleteQuery = "DELETE FROM CONTACT WHERE C_CONTACTID = ?";
		getJdbcTemplate().update(deleteQuery, (Long) object);
	}

	@Override
	public Object findById(Object object) {
		String selectQuery = "SELECT C_CONTACTID, C_USERID, C_NAME, C_PHONENUMBER, C_EMAILADDRESS, C_ADDRESS, C_REMARK"
				+ " FROM CONTACT WHERE C_CONTACTID = ?";
		return getJdbcTemplate().queryForObject(selectQuery, new ContactRowMapper(), object);
	}

	@Override
	public List<?> findAll() {
		String selectQuery = "SELECT C_CONTACTID, C_USERID, C_NAME, C_PHONENUMBER, C_EMAILADDRESS, C_ADDRESS, C_REMARK"
				+ " FROM CONTACT";
		return getJdbcTemplate().query(selectQuery, new ContactRowMapper());
	}

	@Override
	public List<?> findByProperty(String propertyName, Object propertyValue) {
		String selectQuery = "SELECT C_CONTACTID, C_USERID, C_NAME, C_PHONENUMBER, C_EMAILADDRESS, C_ADDRESS, C_REMARK"
				+ " FROM CONTACT WHERE " + propertyName + " = ?";
		return getJdbcTemplate().query(selectQuery, new ContactRowMapper(), propertyValue);
	}

	@Override
	public void deleteMultiple(Object[] ids) {
		String concatenatedIds = StringUtils.toConcatenatedString(ids, Constants.COMMA);
		String deleteQuery = "DELETE FROM CONTACT WHERE C_CONTACTID IN (" + concatenatedIds + ")";
		getJdbcTemplate().update(deleteQuery);
	}

}
