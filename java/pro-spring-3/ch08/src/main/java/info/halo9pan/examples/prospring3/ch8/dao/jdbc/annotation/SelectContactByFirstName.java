/**
 * Created on Nov 16, 2011
 */
package info.halo9pan.examples.prospring3.ch8.dao.jdbc.annotation;

import info.halo9pan.examples.prospring3.ch8.domain.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

/**
 * @author Clarence
 *
 */
public class SelectContactByFirstName extends MappingSqlQuery<Contact> {

	private static final String SQL_FIND_BY_FIRST_NAME = "select id, first_name, last_name, birth_date from contact where first_name = :first_name";

	public SelectContactByFirstName(DataSource dataSource) {
		super(dataSource, SQL_FIND_BY_FIRST_NAME);
		super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
	}

	protected Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();

		contact.setId(rs.getLong("id"));
		contact.setFirstName(rs.getString("first_name"));
		contact.setLastName(rs.getString("last_name"));
		contact.setBirthDate(rs.getDate("birth_date"));

		return contact;
	}

}
