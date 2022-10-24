package com.etraveli.assignment;

import com.etraveli.assignment.businessObjects.HomeBO;
import com.etraveli.assignment.businessObjects.ResultsBO;
import com.etraveli.assignment.driver.LaunchDriver;
import com.etraveli.assignment.objects.Flight;
import com.etraveli.assignment.utilities.Dataloader;
import com.etraveli.assignment.verifications.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.text.ParseException;

@SpringBootApplication(scanBasePackages = { "com.etraveli.assignment" })
public class FirstTask extends AbstractTestNGSpringContextTests {

    @Autowired
    protected LaunchDriver launchDriver;

    @Autowired
    protected HomeBO homeBO;

    @Autowired
    protected Dataloader dataloader;

    @Autowired
    protected ResultsBO resultsBO;

    @Autowired
    protected Validations validations;

    protected Flight flight;

    //first before class to open the broswer
    @BeforeClass
    @Parameters({"targetHostUrl","driverType"})
    public void openBrowser(String targetHostUrl,String driverType){
        LaunchDriver.launchBrowser(targetHostUrl,driverType);

    }

    //load the data in object called flight in order to pass all the information
    @BeforeClass(dependsOnMethods = "openBrowser")
    @Parameters({"fromDestination","toDestination","departureDate","returnDate","passengers","passengersClass"})
    public void loadUpData(String fromDestination,String toDestination,String departureDate,String returnDate,String passengers,String passengersClass){
      flight = dataloader.setUpFlightObject(fromDestination,toDestination,departureDate,returnDate,passengers,passengersClass);

    }

    //select the flight specifications and opens the filter
    @BeforeClass(dependsOnMethods ="loadUpData")
    public void setUp() throws ParseException {
        homeBO.selectFlight(flight);
        resultsBO.openFilter();
    }

    @Test(alwaysRun = true, description = "Verify The number of stops filter")
    public void test_1()  {
        SoftAssert softAssert = new SoftAssert();
        validations.validateStrings("629",resultsBO.selectAllNumberOfStops(),softAssert);
        validations.validateStrings("586",resultsBO.selectNumberOfStopsMax1(),softAssert);
        validations.validateStrings("9",resultsBO.selectNumberOfStopsNoStops(),softAssert);
        validations.assertAll(softAssert);

    }
    @Test(alwaysRun = true,dependsOnMethods = "test_1",description = "Verify the price Filter")
    public void test_2(){
        SoftAssert softAssert = new SoftAssert();
        validations.validateStrings("621",resultsBO.selectPriceUp(1500.0),softAssert);
        validations.validateStrings("613",resultsBO.selectPriceDown(4800.0),softAssert);
        validations.validateStrings("249",resultsBO.selectPriceBothHandles(2400.0,3800.0),softAssert);
        validations.assertAll(softAssert);
    }

    @Test(alwaysRun = true,dependsOnMethods = "test_2",description = "Verify select all and clear all filters for air lines")
    public void test_3(){
        SoftAssert softAssert = new SoftAssert();
        validations.validateStrings("629",resultsBO.selectAllAirlines(),softAssert);
        validations.validateStrings("0",resultsBO.clearAllAirlines(),softAssert);
        validations.assertAll(softAssert);
    }

    @Test(alwaysRun = true,dependsOnMethods = "test_3",description = "Verify the departure time and arrival time filter from the 'go' destination")
    public void test_4(){
        SoftAssert softAssert = new SoftAssert();
        validations.validateStrings("563",resultsBO.selectHourUpDepartureGo(630.0),softAssert);
        validations.validateStrings("579",resultsBO.selectHourDownDepartureGo(1900.0),softAssert);
        validations.validateStrings("629",resultsBO.selectHourUpArrivalGo(630.0),softAssert);
        validations.validateStrings("338",resultsBO.selectHourDownArrivalGo(1900.0),softAssert);
        validations.validateStrings("332",resultsBO.selectHourDepartureBothHandlesGo(700.0,1600.0),softAssert);
        validations.validateStrings("369",resultsBO.selectHourArrivalBothHandlesGo(800.0,1900.0),softAssert);
        validations.assertAll(softAssert);
    }

    @Test(alwaysRun = true,dependsOnMethods = "test_4",description = "Verify the departure time and arrival time filter from the 'return' destination")
    public void test_5(){
        SoftAssert softAssert = new SoftAssert();
        validations.validateStrings("543",resultsBO.selectHourUpDepartureReturn(630.0),softAssert);
        validations.validateStrings("572",resultsBO.selectHourDownDepartureReturn(1900.0),softAssert);
        validations.validateStrings("594",resultsBO.selectHourUpArrivalReturn(630.0),softAssert);
        validations.validateStrings("511",resultsBO.selectHourDownArrivalReturn(1900.0),softAssert);
        validations.validateStrings("426",resultsBO.selectHourDepartureBothHandlesReturn(700.0,1600.0),softAssert);
        validations.validateStrings("473",resultsBO.selectHourArrivalBothHandlesReturn(800.0,1900.0),softAssert);
        validations.assertAll(softAssert);
    }

    @Test(alwaysRun = true,dependsOnMethods = "test_5",description = "Verify the filter for the travel time")
    public void test_6(){
        SoftAssert softAssert = new SoftAssert();
        validations.validateStrings("441",resultsBO.selectTravelTime(17.0),softAssert);
        validations.assertAll(softAssert);
    }

    //close browser
    @AfterClass
    public void endTest(){
        launchDriver.closeDriver();
    }


}
