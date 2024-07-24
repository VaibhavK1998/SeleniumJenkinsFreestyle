package AllureListner;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.BaseClass2;

public class ScreenshotAllureAttach implements ITestListener {


    @Attachment(value = "Screenshot of failure test case", type = "image/png")
    public byte[] saveFailureScrrenshot(WebDriver driver){
        TakesScreenshot ts=(TakesScreenshot) driver;
      return  ts.getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("starting test");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("on failure called");
        WebDriver driver= BaseClass2.getDriver();
        if(driver==null){
            System.out.println("driver is null");
        }else{
            if(driver instanceof  WebDriver){
                saveFailureScrrenshot(driver);
            }
        }

    }
}
