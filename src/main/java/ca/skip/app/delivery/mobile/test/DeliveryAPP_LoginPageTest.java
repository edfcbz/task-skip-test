package ca.skip.app.delivery.mobile.test;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.skip.app.core.BaseTest;
import ca.skip.app.delivery.mobile.page.DeliveryAPP_LoginPage;
import ca.skip.app.delivery.mobile.page.DeliveryAPP_MainScreenPage;
import ca.skip.app.enums.Scope;
import ca.skip.app.enums.SkipAPP;

/*
 * Important Information: Internet connection is required for testing 
 * */
public class DeliveryAPP_LoginPageTest extends BaseTest {

	private static DeliveryAPP_MainScreenPage mainPage;
	private static DeliveryAPP_LoginPage loginPage;

	@BeforeClass
	public synchronized static void beforeTest() {

		setAppTest(SkipAPP.DELIVERY_ANDROID_APP_LOCAL_PATH);

		mainPage = new DeliveryAPP_MainScreenPage(getDefaultConfigurationTest());
		loginPage = new DeliveryAPP_LoginPage(getDefaultConfigurationTest());

	}

	@Before
	public synchronized void before() {
		mainPage.loadingPage();
		mainPage.acessLoginItem();
	}

	@Test
	public synchronized void verifyIsLoginPage() {
		assertTrue(loginPage.verifyIsPage());
	}

	@Test
	public synchronized void verifyFacebookLink() {
		loginPage.acessFacebookLogInItem();
		assertTrue(loginPage.isFacebookPopup());
	}

	@Test
	public synchronized void verifyCancelAction() {
		loginPage.acessCancelButton();
		assertTrue(mainPage.verifyIsPage());
	}

	@AfterClass
	public synchronized static void afterClass() {
		closeConnection(Scope.BY_FUNCTIONALITY);
	}
}
