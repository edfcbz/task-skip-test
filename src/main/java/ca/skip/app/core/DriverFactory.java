package ca.skip.app.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import ca.skip.utils.Property;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverFactory{

	static Collection<AndroidDriver<MobileElement>> listAndroidDrivers = new ArrayList<>();
	static Collection<IOSDriver<WebElement>> listIOSDrivers = new ArrayList<>();
	static Collection<E<?>> drivers = new ArrayList<>(); //TODO create a generic list for IOS and Android drivers...

	@SuppressWarnings({ "unchecked", "hiding" })
	public static <E> E getDriver(DesiredCapabilities desiredCapabilities) {
		if (desiredCapabilities.getPlatform().name().equals("ANDROID")) {
			for (AndroidDriver<MobileElement> driverAndroid : listAndroidDrivers) {
				if (driverAndroid.getCapabilities().getCapability("applicationName").equals(desiredCapabilities.getCapability("applicationName"))) {
					return (E) driverAndroid;
				}
			}
		}
		return createDriver(desiredCapabilities);
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public static <E> E createDriver(DesiredCapabilities desiredCapabilities) {
		if (desiredCapabilities.getPlatform().name().equals("ANDROID")) {
			AndroidDriver<MobileElement> driverAndroid = null;
			
			try {
				driverAndroid = new AndroidDriver<MobileElement>(new URL(Property.getProp("drive.url")),desiredCapabilities);
				driverAndroid.manage().timeouts().implicitlyWait(Property.getPropAsInt("drive.manage.timeouts.implicitlyWait"), TimeUnit.SECONDS);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			listAndroidDrivers.add(driverAndroid);
			return (E) driverAndroid;

		} else {
			IOSDriver<WebElement> driverIOS = null;
			try {
				driverIOS = new IOSDriver<WebElement>(new URL(Property.getProp("drive.url")), desiredCapabilities);
				driverIOS.manage().timeouts().implicitlyWait(Property.getPropAsInt("drive.manage.timeouts.implicitlyWait"), TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			listIOSDrivers.add(driverIOS);
			return (E) driverIOS;
		}
	}

}
