package ca.skip.app.core;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import ca.skip.app.enums.AutomatorName;
import ca.skip.app.enums.Language;
import ca.skip.app.enums.PlatformName;
import ca.skip.app.enums.Scope;
import ca.skip.app.enums.SkipAPP;
import ca.skip.model.builder.DriverBuilder;
import ca.skip.model.builder.TestConfigurationBuilder;
import ca.skip.utils.Util;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class BaseTest {

	public static AndroidDriver<MobileElement> driver;
	private static final String EOL = System.getProperty("line.separator");

	public static StringBuilder logs = new StringBuilder();
	public static TestConfiguration testConfiguration;
	public static String valor;
	public static SkipAPP app;

	@Rule
	public TestName testName = new TestName();

	@Rule
	public TestWatcher watchman = new TestWatcher() {

		@Override
		protected void failed(Throwable e, Description description) {
			if (description != null) {
				logs.append(description);
			}
			if (e != null) {
				logs.append(' ');
				logs.append(e);
			}
			logs.append(" FAIL");
			logs.append(EOL);
		}

		@Override
		protected void succeeded(Description description) {
			if (description != null) {
				logs.append(description);
			}
			logs.append(" OK");
			logs.append(EOL);
		}
	};

	public static TestConfiguration getTestConfiguration() {
		return testConfiguration;
	}

	public static void setAppTest(SkipAPP appTest) {
		setDefaultConfigurationTest(appTest);
	}

	public static void setTestConfiguration(TestConfiguration testConfiguiration_) {
		testConfiguration = testConfiguiration_;
	}

	@After
	public void after() {
		if (driver != null) {
			try {
				Util.screenShot(driver, testName);
				driver.resetApp();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static TestConfiguration getDefaultConfigurationTest() {
		return testConfiguration;
	}

	public static void setDefaultConfigurationTest(SkipAPP app) {

		Scope scope = null;

		if (testConfiguration != null) {
			scope = testConfiguration.getScope();
		}

		setTestConfiguration(new TestConfigurationBuilder().withLanguage(Language.ENGLISH)
				.withScope((scope != null) ? scope : Scope.BY_FUNCTIONALITY)
				.withDriver(new DriverBuilder().withCapability_AutomatorName(AutomatorName.ANDROID)
						.withCapability_DeviceName(SkipAPP.ANDROID_EMULATOR_DEVICE_NAME)
						.withCapability_PlataformName(PlatformName.ANDROID).withCapability_AppName(app.getDescricao())
						.now())
				.now());

		setDriver(testConfiguration.getDriver());

	}

	public static void setDriver(AndroidDriver<MobileElement> driver) {
		BaseTest.driver = driver;
	}

	public static void closeConnection(Scope scope) {
		if (getTestConfiguration().getScope().equals(scope)) {
			if (driver != null) {
				try {
					Util.saveLog(driver, logs.toString());
					driver.quit();
					driver = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
