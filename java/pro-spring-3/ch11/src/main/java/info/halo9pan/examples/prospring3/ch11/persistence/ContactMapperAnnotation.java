/**
 * Created on Oct 26, 2011
 */
package info.halo9pan.examples.prospring3.ch11.persistence;

import info.halo9pan.examples.prospring3.ch11.domain.Contact;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author Clarence
 *
 */
public interface ContactMapperAnnotation {

	@Select(value = "SELECT ID,FIRST_NAME,LAST_NAME,BIRTH_DATE FROM CONTACT")
	@Results(value = { @Result(javaType = Contact.class), @Result(property = "id", column = "ID"), @Result(property = "firstName", column = "first_name"), @Result(property = "lastName", column = "last_name"), @Result(property = "birthDate", column = "birth_date") })
	List<Contact> findAll();

}
