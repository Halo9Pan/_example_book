/**
 * Created on Nov 29, 2011
 */
package info.halo9pan.examples.prospring3.ch16.restful.support;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.impl.client.BasicCredentialsProvider;

/**
 * @author Clarence
 *
 */
public class CustomCredentialsProvider extends BasicCredentialsProvider {

	public void setCredentials(Credentials credentials) {
		this.setCredentials(AuthScope.ANY, credentials);
	}

}
