package ca.skip.app.restaurant.mobile.test;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.skip.app.core.BaseTest;
import ca.skip.app.core.TestConfiguration;
import ca.skip.app.enums.Scope;
import ca.skip.app.enums.SkipAPP;
import ca.skip.app.restaurant.mobile.page.RestaurantAPP_LoginPage;
import ca.skip.app.restaurant.mobile.page.RestaurantAPP_MainScreenPage;
import ca.skip.app.restaurant.mobile.page.RestaurantAPP_RecoverPasswordPage;

/*
 * Important Information: Internet connection is required for testing 
 * */
public class RestaurantAPP_LoginPageTest extends BaseTest {

	static RestaurantAPP_MainScreenPage mainPage;
	static RestaurantAPP_LoginPage loginPage;
	static RestaurantAPP_RecoverPasswordPage recoveryPasswordPage;
	static TestConfiguration testConfiguration;

	@BeforeClass
	public synchronized static void beforeTest() {

		setAppTest(SkipAPP.RESTAURANT_ANDROID_APP_LOCAL_PATH);

		mainPage = new RestaurantAPP_MainScreenPage(getDefaultConfigurationTest());
		loginPage = new RestaurantAPP_LoginPage(getDefaultConfigurationTest());
	}

	@Before
	public synchronized void before() {
		mainPage.waintingLoad(60);
		mainPage.acessLogInItem();
	}

	@Test
	public synchronized void verifyIsLoginPageTest() {
		assertTrue(loginPage.verifyIsPage());
	}

	@Test
	public synchronized void verifyLoginPageMandatoryFieldsTest() {
		loginPage.selectLogInOption();
		assertTrue(loginPage.allMandatoryFieldsMessage());
	}
	
	@AfterClass
	public synchronized static void afterClass() {
		closeConnection(Scope.BY_FUNCTIONALITY);

	}

}
