package ca.skip.model.builder;

import ca.skip.models.Customer;

public class CustomerBuilder  {

	public static Customer customer;
	
	public CustomerBuilder() {
		customer = new Customer();
		withName("Default name");
		withPhone("(555) 555-5555");
		withEmail("default@gmail.com");
		withPassword("123456");
		withPasswordConfirm("123456");
		withCode("defaultCode");
	}	
	
	
	public  CustomerBuilder withName(String name) {
		customer.setName(name);
		return this;
	}
	
	public CustomerBuilder withPhone(String phone) {
		customer.setPhone(phone);
		return this;
	}
	
	public CustomerBuilder withEmail(String email) {
		customer.setEmail(email);
		return this;
	}
	public CustomerBuilder withPassword(String password) {
		customer.setPassword(password);
		return this;
	}
	
	public CustomerBuilder withPasswordConfirm(String passwordConfirm) {
		customer.setPasswordConfirm(passwordConfirm);
		return this;
	}
	public CustomerBuilder withCode(String code) {
		customer.setCode(code);
		return this;
	}

	public Customer now() {
		return customer;
	}
	

}
