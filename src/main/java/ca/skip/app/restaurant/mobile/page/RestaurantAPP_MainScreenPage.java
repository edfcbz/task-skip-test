package ca.skip.app.restaurant.mobile.page;

import ca.skip.app.core.BasePage;
import ca.skip.app.core.TestConfiguration;
import ca.skip.utils.Property;

public class RestaurantAPP_MainScreenPage extends BasePage {
	
	public RestaurantAPP_MainScreenPage(TestConfiguration testConfiguration) {
		super(testConfiguration);
	}

	public void existMessageErro() {
		if (dsl.existElementByText(	Property.getProp(getLanguage(), "app.restaurant.mainpage.message.connection.error"))) {
			dsl.clickByText(Property.getProp(getLanguage(),  "app.restaurant.mainpage.message.connection.button.text"));
		}
	}

	@Override
	public boolean verifyIsPage() {
		if (dsl.existElementByText(	Property.getProp(getLanguage(),  "app.restaurant.mainpage.description.text")) && 
			dsl.existElementByText(	Property.getProp(getLanguage(),  "app.restaurant.mainpage.login.text")))
			return true;
		else
			return false;
	}

	public void waintingLoad(int seconds) {
		dsl.waitUntilShowFieldOnTheScreen( Property.getProp(getLanguage(),  "app.restaurant.mainpage.login.text"), seconds);
	}

	public void waintingLoad() {
		dsl.waitUntilShowFieldOnTheScreen( Property.getProp(getLanguage(),  "app.restaurant.mainpage.login.text"), 60);
	}

	public void acessLogInItem() {
		dsl.clickByText( Property.getProp( getLanguage(),  "app.restaurant.mainpage.login.text"));
		dsl.waitUntilShowFieldOnTheScreen( Property.getProp( getLanguage(),  "app.restaurant.login.page.recovery.password.text"));
	}

}
