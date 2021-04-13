package ca.skip.app.delivery.mobile.test;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.skip.app.core.BaseTest;
import ca.skip.app.delivery.mobile.page.DeliveryAPP_MainScreenPage;
import ca.skip.app.delivery.mobile.page.DeliveryAPP_SignUpPage;
import ca.skip.app.enums.Scope;
import ca.skip.app.enums.SkipAPP;
import ca.skip.app.enums.WaitTime;
import ca.skip.model.builder.CustomerBuilder;
import ca.skip.models.Customer;

/*
 * Important Information: Internet connection is required for testing 
 * */
public class DeliveryAPP_SignUpPageTest extends BaseTest {

	private static DeliveryAPP_MainScreenPage mainPage;
	private static DeliveryAPP_SignUpPage signUpPage;

	@BeforeClass
	public synchronized static void beforeTest() {

		setAppTest(SkipAPP.DELIVERY_ANDROID_APP_LOCAL_PATH);

		mainPage = new DeliveryAPP_MainScreenPage(getDefaultConfigurationTest());
		signUpPage = new DeliveryAPP_SignUpPage(getDefaultConfigurationTest());
	}

	@Before
	public synchronized void before() {
		mainPage.loadingPage();
		mainPage.acessSingUpItem();
	}

	@Test
	public synchronized void verifyIsPage() {
		assertTrue(signUpPage.verifyIsPage());
	}

	@Test
	public synchronized void verifyEmailFormat() {
		Customer customer = new CustomerBuilder().withEmail("email@@gmail.com").now();

		signUpPage.fillCustomerFields(customer);

		signUpPage.acessSignUpButton();
		assertTrue(signUpPage.invalidEmail());

	}

	@Test
	public synchronized void verifyPasswordSize() {
		Customer customer = new CustomerBuilder().withPassword("1234").withPasswordConfirm("1234").now();

		signUpPage.fillCustomerFields(customer);

		signUpPage.acessSignUpButton();
		assertTrue(signUpPage.invalidPasswordSize());

	}

	@Test
	public synchronized void verifyDifferentPassword() {
		// Curtumer with invalid email
		Customer customer = new CustomerBuilder().withPassword("123456").withPasswordConfirm("123457").now();

		signUpPage.fillCustomerFields(customer);

		signUpPage.acessSignUpButton();
		assertTrue(signUpPage.invalidPasswordMatch());

	}

	@Test
	public synchronized void verifyMandatoryField_name() {
		Customer customer = new CustomerBuilder().withName("").now();

		signUpPage.fillCustomerFields(customer);

		signUpPage.acessSignUpButton();
		assertTrue(signUpPage.informedNameMandatoryMessage());

	}

	@Test
	public synchronized void verifyMandatoryField_email() {
		Customer customer = new CustomerBuilder().withEmail("").now();

		signUpPage.fillCustomerFields(customer);

		signUpPage.acessSignUpButton();
		assertTrue(signUpPage.informedEmailMandatoryMessage());

	}

	@Test
	public synchronized void verifyMandatoryField_phone() {
		Customer customer = new CustomerBuilder().withPhone("").now();

		signUpPage.fillCustomerFields(customer);

		signUpPage.acessSignUpButton();
		assertTrue(signUpPage.informedPhoneMandatoryMessage());

	}

	@Test
	public synchronized void verifyMandatoryField_password() {
		Customer customer = new CustomerBuilder().withPassword("").now();

		signUpPage.fillCustomerFields(customer);

		signUpPage.acessSignUpButton();
		assertTrue(signUpPage.informedPasswordMandatoryMessage());

	}

	@Test
	public synchronized void verifyMandatoryField_confirmPassword() {
		Customer customer = new CustomerBuilder().withPasswordConfirm("").now();

		signUpPage.fillCustomerFields(customer);

		signUpPage.acessSignUpButton();
		assertTrue(signUpPage.informedPasswordConfirmMandatoryMessage());

	}

	@AfterClass
	public synchronized static void afterClass() {
		closeConnection(Scope.BY_FUNCTIONALITY);
	}

}
