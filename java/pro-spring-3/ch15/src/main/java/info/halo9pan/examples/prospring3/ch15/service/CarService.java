/**
 * Created on Nov 21, 2011
 */
package info.halo9pan.examples.prospring3.ch15.service;

import info.halo9pan.examples.prospring3.ch15.domain.Car;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface CarService {

	public List<Car> findAll();

	public Car save(Car car);

	public void updateCarAgeJob();

}
