/**
 * Created on Dec 29, 2011
 */
package info.halo9pan.examples.prospring3.ch18.repository;

import info.halo9pan.examples.prospring3.ch18.domain.Hobby;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Clarence
 *
 */
public interface HobbyRepository extends CrudRepository<Hobby, String> {

}
