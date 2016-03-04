/**
 * Created on Nov 21, 2011
 */
package info.halo9pan.examples.prospring3.ch14.jsr303.validator;

import info.halo9pan.examples.prospring3.ch14.domain.Customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Clarence
 *
 */
public class IndividualCustomerValidator implements ConstraintValidator<CheckIndividualCustomer, Customer> {

	public void initialize(CheckIndividualCustomer constraintAnnotation) {
	}

	public boolean isValid(Customer customer, ConstraintValidatorContext context) {

		boolean result = true;

		if (customer.getCustomerType() != null && (customer.isIndividualCustomer() && (customer.getLastName() == null || customer
				.getGender() == null))) {
			result = false;
		}

		return result;
	}

}
