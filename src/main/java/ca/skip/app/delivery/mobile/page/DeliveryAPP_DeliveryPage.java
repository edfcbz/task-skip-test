package ca.skip.app.delivery.mobile.page;

import ca.skip.app.core.BasePage;
import ca.skip.app.core.TestConfiguration;
import ca.skip.app.enums.WaitTime;
import ca.skip.utils.Property;

public class DeliveryAPP_DeliveryPage extends BasePage {

	public DeliveryAPP_DeliveryPage(TestConfiguration testConfiguration) {
		super(testConfiguration);
	}

	@Override
	public boolean verifyIsPage() {
		return dsl.existElementByText(Property.getProp( getLanguage(), "app.delivery.subpage.delivery.address.field.text"));
	}

	public void setAddress(String address) {
		dsl.writeText(dsl.findElementById(Property.getProp( "app.delivery.subpage.delivery.address.field.id")),address);
	}

	public void setAddress() {
		dsl.writeText(dsl.findElementById(Property.getProp( "app.delivery.subpage.delivery.address.field.id")),
					  Property.getProp( getLanguage(), "app.delivery.subpage.delivery.address.field.default"));
	}

	public void selectSearchAddressButton() {
		dsl.clickByIdAsString(Property.getProp( "app.delivery.subpage.delivery.search.icon.id"));
	}

	public void selectConfirmfThisAddress() {
		dsl.clickByText(Property.getProp( getLanguage(), "app.delivery.subpage.delivery.button.text"));

	}

	public boolean isThereUseThisAddressText() {
		return dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.subpage.delivery.button.text"));
	}

	public void verifyAccessLocationMessage() {
		this.wait(WaitTime.TWO_SECONDS);
		if (dsl.existElementByText( Property.getProp( getLanguage(), "app.delivery.subpage.delivery.alert.allow"))) {
			dsl.clickByText( Property.getProp( getLanguage(), "app.delivery.subpage.delivery.alert.allow"));
			this.wait(WaitTime.TWO_SECONDS);
		}

	}

}
