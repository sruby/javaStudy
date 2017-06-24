package io.github.sruby.spring.jpa.guide;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

/**
 * Define a simple entity.
 * The Customer class is annotated with @Entity, indicating that it is a JPA entity. 
 * For lack of a @Table annotation, it is assumed that this entity will be mapped to a table named Customer.
 * @author liuwf on Jun 24, 2017 5:17:18 PM
 */
@Entity
public class Customer
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	
	/**
	 * The default constructor only exists for the sake of JPA. You won’t use it directly, so it is designated as protected. 
	 */
	protected Customer()
	{
	}
	
	public Customer(String firstName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
