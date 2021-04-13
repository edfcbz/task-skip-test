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
import ca.skip.app.restaurant.mobile.page.RestaurantAPP_MainScreenPage;

/*
 * Important Information: Internet connection is required for testing 
 * */
public class RestaurantAPP_MainScreenPageTest extends BaseTest {

	static RestaurantAPP_MainScreenPage mainPage;
	static TestConfiguration testConfiguration;

	@BeforeClass
	public synchronized static void beforeTest() {
		setAppTest(SkipAPP.RESTAURANT_ANDROID_APP_LOCAL_PATH);
		mainPage = new RestaurantAPP_MainScreenPage(getDefaultConfigurationTest());
	}

	@Before
	public synchronized void before() {
		mainPage.waintingLoad(60);
	}

	@Test
	public synchronized void verifyIsMainPage() {
		assertTrue(mainPage.verifyIsPage());
	}

	@AfterClass
	public synchronized static void afterClass() {
		closeConnection(Scope.BY_FUNCTIONALITY);

	}
}