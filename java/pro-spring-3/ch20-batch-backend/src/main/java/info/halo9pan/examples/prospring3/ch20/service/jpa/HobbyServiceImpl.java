/**
 * Created on Dec 29, 2011
 */
package info.halo9pan.examples.prospring3.ch20.service.jpa;

import info.halo9pan.examples.prospring3.ch20.domain.Hobby;
import info.halo9pan.examples.prospring3.ch20.repository.HobbyRepository;
import info.halo9pan.examples.prospring3.ch20.service.HobbyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

/**
 * @author Clarence
 *
 */
@Service("hobbyService")
@Repository
@Transactional
public class HobbyServiceImpl implements HobbyService {

	@Autowired
	private HobbyRepository hobbyRepository;

	@Transactional(readOnly = true)
	public List<Hobby> findAll() {
		return Lists.newArrayList(hobbyRepository.findAll());
	}

}
