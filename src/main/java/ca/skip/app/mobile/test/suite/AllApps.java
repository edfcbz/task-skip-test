package ca.skip.app.mobile.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DeliveryMobileSuiteTests.class, 
				RestaurantMobileSuiteTests.class })
public class AllApps {
	
}
