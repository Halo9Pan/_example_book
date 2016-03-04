/**
 * Created on Dec 29, 2011
 */
package info.halo9pan.examples.prospring3.ch18.service;

import info.halo9pan.examples.prospring3.ch18.domain.Hobby;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface HobbyService {

	public List<Hobby> findAll();

}
