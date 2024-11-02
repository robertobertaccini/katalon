package refund
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import cucumber.api.PendingException
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Refund {

	@Given("I login with {string} and {string}")
	public void i_login_with_and(String string, String string2) {
		WebUI.setText(findTestObject('Object Repository/Login Page/input_User name_UserIdentifier'), String1)
		WebUI.setText(findTestObject('Object Repository/Login Page/input_Password_Password'), String2)
		WebUI.click(findTestObject('Object Repository/Login Page/button_Log in'))
	}

	@When("I create a new refund request")
	public void i_create_a_new_refund_request() {
		WebUI.click(findTestObject('Object Repository/User Portal/Plus'))
		WebUI.click(findTestObject('Object Repository/User Portal/New BookingCancellationDemo'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/BookingCancellation/PNR'), 10)
	}

	@When("I select PNR {string}")
	public void i_select_PNR(String string) {
		WebUI.click(findTestObject('BookingCancellation/i_pnr_pi pi-caret-down'))
		WebUI.click(findTestObject('BookingCancellation/li_NQ6077MCOAA6340'))
		WebUI.click(findTestObject('BookingCancellation/button_Continue'))
	}

	@Then("The passenger list contains {string} item")
	public void the_passenger_list_contains_item(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("i provide refunder email {string}")
	public void i_provide_refunder_email(String string) {
		WebUI.setText(findTestObject('BookingCancellation/Refunder Email'), string)
		WebUI.click(findTestObject('BookingCancellation/button_Create'))
	}

	@Then("the case is sent for approval")
	public void the_case_is_sent_for_approval() {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
}