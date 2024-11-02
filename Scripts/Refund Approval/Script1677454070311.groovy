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

WebUI.callTestCase(findTestCase('Login'), [('PassWord') : GlobalVariable.PasswordApprover, ('UserName') : GlobalVariable.UserNameApprover], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl((GlobalVariable.TargetURL + '/pegasample/OU9BFX-AppStudio-Work/') + GlobalVariable.CaseID)

WebUI.waitForElementPresent(findTestObject('BookingCancellation/button_Go'), 2)

Assignment = WebUI.getText(findTestObject('BookingCancellation/Assignment'))

assert Assignment == 'Check Platinum'

WebUI.click(findTestObject('BookingCancellation/button_Go'))

Loyalty = WebUI.getText(findTestObject('BookingCancellation/loyalty'))

assert Loyalty == 'Silver'

WebUI.click(findTestObject('BookingCancellation/button_Submit'))

WebUI.waitForElementPresent(findTestObject('BookingCancellation/button_Approve'), 2)

Status = WebUI.getText(findTestObject('BookingCancellation/Case Status'))

assert Status == 'PENDING-APPROVAL'

WebUI.setText(findTestObject('BookingCancellation/Notes'), 'Granted')

WebUI.click(findTestObject('BookingCancellation/button_Approve'))

WebUI.click(findTestObject('BookingCancellation/label_Voucher'))

WebUI.click(findTestObject('BookingCancellation/button_Submit'))

WebUI.setText(findTestObject('BookingCancellation/Refund Base Amount'), '600')

WebUI.setText(findTestObject('BookingCancellation/Refund Percentage'), '88')

WebUI.click(findTestObject('BookingCancellation/button_Submit'))

