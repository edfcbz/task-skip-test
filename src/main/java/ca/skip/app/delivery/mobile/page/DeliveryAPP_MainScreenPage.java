package ca.skip.app.delivery.mobile.page;

import ca.skip.app.core.BasePage;
import ca.skip.app.core.TestConfiguration;
import ca.skip.utils.Property;

public class DeliveryAPP_MainScreenPage extends BasePage {
	
	public DeliveryAPP_MainScreenPage(TestConfiguration testConfiguration) {
		super(testConfiguration);
	}

	public void acessDeliveryItem() {
		dsl.clickByText(Property.getProp( getLanguage(), "app.delivery.main.screen.button.delivery.text"));
		dsl.waitUntilShowFieldOnTheScreen(Property.getProp( getLanguage(), "app.delivery.subpage.delivery.address.field.text"));
	}

	public void acessPickUpItem() {
		dsl.clickByText(Property.getProp( getLanguage(), "app.delivery.main.screen.button.pickup.text"));
	}

	public void acessSingUpItem() {
		dsl.clickByText(Property.getProp( getLanguage(), "app.delivery.main.screen.option.signup.text"));
		dsl.waitUntilShowFieldOnTheScreen( Property.getProp( getLanguage(), "app.delivery.signup.page.top.message"));
	}

	public void acessLoginItem() {
		dsl.clickByText(Property.getProp( getLanguage(), "app.delivery.main.screen.option.login.text"));
		dsl.waitUntilShowFieldOnTheScreen(Property.getProp( getLanguage(), "app.delivery.login.google.field.text"));
	}

	public void loadingPage() {
		dsl.waitUntilShowFieldOnTheScreen(Property.getProp( getLanguage(), "app.delivery.main.screen.option.login.text"));
	}
	
	@Override
	public boolean verifyIsPage() {
		if (	dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.main.screen.button.delivery.text")) &&
				dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.main.screen.button.pickup.text")) &&	
				dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.main.screen.message.first.step")) &&
				dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.main.screen.message.second.step")) &&				
				dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.main.screen.option.signup.text")) &&				
				dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.main.screen.option.login.text"))) {
			return true;
		}else {
			return false;
		}	
	}

}	
