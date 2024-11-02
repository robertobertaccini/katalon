import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.TargetURL)

WebUI.callTestCase(findTestCase('Login'), [('PassWord') : GlobalVariable.PassWord, ('UserName') : GlobalVariable.UserName], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('New BookingCancellation Case'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BookingCancellation/PNR'))

WebUI.click(findTestObject('BookingCancellation/i_pnr_pi pi-caret-down'))

WebUI.click(findTestObject('BookingCancellation/li_NQ6077MCOAA6340'))

WebUI.click(findTestObject('BookingCancellation/button_Continue'))

WebUI.setText(findTestObject('BookingCancellation/Refunder Email'), 'Refund@flightmanagement.com')

WebUI.click(findTestObject('BookingCancellation/button_Create'))

WebUI.waitForElementPresent(findTestObject('BookingCancellation/button_Approve'), 2)

Status = WebUI.getText(findTestObject('BookingCancellation/Case Status'))

assert Status == 'PENDING-APPROVAL'

WebUI.callTestCase(findTestCase('Logoff'), [:], FailureHandling.STOP_ON_FAILURE)

