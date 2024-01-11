package Lambdatests;

import PageObjectModels.LambdaPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class invalid_search {

    @Test
    public void Invalisearchtest(){

        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ecommerce-playground.lambdatest.io/");
        LambdaPage lambda =new LambdaPage(driver);
        lambda.enterText("xyz1234vr");
        lambda.clickSubmit();
        TakesScreenshot screenshot=(TakesScreenshot)  driver;
        File screenshortFile=screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile= new File("invalidPage.png");
        try {
            FileUtils.copyFile(screenshortFile,destinationFile);
        } catch (IOException e){
            throw new RuntimeException(e);
        }



    }
}

