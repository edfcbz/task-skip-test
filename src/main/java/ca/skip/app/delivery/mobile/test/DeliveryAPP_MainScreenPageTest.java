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

/*
 * Important Information: Internet connection is required for testing 
 * */
public class DeliveryAPP_MainScreenPageTest extends BaseTest {
	
	static DeliveryAPP_MainScreenPage mainPage;
	static DeliveryAPP_DeliveryPage deliveryPage;
	static TestConfiguration testConfiguration;
	
	@BeforeClass
	public synchronized static void beforeTest(){
		
		setAppTest(SkipAPP.DELIVERY_ANDROID_APP_LOCAL_PATH);
		
		mainPage = new DeliveryAPP_MainScreenPage(getDefaultConfigurationTest());
	}
	
	
	@Before
	public synchronized void before() {
		mainPage.loadingPage();
	}
	
	
	@Test
	public synchronized void verifyIsPage() {
		assertTrue(mainPage.verifyIsPage());
	}	
	
	@AfterClass
	public synchronized static void afterClass() {
		closeConnection(Scope.BY_FUNCTIONALITY);
	}
	
}

