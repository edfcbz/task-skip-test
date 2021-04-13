package ca.skip.app.restaurant.mobile.page;

import ca.skip.app.core.BasePage;
import ca.skip.app.core.TestConfiguration;
import ca.skip.models.Restaurant;
import ca.skip.utils.Property;

public class RestaurantAPP_RecoverPasswordPage extends BasePage {
	
	public RestaurantAPP_RecoverPasswordPage(TestConfiguration testConfiguration) {
		super(testConfiguration);
	}
		
	@Override
	public boolean verifyIsPage() {
		dsl.waitUntilShowFieldOnTheScreen( Property.getProp( getLanguage(), "app.restaurant.recovery.page.button.text"));
		if (	dsl.existElementByText( Property.getProp( getLanguage(), "app.restaurant.recovery.page.main.message")) &&	
				dsl.existElementByText( Property.getProp( getLanguage(), "app.restaurant.recovery.page.email.text")) &&
				dsl.existElementByText( Property.getProp( getLanguage(), "app.restaurant.recovery.page.button.text"))) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
	public void selectRecoverPasswordOption() {
		dsl.clickByText( Property.getProp( getLanguage(), "app.restaurant.recovery.page.button.text"));
	}

	public boolean recoveryEmailMandatoryMessage() {
		return dsl.existElementByText( Property.getProp( getLanguage(), "app.restaurant.recovery.page.email.mandatory.message"));
	}

	public boolean recoveryEmailInvalidFormatMessage() {
		return dsl.existElementByText( Property.getProp( getLanguage(), "app.restaurant.recovery.page.email.invalid.message"));
	}

	public void fillEmailFields(Restaurant restaurant) {
		dsl.findElementByClass( Property.getProp( "app.restaurant.recovery.page.email.field.class")).sendKeys(restaurant.getEmail());
	}

}
