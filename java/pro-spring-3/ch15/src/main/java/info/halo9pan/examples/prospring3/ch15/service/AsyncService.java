/**
 * Created on Nov 21, 2011
 */
package info.halo9pan.examples.prospring3.ch15.service;

import java.util.concurrent.Future;

/**
 * @author Clarence
 *
 */
public interface AsyncService {

	public void asyncTask();

	public Future<String> asyncWithReturn(String name);

}
