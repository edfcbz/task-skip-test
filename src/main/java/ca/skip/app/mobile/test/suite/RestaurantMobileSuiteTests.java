package ca.skip.app.mobile.test.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ca.skip.app.core.BaseTest;
import ca.skip.app.enums.AutomatorName;
import ca.skip.app.enums.Language;
import ca.skip.app.enums.PlatformName;
import ca.skip.app.enums.Scope;
import ca.skip.app.enums.SkipAPP;
import ca.skip.app.restaurant.mobile.test.RestaurantAPP_LoginPageTest;
import ca.skip.app.restaurant.mobile.test.RestaurantAPP_MainScreenPageTest;
import ca.skip.app.restaurant.mobile.test.RestaurantAPP_RecoveryPasswordPageTest;
import ca.skip.model.builder.DriverBuilder;
import ca.skip.model.builder.TestConfigurationBuilder;

/*
 * Important Information: Internet connection is required for testing 
 * */
@RunWith(Suite.class)
@SuiteClasses({ RestaurantAPP_LoginPageTest.class, 
				RestaurantAPP_MainScreenPageTest.class,
				RestaurantAPP_RecoveryPasswordPageTest.class })
public class RestaurantMobileSuiteTests extends BaseTest {
	
	/*
	 * Before suite execution, create a new TestConfigiuration according your device, language etc.
	 * The TestConfiguration settings below, will run all Restaurant's test according it. 
	 * 
	 * */
	@BeforeClass
	public static void beforeClass() {
		setTestConfiguration(new TestConfigurationBuilder().
				withLanguage(Language.ENGLISH).
				withScope(Scope.BY_APPLICATION).
				withDriver(new DriverBuilder().
								withCapability_AppName(SkipAPP.RESTAURANT_ANDROID_APP_LOCAL_PATH.getDescricao()).
								withCapability_AutomatorName(AutomatorName.ANDROID).
								withCapability_DeviceName(SkipAPP.ANDROID_EMULATOR_DEVICE_NAME).
								withCapability_PlataformName(PlatformName.ANDROID).
								now()).
				now());
	}
	
	@AfterClass
	public synchronized static void afterClass() {
		closeConnection(Scope.BY_APPLICATION);
	}	
}
