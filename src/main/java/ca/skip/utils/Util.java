package ca.skip.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ca.skip.app.enums.SkipAPP;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Util {

	@SuppressWarnings("deprecation")
	public static void saveLog(AndroidDriver<MobileElement> driver, String logs) throws IOException {
		
		String app = getApplicationLogPath(driver);
		
		try {
			// Cria arquivo
			Date data = new Date();
			int ano = data.getYear();
			int mes = data.getMonth();
			int dia = data.getDay();
			int hora = data.getHours();
			int minuto = data.getMinutes();
			int segundo = data.getSeconds();

			String dataLog = "year" + (1900 + ano) + "_month" + mes + "_day" + dia + "_hour" + hora + "_minute" + minuto
					+ "_seconds" + segundo + "_log.txt";

			File file = new File(app + dataLog);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(logs);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean compareImage(String image1Path, String image2Path, int variation) {

		File file1 = new File(image1Path);
		File file2 = new File(image2Path);

		boolean result;

		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			FileReader fr = new FileReader(file1);
			FileWriter fw = new FileWriter(file2);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			char[] buf = new char[1024];
			int bytesRead;
			while ((bytesRead = br.read(buf)) > 0) {
				bw.write(buf, 0, bytesRead);
			}
			result = true;
			bw.flush();
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public static void screenShot(AndroidDriver<MobileElement> driver, TestName testName) throws IOException {

		String path = getApplicationScreenShotPath(driver);

		try {
			File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(image, new File(path + testName.getMethodName() + ".jpg"));
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public static String getApplicationScreenShotPath(AndroidDriver<MobileElement> driver) throws IOException {

		String app = driver.getCapabilities().getCapability("applicationName").toString();

		if (app.equals(Property.getProp("skip.app.delivery.apk"))) {
			app = SkipAPP.DELIVERY_ANDROID_SCREENSHOT_PATH.getDescricao();
		} else if (app.equals(Property.getProp("skip.app.restaurant.apk"))) {
			app = SkipAPP.RESTAURANT_ANDROID_SCREENSHOT_PATH.getDescricao();
		} else if (app.equals(Property.getProp("skip.app.courrier.apk"))) {
			app = SkipAPP.COURRIER_ANDROID_SCREENSHOT_PATH.getDescricao();
		}

		return app;
	}

	public static String getApplicationLogPath(AndroidDriver<MobileElement> driver) throws IOException {

		String app = driver.getCapabilities().getCapability("applicationName").toString();

		if (app.equals(Property.getProp("skip.app.delivery.apk"))) {
			app = SkipAPP.DELIVERY_ANDROID_LOG_PATH.getDescricao();
		} else if (app.equals(Property.getProp("skip.app.restaurant.apk"))) {
			app = SkipAPP.RESTAURANT_ANDROID_LOG_PATH.getDescricao();
		} else if (app.equals(Property.getProp("skip.app.courrier.apk"))) {
			app = SkipAPP.COURRIER_ANDROID_LOG_PATH.getDescricao();
		}

		return app;
	}


}
