/**
 * Created on Dec 29, 2011
 */
package info.halo9pan.examples.prospring3.ch20.service;

import info.halo9pan.examples.prospring3.ch20.domain.Hobby;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface HobbyService {

	public List<Hobby> findAll();

}
