package ca.skip.app.delivery.mobile.page;

import ca.skip.app.core.BasePage;
import ca.skip.app.core.TestConfiguration;
import ca.skip.app.enums.WaitTime;
import ca.skip.utils.Property;

public class DeliveryAPP_LoginPage extends BasePage {

	public DeliveryAPP_LoginPage(TestConfiguration testConfiguration) {
		super(testConfiguration);
	}
	
	@Override
	public boolean verifyIsPage() {	
		this.wait(WaitTime.FIVE_SECONDS);
		if ( dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.login.page.top.field.text")) &&
			 dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.login.google.field.text")) &&	
			 dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.login.facebook.field.text")) &&
			 dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.login.email.field.text")) &&
			 dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.login.password.field.text")) &&
			 dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.login.button.cancel.text")) &&
			 dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.login.button.login.text"))) {
			return true;
		}else {
			return false;
		}				 
	}
	
	public boolean isGooglePopup() {
		return dsl.existElementByText(
				Property.getProp( getLanguage(), "app.delivery.login.google.popup.message"));
	}

	public boolean isFacebookPopup() {
		dsl.waitUntilShowFieldOnTheScreen( Property.getProp( getLanguage(), "app.delivery.login.facebook.popup.message"), 30);
		return dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.login.facebook.popup.message"));
	}

	public void setEmail(String emaiText) {
		dsl.findElementByTextAndWriteInside( Property.getProp( getLanguage(), "app.delivery.login.email.field.text"), emaiText);
	}

	public void setEmail() {
		dsl.findElementByTextAndWriteInside(Property.getProp( getLanguage(), "app.delivery.login.email.field.text"),
				                            Property.getProp( getLanguage(), "app.delivery.login.email.field.text.default"));
	}

	public void setPassword(String passwordText) {
		dsl.findElementByTextAndWriteInside(Property.getProp( getLanguage(), "app.delivery.login.password.field.text"),
				passwordText);
	}

	public void setPassword() {
		dsl.findElementByTextAndWriteInside(
				Property.getProp( getLanguage(), "app.delivery.login.password.field.text"),
				Property.getProp( getLanguage(), "app.delivery.login.password.field.text.default"));
	}

	public void acessGoogleSignInItem() {
		dsl.clickByText( Property.getProp( getLanguage(), "app.delivery.login.google.field.text"));
		dsl.waitUntilShowFieldOnTheScreen(Property.getProp( getLanguage(), "app.delivery.login.google.popup.message"));
	}

	public void acessFacebookLogInItem() {
		dsl.waitUntilShowFieldOnTheScreen(Property.getProp( getLanguage(), "app.delivery.login.facebook.field.text"));
		dsl.clickByText( Property.getProp( getLanguage(), "app.delivery.login.facebook.field.text"));
	}

	public void acessLoginButton() {
		dsl.clickByText(Property.getProp( getLanguage(), "app.delivery.login.button.login.text"));
	}

	public void acessCancelButton() {
		this.wait(WaitTime.FIVE_SECONDS);
		dsl.clickByText(Property.getProp( getLanguage(), "app.delivery.login.button.cancel.text"));
		this.wait(WaitTime.FIVE_SECONDS);
	}

}
