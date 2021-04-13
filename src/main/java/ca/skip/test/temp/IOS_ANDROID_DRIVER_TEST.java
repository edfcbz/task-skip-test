package ca.skip.test.temp;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;


public class IOS_ANDROID_DRIVER_TEST {

	// app para testes
	//File app = new File("app/FasTip.apk");
	
	@Test
	public void calcularGorjeta() throws MalformedURLException, InterruptedException {
		
		
		String andtroid = "D:/eclipse-workspace/SkipAppsTest/resources/apks/FasTip.apk";
		String ios = "D:/eclipse-workspace/SkipAppsTest/resources/apks/FasTip.app";
		
		
		// capacidades para execucao
		DesiredCapabilities	 dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_28");
		dc.setCapability(MobileCapabilityType.APP, andtroid);
		//dc.setCapability(MobileCapabilityType.APP, ios);
		
		// abrir conexao com dispostivo (sessao)
		AndroidDriver<MobileElement> driver = 
				new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		// interacao com componentes
		driver.findElement(By.id("org.traeg.fastip:id/billAmtEditText")).sendKeys("100");
		driver.findElement(By.id("org.traeg.fastip:id/calcTipButton")).click();
		
		// obtendo os textos da tela
		String percentual = driver.findElement(By.id("org.traeg.fastip:id/tipPctTextView")).getText();
		String valor = driver.findElement(By.id("org.traeg.fastip:id/tipAmtTextView")).getText();
		String total = driver.findElement(By.id("org.traeg.fastip:id/totalAmtTextView")).getText();
		
		// validacao (resultado esperado)
		assertEquals("15.0%", percentual);
		assertEquals("$15.00", valor);
		assertEquals("$115.00", total);
				
		// fechar a app
		driver.quit();
	}
	
	
}
