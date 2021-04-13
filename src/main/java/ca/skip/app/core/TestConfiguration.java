package ca.skip.app.core;

import ca.skip.app.enums.Language;
import ca.skip.app.enums.Scope;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestConfiguration {
	public Language language;
	public AndroidDriver<MobileElement> driver;
	public Scope scope;

	@SuppressWarnings("unchecked")
	public <E> E getDriver() {
		return (E) driver;
	}

	@SuppressWarnings("unchecked")
	public <E> void setDriver(E driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
	}

	public Language getLanguage() {
		return language;
	}

	public void withLanguage(Language language) {
		setLanguage(language);
	}

	public void withScope(Scope scope) {
		setScope(scope);
	}

	public Scope getScope() {
		return scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getDescriptionLanguage() {
		return language.getDescricao();
	}

	public String getDescriptionScope() {
		return scope.getDescricao();
	}

}
