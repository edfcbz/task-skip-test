package ca.skip.app.restaurant.mobile.page;

import ca.skip.app.core.BasePage;
import ca.skip.app.core.TestConfiguration;
import ca.skip.utils.Property;

public class RestaurantAPP_LoginPage extends BasePage {

	public RestaurantAPP_LoginPage(TestConfiguration testConfiguration) {
		super(testConfiguration);
	}

	@Override
	public boolean verifyIsPage() {
		dsl.waitUntilShowFieldOnTheScreen(Property.getProp(getLanguage(), "app.restaurant.login.page.top.label"));
		if (dsl.existElementByText(Property.getProp(getLanguage(), "app.restaurant.login.page.top.label"))
				&& dsl.existElementByText(Property.getProp(getLanguage(), "app.restaurant.login.page.main.message"))
				&& dsl.existElementByText(Property.getProp(getLanguage(), "app.restaurant.login.page.password.text"))
				&& dsl.existElementByText(Property.getProp(getLanguage(), "app.restaurant.login.page.button.text"))
				&& dsl.existElementByText(
						Property.getProp(getLanguage(), "app.restaurant.login.page.recovery.password.text")))
			return true;
		else
			return false;
	}

	public void selectGooglelink() {
		dsl.clickByText( Property.getProp(getLanguage(), "app.delivery.login.google.field.text"));
	}	
	
	public void selectLogInOption() {
		dsl.clickByText( Property.getProp(getLanguage(), "app.restaurant.login.page.button.text"));
	}

	public void selectRecoverPasswordOption() {
		dsl.clickByText( Property.getProp(getLanguage(), "app.restaurant.login.page.recovery.password.text"));
		dsl.waitUntilShowFieldOnTheScreen( Property.getProp(getLanguage(), "app.restaurant.recovery.page.button.text"));
	}

	public void setUsernameValue(String name) {
		dsl.findElementByTextAndWriteInside( Property.getProp(getLanguage(), "app.restaurant.login.page.email.field"), name);
	}

	public void setPasswordValue(String Password) {
		dsl.findElementByTextAndWriteInside( Property.getProp(getLanguage(), "app.restaurant.login.page.password"), Password);
	}

	public boolean isThereUsernameMandatoryFieldMessage() {
		return dsl.existElementByText( Property.getProp(getLanguage(), "app.restaurant.login.page.email.address.required"));
	}

	public boolean isTherePasswordMandatoryFieldMessage() {
		return dsl.existElementByText( Property.getProp(getLanguage(), "app.restaurant.login.page.password.required"));
	}

	public boolean allMandatoryFieldsMessage() {
		if (isThereUsernameMandatoryFieldMessage() && isTherePasswordMandatoryFieldMessage())
			return true;
		else
			return false;
	}

}
