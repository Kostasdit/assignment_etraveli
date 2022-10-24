package com.etraveli.assignment.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.List;

/**
 * The page object for the home page
 * all the locators and the functions for this page should be here
 */

@Component
public class HomePO extends BasePO {
    enum LandingPageLocator{
        DESTINATION_FROM("div[data-testid='searchForm-singleBound-origin-input']"),
        DESTINATION_FROM_INPUT_BOX("div[data-testid='searchForm-singleBound-origin-input'] div input"),
        DESTINATION_TO("div[data-testid='searchForm-singleBound-destination-input']"),
        DESTINATION_TO_INPUT_BOX("div[data-testid='searchForm-singleBound-destination-input'] div input"),
        OPTION("div[data-testid='etiDropdownOption'][id*='option-'{0}']"),
        DEPARTURE_DATE("input[id='singleBound.departureDate']"),
        RETURN_DATE("input[id='singleBound.returnDate']"),
        DATE_PICKER_MONTH_YEAR_TEXT("div.DayPicker-Caption"),
        DATE_NEXT("button[aria-label='Next month']"),
        DATE_DAY("div.DayPicker-Month div.DayPicker-Week div.DayPicker-Day"),
        PASSENGERS_DROPDOWN("div[data-testid='searchForm-passengers-dropdown']"),
        PASSENGERS_CLASS_DROPDOWN("div[data-testid='searchForm-cabinClasses-dropdown']"),
        SEARCH_FLIGHTS("button[type='submit']"),
        ADULTS_ADD("button[data-testid='counter-adults-plus-button']"),
        ADULTS_NUMBER("div[data-testid='counter-adults-value']"),
        SPINNER("div[data-testid='progressSpinner-image']");

        private final String myLocator;

        LandingPageLocator(String locator){
            myLocator = locator;
        }

        String getLocator() {return myLocator;}

        String getWithParams(Object... params){
            return MessageFormat.format(getLocator(),params);
        }


    }

    /**
     * input from destination
     * @param destination
     * @param option
     */
    public void inputFromDestination(String destination,String option){
        click(LandingPageLocator.DESTINATION_FROM.getLocator());
        input(LandingPageLocator.DESTINATION_FROM_INPUT_BOX.getLocator(), destination);
        click(LandingPageLocator.OPTION.getWithParams(option));
    }

    /**
     * input to destination
     * @param destination
     * @param option
     */
    public void inputToDestination(String destination,String option){
        click(LandingPageLocator.DESTINATION_TO.getLocator());
        input(LandingPageLocator.DESTINATION_TO_INPUT_BOX.getLocator(), destination);
        click(LandingPageLocator.OPTION.getWithParams(option));
    }

    /**
     * Select departure date
     * @param date
     * @throws ParseException
     */
    public void selectDepartureDate(String date) throws ParseException {
        click(LandingPageLocator.DEPARTURE_DATE.getLocator());
        selectDate(date,LandingPageLocator.DATE_PICKER_MONTH_YEAR_TEXT.getLocator(),LandingPageLocator.DATE_NEXT.getLocator(),LandingPageLocator.DATE_DAY.getLocator());
    }

    /**
     * select return date
     * @param date
     * @throws ParseException
     */
    public void selectReturnDate(String date) throws ParseException {
        click(LandingPageLocator.RETURN_DATE.getLocator());
        selectDate(date,LandingPageLocator.DATE_PICKER_MONTH_YEAR_TEXT.getLocator(),LandingPageLocator.DATE_NEXT.getLocator(),LandingPageLocator.DATE_DAY.getLocator());
    }

    /**
     * add passegner(only adds adults)
     * @param numberOfPeople
     */
    public void addPassenger(String numberOfPeople){
        click(LandingPageLocator.PASSENGERS_DROPDOWN.getLocator());
        String nOfAdults = getText(LandingPageLocator.ADULTS_NUMBER.getLocator());
        while (!nOfAdults.equals(numberOfPeople)){
            click(LandingPageLocator.ADULTS_ADD.getLocator());
            nOfAdults = getText(LandingPageLocator.ADULTS_NUMBER.getLocator());

        }
    }

    /**
     * add passegner class
     * @param classPass
     */
    public void addPassengerClass(String classPass){
        click(LandingPageLocator.PASSENGERS_CLASS_DROPDOWN.getLocator());
        WebElement e = launchDriver.getDriver().findElement(By.xpath("//*[text()='"+classPass+"']"));
        e.click();

    }

    /**
     * Press to search for a flight(s)
     */
    public void pressSearchButton(){
        click(LandingPageLocator.SEARCH_FLIGHTS.getLocator());
        waitForElementToDisappear(LandingPageLocator.SPINNER.getLocator());
    }

    /**
     * select the date in calendar
     * @param expectedDate
     * @param locatorMonth
     * @param locatorNext
     * @param locatorDay
     * @throws ParseException
     */
    public void selectDate(String expectedDate,String locatorMonth,String locatorNext,String locatorDay) throws ParseException {
        String[] parts = expectedDate.split("-");
        String month = getText(locatorMonth);
        while(!month.equals(dateUti.getDateWithSpecificFormat(expectedDate))){
            click(locatorNext);
            month=getText(locatorMonth);
        }
        //was take from the web and it was changed a bit
        List<WebElement> allDates=launchDriver.getDriver().findElements(By.cssSelector(locatorDay));
        for(WebElement ele:allDates)
        {
            String date=ele.getText();
            if(date.equalsIgnoreCase(parts[2]))
            {
                ele.click();
                break;
            }
        }
    }
}
