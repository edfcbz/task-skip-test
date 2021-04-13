package ca.skip.app.delivery.mobile.test;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.skip.app.core.BaseTest;
import ca.skip.app.core.TestConfiguration;
import ca.skip.app.delivery.mobile.page.DeliveryAPP_DeliveryPage;
import ca.skip.app.delivery.mobile.page.DeliveryAPP_MainScreenPage;
import ca.skip.app.enums.Scope;
import ca.skip.app.enums.SkipAPP;
import ca.skip.app.enums.WaitTime;

/*
 * Important Information: Internet connection is required for testing 
 * */
public class DeliveryAPP_DeliveryPageTest extends BaseTest {

	static DeliveryAPP_MainScreenPage mainPage;
	static DeliveryAPP_DeliveryPage deliveryPage;
	static TestConfiguration testConfiguration;

	@BeforeClass
	public static synchronized void beforeTest() {

		setAppTest(SkipAPP.DELIVERY_ANDROID_APP_LOCAL_PATH);

		mainPage = new DeliveryAPP_MainScreenPage(getDefaultConfigurationTest());
		deliveryPage = new DeliveryAPP_DeliveryPage(getDefaultConfigurationTest());
	}

	@Before
	public synchronized void before() {
		mainPage.loadingPage();
		mainPage.acessDeliveryItem();
	}

	@Test
	public synchronized void verifyIsPage() {
		assertTrue(deliveryPage.verifyIsPage());
	}
	
	@Test
	public synchronized void verifyDeliveryButtonActions() {

		deliveryPage.setAddress("136 Market Ave #800, Winnipeg, MB R3B 0P4, Canada");
		deliveryPage.selectSearchAddressButton();

		deliveryPage.verifyAccessLocationMessage();

		assertTrue(deliveryPage.isThereUseThisAddressText());

	}
	
	

	@AfterClass
	public synchronized static void afterClass() {
		closeConnection(Scope.BY_FUNCTIONALITY);
	}

}
