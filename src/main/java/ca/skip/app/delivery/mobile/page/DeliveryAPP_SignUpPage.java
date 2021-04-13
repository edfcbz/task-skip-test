package ca.skip.app.delivery.mobile.page;

import ca.skip.app.core.BasePage;
import ca.skip.app.core.TestConfiguration;
import ca.skip.app.enums.WaitTime;
import ca.skip.models.Customer;
import ca.skip.utils.Property;

public class DeliveryAPP_SignUpPage extends BasePage {
	
	public DeliveryAPP_SignUpPage(TestConfiguration testConfiguration) {
		super(testConfiguration);
	}
	
	@Override
	public boolean verifyIsPage() {	
		if (	dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.page.top.message" ) ) &&
				dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.google.field.text" ) ) &&	
				dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.facebook.field.text" ) ) &&
				dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.name.field.text" ) ) &&				
				dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.email.field.text" ) ) &&	
				dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.phone.field.text" ) ) &&	
				dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.password.field.text" ) ) &&
				dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.passwordconfirm.field.text" ) ))
			return true;
		else
			return false;			
	}

	public void setName(String name) {
		dsl.writeTextById( Property.getProp( "app.delivery.signup.name.field.id"), name);

	}

	public void setEmail(String email) {
		dsl.writeTextById( Property.getProp( "app.delivery.signup.email.field.id"), email);
	}

	public void setPhone(String phone) {
		dsl.writeTextById( Property.getProp( "app.delivery.signup.phone.field.id"), phone);
	}

	public void setPassword(String password) {
		dsl.writeTextById( Property.getProp( "app.delivery.signup.password.field.id"), password);
	}

	public void setPasswordConfirm(String passwordConfirm) {
		dsl.writeTextById( Property.getProp( "app.delivery.signup.passwordconfirm.field.id"), passwordConfirm);
	}

	public void setCode(String code) {
		dsl.writeTextById( Property.getProp( "app.delivery.signup.referalcode.field.id"), code);
	}

	public void acessSignUpButton() {
		dsl.clickByText( Property.getProp( getLanguage(), "app.delivery.signup.button.text"));
		this.wait(WaitTime.THREE_SECONDS);
	}

	public boolean existMessageError() {
		return dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.resgister.error.message"));
	}

	public boolean invalidEmail() {
		return dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.email.text.invalid"));
	}

	public boolean invalidPasswordSize() {
		return dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.password.text.size.invalid"));
	}

	public boolean informedNameMandatoryMessage() {
		return dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.name.field.mandatory.message"));
	}

	public boolean informedEmailMandatoryMessage() {
		return dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.email.field.mandatory.message"));
	}

	public boolean informedPhoneMandatoryMessage() {
		return dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.phone.field.mandatory.message"));
	}

	public boolean informedPasswordConfirmMandatoryMessage() {
		return dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.signup.passwordconfirm.field.mandatory.message"));
	}

	public boolean invalidPasswordMatch() {
		return dsl.findElementByIdAndSubstring(Property.getProp( "app.delivery.signup.password.messagebox.id"),Property.getProp( getLanguage(), "app.delivery.signup.password.message.box.substring"));
	}

	public boolean informedPasswordMandatoryMessage() {
		return dsl.findElementByIdAndSubstring(
				Property.getProp( "app.delivery.signup.password.messagebox.id"),
				Property.getProp( getLanguage(), "app.delivery.signup.password.mandatory.messagebox.text"));
	}

	public void fillCustomerFields(Customer customer) {

			setName(customer.getName());
			setEmail(customer.getEmail());
			setPhone(customer.getPhone());
			setPassword(customer.getPassword());

			dsl.scroll(0.5, 0.1);

			setPasswordConfirm(customer.getPasswordConfirm());
			setCode(customer.getCode());			
	}

	public void closeKeyboard() {
		dsl.hideKeyboard();
	}

}
