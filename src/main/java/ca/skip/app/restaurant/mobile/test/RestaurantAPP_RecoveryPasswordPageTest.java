package ca.skip.app.restaurant.mobile.test;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.skip.app.core.BaseTest;
import ca.skip.app.enums.Scope;
import ca.skip.app.enums.SkipAPP;
import ca.skip.app.restaurant.mobile.page.RestaurantAPP_LoginPage;
import ca.skip.app.restaurant.mobile.page.RestaurantAPP_MainScreenPage;
import ca.skip.app.restaurant.mobile.page.RestaurantAPP_RecoverPasswordPage;
import ca.skip.model.builder.RestaurantBuilder;
import ca.skip.models.Restaurant;

/*
 * Important Information: Internet connection is required for testing 
 * */
public class RestaurantAPP_RecoveryPasswordPageTest extends BaseTest {

	public static RestaurantAPP_MainScreenPage mainPage;
	public static RestaurantAPP_LoginPage loginPage;
	public static RestaurantAPP_RecoverPasswordPage recoveryPasswordPage;

	@BeforeClass
	public synchronized static void beforeClass() {

		setAppTest(SkipAPP.RESTAURANT_ANDROID_APP_LOCAL_PATH);

		mainPage = new RestaurantAPP_MainScreenPage(getDefaultConfigurationTest());
		loginPage = new RestaurantAPP_LoginPage(getDefaultConfigurationTest());
		recoveryPasswordPage = new RestaurantAPP_RecoverPasswordPage(getDefaultConfigurationTest());
	}

	@Before
	public synchronized void before() {
		mainPage.waintingLoad(60);
		mainPage.acessLogInItem();
		loginPage.selectRecoverPasswordOption();
	}


	@Test
	public synchronized void verifyIsRecoveryPasswordPageTest() {
		assertTrue(recoveryPasswordPage.verifyIsPage());
	}
	
	
	@Test
	public synchronized void verifyRecoveryPasswordPage_emailInvalidFortatTest() {
		Restaurant restaurant = new RestaurantBuilder().withEmail("invalidEmail@@com.ca").now();

		recoveryPasswordPage.fillEmailFields(restaurant);
		recoveryPasswordPage.selectRecoverPasswordOption();
		assertTrue(recoveryPasswordPage.recoveryEmailInvalidFormatMessage());
	}
	
	@Test
	public synchronized void verifyRecoveryPasswordPage_emailMAndatoryFieldTest() {
		recoveryPasswordPage.selectRecoverPasswordOption();
		assertTrue(recoveryPasswordPage.recoveryEmailMandatoryMessage());
	}	

	@AfterClass
	public synchronized static void afterClass() {
		closeConnection(Scope.BY_FUNCTIONALITY);
	}

}
