package ca.skip.app.core;

import ca.skip.app.enums.WaitTime;
import edfcbz.dsl.DSL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class BasePage {

	public AndroidDriver<MobileElement> driver;

	public String language;
	public DSL dsl;
	

	public BasePage(TestConfiguration testConfiguration) {
		this.driver = testConfiguration.getDriver();
		this.language = testConfiguration.getLanguage().getDescricao();
		dsl = new DSL(this.driver);
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <E> E getDriver() {
		return (E) driver;
	}

	public String getLanguage() {
		return language;
	}

	public DSL getDsl() {
		return dsl;
	}

	public void wait(WaitTime wait) {
		try {
			Thread.sleep(wait.getTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public abstract boolean verifyIsPage();

}
