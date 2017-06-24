package io.github.sruby.spring.jpa.guide;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * create a repository interface that works with Customer entities
 * You don’t have to write an implementation of the repository interface. 
 * Spring Data JPA creates an implementation on the fly when you run the application.
 * @author liuwf on Jun 24, 2017 5:38:57 PM
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>
{
	List<Customer> findByLastName(String lastName);
}
