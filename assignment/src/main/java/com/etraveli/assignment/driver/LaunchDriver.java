package com.etraveli.assignment.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

/**
 * The launch driver class
 * Here we create the loader for the first time and we use it in the test
 *
 */

@Component
public class LaunchDriver {
    public static WebDriver d = null;

    /**
     * The class which determines the url and the driver (given from testNG parameters)
     * @param targetHostUrl
     * @param driver
     */
    public static void launchBrowser(String targetHostUrl,String driver) {
        switch (driver) {
            case "ChromeDriver" -> {
                System.out.println("Launching Chrome Driver");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                d = new ChromeDriver();
            }
            case "FirefoxDriver" -> {
                System.out.println("Launching FireFox Driver");
                System.setProperty("webdriver.gecko.driver", "src/main/resources/firefoxdriver.exe");
                d = new FirefoxDriver();
            }
            ///and so on..
        }

        d.navigate().to(targetHostUrl);
        d.manage().window().maximize();
        System.out.println("Driver is up");
    }

    public WebDriver getDriver(){
        return d;
    }

    public void closeDriver(){d.quit();}
}

