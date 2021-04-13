package ca.skip.model.builder;

import org.openqa.selenium.remote.DesiredCapabilities;

import ca.skip.app.enums.AutomatorName;
import ca.skip.app.enums.PlatformName;
import ca.skip.app.enums.SkipAPP;
import ca.skip.utils.Property;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverBuilder  {

	public DesiredCapabilities desiredCapabilities;
	
	public String applicationName= Property.getProp("desired.capability.plataformname.android");
	public String platform       = Property.getProp("desired.capability.plataformname.android");
	public String platformName   = Property.getProp("desired.capability.plataformname.android");
	public String deviceName     = Property.getProp("desired.capability.devicename.android");
	public String automatorName  = Property.getProp("desired.capability.automatorname.android");
	public String appName        = Property.getProp("desired.capability.mobile.capability.type");
	public String appDescription = "appDescription";
	
	public DriverBuilder() {
		desiredCapabilities = new DesiredCapabilities();
	}	
	
	public DriverBuilder oneDesiredCapability(DesiredCapabilities _desiredCapabilities) {
		desiredCapabilities = _desiredCapabilities;
		return this;
	}	
	
	public DriverBuilder withCapability_PlataformName(PlatformName plataformName) {
		desiredCapabilities.setCapability("platformName", plataformName.getDescricao());
		return this;
	}
	
	public DriverBuilder withCapability_DeviceName(SkipAPP deviceName) {
		desiredCapabilities.setCapability("deviceName", deviceName.getDescricao());
		return this;
	}	
	
	public DriverBuilder withCapability_AutomatorName(AutomatorName automatorName) {
		desiredCapabilities.setCapability("automationName", automatorName.getDescricao()); 
		return this;
	}	
	
	public DriverBuilder withCapability_AppName(String app) {		
		desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
		desiredCapabilities.setCapability("applicationName" , getApplicationName(app));
		return this;
	}

	public DesiredCapabilities now() {
		return desiredCapabilities;
	}
	
	
	public String getApplicationName(String app) {
		String temp = app;
		String appName = "";
		for ( int i = temp.length()-1; i > 0; i-- ) {
			if ( temp.charAt(i) == '/'  )
				break;
			appName = temp.charAt(i)+appName;
		}
		return appName;
	}
}
