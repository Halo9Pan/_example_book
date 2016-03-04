/**
 * Created on Nov 21, 2011
 */
package info.halo9pan.examples.prospring3.ch15.schedule;

import info.halo9pan.examples.prospring3.ch15.service.AsyncService;

import java.util.concurrent.Future;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class AsyncTaskSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:async-app-context.xml");
		ctx.refresh();

		AsyncService asyncService = ctx.getBean("asyncService", AsyncService.class);

		for (int i = 0; i < 5; i++)
			asyncService.asyncTask();

		Future<String> result1 = asyncService.asyncWithReturn("Clarence");
		Future<String> result2 = asyncService.asyncWithReturn("John");
		Future<String> result3 = asyncService.asyncWithReturn("Robert");

		try {
			Thread.sleep(6000);

			System.out.println("Result1: " + result1.get());
			System.out.println("Result2: " + result2.get());
			System.out.println("Result3: " + result3.get());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
