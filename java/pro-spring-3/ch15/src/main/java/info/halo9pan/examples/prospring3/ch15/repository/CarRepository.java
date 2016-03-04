/**
 * Created on Nov 21, 2011
 */
package info.halo9pan.examples.prospring3.ch15.repository;

import info.halo9pan.examples.prospring3.ch15.domain.Car;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Clarence
 *
 */
public interface CarRepository extends CrudRepository<Car, Long> {

}
