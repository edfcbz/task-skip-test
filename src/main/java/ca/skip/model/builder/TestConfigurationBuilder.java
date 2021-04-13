package ca.skip.model.builder;

import org.openqa.selenium.remote.DesiredCapabilities;

import ca.skip.app.core.DriverFactory;
import ca.skip.app.core.TestConfiguration;
import ca.skip.app.enums.Language;
import ca.skip.app.enums.Scope;

public class TestConfigurationBuilder {
	public TestConfiguration testConfiguration;

	public TestConfigurationBuilder() {
		testConfiguration = new TestConfiguration();
		testConfiguration.language = Language.ENGLISH;

	}

	public TestConfigurationBuilder withLanguage(Language language) {
		testConfiguration.withLanguage(language);
		return this;
	}
	
	public TestConfigurationBuilder withScope(Scope scope) {
		testConfiguration.withScope(scope);
		return this;
	}	

	public TestConfigurationBuilder withDriver(DesiredCapabilities desiredCapabilities) {
		testConfiguration.setDriver(DriverFactory.getDriver(desiredCapabilities));		
		return this;
	}

	public TestConfiguration now() {
		return testConfiguration;
	}

}
