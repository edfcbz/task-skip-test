package ca.skip.app.mobile.test.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ca.skip.app.core.BaseTest;
import ca.skip.app.delivery.mobile.test.DeliveryAPP_DeliveryPageTest;
import ca.skip.app.delivery.mobile.test.DeliveryAPP_LoginPageTest;
import ca.skip.app.delivery.mobile.test.DeliveryAPP_MainScreenPageTest;
import ca.skip.app.delivery.mobile.test.DeliveryAPP_SignUpPageTest;
import ca.skip.app.enums.AutomatorName;
import ca.skip.app.enums.Language;
import ca.skip.app.enums.PlatformName;
import ca.skip.app.enums.Scope;
import ca.skip.app.enums.SkipAPP;
import ca.skip.model.builder.DriverBuilder;
import ca.skip.model.builder.TestConfigurationBuilder;

/*
 * Important Information: Internet connection is required for testing 
 * */
@RunWith(Suite.class)
@SuiteClasses({	DeliveryAPP_MainScreenPageTest.class,
				DeliveryAPP_LoginPageTest.class,
				DeliveryAPP_DeliveryPageTest.class,
				DeliveryAPP_SignUpPageTest.class})
public class DeliveryMobileSuiteTests extends BaseTest {
	
	/*
	 * Before suite execution, create a new TestConfigiuration according your device, language etc.
	 * The TestConfiguration settings below, will run all Delivery's test according it. 
	 * 
	 * */	
	@BeforeClass
	public synchronized static void beforeClass() {
		
		setTestConfiguration(new TestConfigurationBuilder().
				withLanguage(Language.ENGLISH).
				withScope(Scope.BY_APPLICATION).
				withDriver(new DriverBuilder().
								withCapability_AppName(SkipAPP.DELIVERY_ANDROID_APP_LOCAL_PATH.getDescricao()).
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
