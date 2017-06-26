package io.github.sruby.spring.jpa.guide;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * https://spring.io/guides/gs/accessing-data-jpa/#initial
 * https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-jpa/
 * http://www.cnblogs.com/dreamroute/p/5173896.html
 * test
 * @author liuwf on Jun 24, 2017 6:21:42 PM
 */
public class Application
{
	@Autowired
	private static CustomerRepository customerRepository;
	public static void main(String[] args)
	{
		customerRepository.save(new Customer("a", "b"));
		List<Customer> findByLastName = customerRepository.findByLastName("b");
		System.out.println(findByLastName.toString());
	}
}
