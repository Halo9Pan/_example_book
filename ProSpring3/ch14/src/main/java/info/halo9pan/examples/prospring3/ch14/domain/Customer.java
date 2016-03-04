/**
 * Created on Nov 21, 2011
 */
package info.halo9pan.examples.prospring3.ch14.domain;

import info.halo9pan.examples.prospring3.ch14.jsr303.validator.CheckIndividualCustomer;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Clarence
 *
 */
// @CheckIndividualCustomer
public class Customer {

	@NotNull
	@Size(min = 2, max = 60)
	private String firstName;

	private String lastName;

	@NotNull
	private CustomerType customerType;

	private Gender gender;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isIndividualCustomer() {
		return this.customerType.equals(CustomerType.INDIVIDUAL);
	}

	@AssertTrue(message = "Individual customer should have gender and last name defined")
	private boolean isValidIndividualCustomer() {

		boolean result = true;

		if (getCustomerType() != null && (isIndividualCustomer() && (gender == null || lastName == null)))
			result = false;

		return result;
	}

}
