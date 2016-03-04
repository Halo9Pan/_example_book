/**
 * Created on Nov 16, 2011
 */
package info.halo9pan.examples.prospring3.ch8.dao.jdbc.annotation;

import info.halo9pan.examples.prospring3.ch8.dao.ContactSfDao;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

/**
 * @author Clarence
 *
 */
@Repository("contactSfDao")
public class JdbcContactSfDao implements ContactSfDao {

	private DataSource dataSource;

	private SfFirstNameById sfFirstNameById;

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;

		sfFirstNameById = new SfFirstNameById(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public String getFirstNameById(Long id) {
		List<String> result = sfFirstNameById.execute(id);
		return result.get(0);
	}

}
