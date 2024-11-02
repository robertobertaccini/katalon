package fm

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testobject.ConditionType

import internal.GlobalVariable
import org.openqa.selenium.WebElement

public class FlightManagement {

	@Keyword
	private int getPassengerCount (String testID) {

		String xpath = ("//tr[contains(@data-test-id,\'"+testID+"-R\')]")
		TestObject passengerList = new TestObject('BookingCancellation/Passenger List')
		passengerList.addProperty('xpath', ConditionType.EQUALS, xpath)

		List<WebElement> trElements = WebUI.findWebElements( passengerList, 10);
		return trElements.size();
	}

	@Keyword
	private TestObject getPassengers (String testID, int index) {

		String xpath = ("//tr[@data-test-id = \'"+testID+"-R"+index+"\']")
		TestObject passenger = new TestObject('BookingCancellation/Passenger')
		passenger.addProperty('xpath', ConditionType.EQUALS, xpath)

		return passenger
	}
}
