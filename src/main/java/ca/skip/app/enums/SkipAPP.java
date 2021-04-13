package ca.skip.app.enums;

import ca.skip.utils.Property;

public enum SkipAPP {
	  DELIVERY_ANDROID_APP_LOCAL_PATH(    Property.getProp("skip.app.delivery.android.local.path")),
	  COURRIER_ANDROID_APP_LOCAL_PATH(    Property.getProp("skip.app.courrier.android.local.path")),
	  RESTAURANT_ANDROID_APP_LOCAL_PATH(  Property.getProp("skip.app.restaurant.android.local.path")),	
	  DELIVERY_IOS_APP_LOCAL_PATH(   	  Property.getProp("skip.app.delivery.ios.local.path")),
	  COURRIER_IOS_APP_LOCAL_PATH(   	  Property.getProp("skip.app.courrier.ios.local.path")),
	  RESTAURANT_IOS_APP_LOCAL_PATH( 	  Property.getProp("skip.app.restaurant.ios.local.path")),
	  
	  DELIVERY_ANDROID_APP_NAME(  	 Property.getProp("skip.app.delivery.apk")),
	  COURRIER_ANDROID_APP_NAME(  	 Property.getProp("skip.app.courrier.apk")),
	  RESTAURANT_ANDROID_APP_NAME(	 Property.getProp("skip.app.restaurant.apk")),
	  DELIVERY_IOS_APP_NAME(  		 Property.getProp("skip.app.delivery.ipa")),
	  COURRIER_IOS_APP_NAME(  		 Property.getProp("skip.app.courrier.ipa")),
	  RESTAURANT_IOS_APP_NAME(		 Property.getProp("skip.app.restaurant.ipa")),	  
	  
	  
	  ANDROID_EMULATOR_DEVICE_NAME( 	 Property.getProp("desired.capability.devicename.android")),
	  IOS_EMULATOR_DEVICDE_NAME(         Property.getProp("desired.capability.devicename.ios")),	  
	  WEB(     							 Property.getProp("desired.capability.devicename.web")),
	  
	  DELIVERY_ANDROID_LOG_PATH(  		 Property.getProp("logs.delivery.android") ),
	  COURRIER_ANDROID_LOG_PATH(  		 Property.getProp("logs.courrier.android")),
	  RESTAURANT_ANDROID_LOG_PATH(		 Property.getProp("logs.restaurant.android")),
	  DELIVERY_IOS_LOG_PATH(  			 Property.getProp("logs.delivery.ios") ),
	  COURRIER_IOS_LOG_PATH(  			 Property.getProp("logs.courrier.ios")),
	  RESTAURANT_IOS_LOG_PATH(			 Property.getProp("logs.restaurant.ios")),
	  
	  DELIVERY_ANDROID_SCREENSHOT_PATH(  Property.getProp("screenshots.delivery.android")),
	  COURRIER_ANDROID_SCREENSHOT_PATH(  Property.getProp("screenshots.courrier.android")),
	  RESTAURANT_ANDROID_SCREENSHOT_PATH(Property.getProp("screenshots.restaurant.android")),
	  DELIVERY_IOS_SCREENSHOT_PATH(   	 Property.getProp("screenshots.delivery.ios")),
	  COURRIER_IOS_SCREENSHOT_PATH(  	 Property.getProp("screenshots.courrier.ios")),
	  RESTAURANT_IOS_SCREENSHOT_PATH(	 Property.getProp("screenshots.restaurant.ios"));
	
    private String descricao;
 
	SkipAPP(String descricao) {
		this.descricao = descricao;
		getDescricao();
	}

	public String getDescricao() {
		return descricao;
	}

}