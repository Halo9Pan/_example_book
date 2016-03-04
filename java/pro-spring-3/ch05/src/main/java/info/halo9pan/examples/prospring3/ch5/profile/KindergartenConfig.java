/**
 * Created on Sep 26, 2011
 */
package info.halo9pan.examples.prospring3.ch5.profile;

import info.halo9pan.examples.prospring3.ch5.profile.kindergarten.FoodProviderServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Clarence
 *
 */
@Configuration
@Profile(value = "kindergarten")
public class KindergartenConfig {

	@Bean
	public FoodProviderService foodProviderService() {
		return new FoodProviderServiceImpl();
	}

}
