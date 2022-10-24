package com.etraveli.assignment.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The page object for the results page(open the filters)
 * all the locators and the functions for this page should be here
 */
@Component
public class ResultsPO extends BasePO {

    enum ResultsPageLocator{
        FILTER_BUTTON("button[data-testid='resultPage-toggleFiltersButton-button']"),
        DONE_BUTTON("button[data-testid='filtersForm-applyFilters-button']"),
        CLEAR_BUTTON("button[data-testid='filtersForm-applyFilters-button']"),

        //TRAVEL TIME
        TRAVEL_TIME_HANDLE("div[data-testid='resultPage-TRAVEL_TIMEFilter-content'] div[data-testid='handle-0']"),
        TRAVEL_TIME_TIME("div[data-testid='resultPage-TRAVEL_TIMEFilter-content'] div.css-q8818v"),

        //RETURN TIME
        RETURN_RADIO_LEFT_HOUR_DEPARTURE("div[data-testid='resultPage-departureArrivalFilter-departure1-slider'] div.css-q8818v"),
        RETURN_RADIO_RIGHT_HOUR_DEPARTURE("div[data-testid='resultPage-departureArrivalFilter-departure1-slider'] div.css-gbzxm"),
        RETURN_RADIO_LEFT_HOUR_ARRIVAL("div[data-testid='resultPage-departureArrivalFilter-arrival1-slider'] div.css-q8818v"),
        RETURN_RADIO_RIGHT_HOUR_ARRIVAL("div[data-testid='resultPage-departureArrivalFilter-arrival1-slider'] div.css-gbzxm"),
        RETURN_HANDLE_LEFT_ARRIVAL("div[data-testid='resultPage-departureArrivalFilter-arrival1-slider'] div[data-testid='handle-0']"),
        RETURN_HANDLE_RIGHT_ARRIVAL("div[data-testid='resultPage-departureArrivalFilter-arrival1-slider'] div[data-testid='handle-1']"),
        RETURN_HANDLE_LEFT_DEPARTURE("div[data-testid='resultPage-departureArrivalFilter-departure1-slider'] div[data-testid='handle-0']"),
        RETURN_HANDLE_RIGHT_DEPARTURE("div[data-testid='resultPage-departureArrivalFilter-departure1-slider'] div[data-testid='handle-1']"),
        RADIO_DEPARTURE_RETURN(".css-1rmvpx7:nth-child(2) .olvb831:nth-child(1) > .\\_3won560"),
        RADIO_ARRIVAL_RETURN(".css-1rmvpx7:nth-child(2) .olvb831:nth-child(2) > .\\_3won560"),

        //GO TIME
        GO_HANDLE_LEFT_DEPARTURE("div[data-testid='resultPage-departureArrivalFilter-departure0-slider'] div[data-testid='handle-0']"),
        GO_HANDLE_LEFT_ARRIVAL("div[data-testid='resultPage-departureArrivalFilter-arrival0-slider'] div[data-testid='handle-0']"),
        GO_HANDLE_RIGHT_DEPARTURE("div[data-testid='resultPage-departureArrivalFilter-departure0-slider'] div[data-testid='handle-1']"),
        GO_HANDLE_RIGHT_ARRIVAL("div[data-testid='resultPage-departureArrivalFilter-arrival0-slider'] div[data-testid='handle-1']"),
        RADIO_DEPARTURE_GO(".css-1rmvpx7:nth-child(1) .olvb831:nth-child(1) > .\\_3won560"),
        RADIO_ARRIVAL_GO(".css-1rmvpx7:nth-child(1) .olvb831:nth-child(2) > .\\_3won560"),
        GO_RADIO_LEFT_HOUR_DEPARTURE("div[data-testid='resultPage-departureArrivalFilter-departure0-slider'] div.css-q8818v"),
        GO_RADIO_RIGHT_HOUR_DEPARTURE("div[data-testid='resultPage-departureArrivalFilter-departure0-slider'] div.css-gbzxm"),
        GO_RADIO_LEFT_HOUR_ARRIVAL("div[data-testid='resultPage-departureArrivalFilter-arrival0-slider'] div.css-q8818v"),
        GO_RADIO_RIGHT_HOUR_ARRIVAL("div[data-testid='resultPage-departureArrivalFilter-arrival0-slider'] div.css-gbzxm"),

        //PRICE
        PRICE_HANDLE_LEFT("div[data-testid='resultPage-PRICEFilter-content'] div[data-testid='handle-0']"),
        PRICE_HANDLE_RIGHT("div[data-testid='resultPage-PRICEFilter-content'] div[data-testid='handle-1']"),
        PRICE_VALUE_LEFT("div[data-testid='resultPage-PRICEFilter-content'] div.css-q8818v"),
        PRICE_VALUE_RIGHT("div[data-testid='resultPage-PRICEFilter-content'] div.css-gbzxm"),

        //STOPS
        NUMBER_OF_STOPS_ALL_BUTTON("label[data-testid='MAX_STOPS-all']"),
        NUMBER_OF_STOPS_MAX_1("label[data-testid='MAX_STOPS-max1'"),
        NUMBER_OF_STOPS_NO_STOPS("label[data-testid='MAX_STOPS-direct']"),
        FILTER_RESULTS("span[data-testid='resultPage-filters-text'] ~span"),
        RESET_BUTTON("button[data-testid='resultPage-filterHeader-allFilterResetButton-button'] span")



        ;

        private final String myLocator;

        ResultsPageLocator(String locator){
            myLocator = locator;
        }

        String getLocator() {return myLocator;}

        String getWithParams(Object... params){
            return MessageFormat.format(getLocator(),params);
        }


    }

    /**
     * press the filter button
     */
    public void pressFilters(){
        click(ResultsPageLocator.FILTER_BUTTON.getLocator());
    }

    /**
     *
     * @return the results of the filter(up left corner)
     */
    public String returnFilterResults(){
        waitForElementToBeVisible(ResultsPageLocator.FILTER_RESULTS.getLocator());
        Matcher matcher = Pattern.compile("\\d+").matcher(getText(ResultsPageLocator.FILTER_RESULTS.getLocator()));
        matcher.find();
        int i = Integer.parseInt(matcher.group());
        return String.valueOf(i);
    }

    /**
     * click the all number of stops button
     */
    public void pressAllNumberOfStops(){
        click(ResultsPageLocator.NUMBER_OF_STOPS_ALL_BUTTON.getLocator());
    }

    /**
     * click the max 1 number of stops button
     */
    public void pressNumberOfStopsMax1(){
        click(ResultsPageLocator.NUMBER_OF_STOPS_MAX_1.getLocator());
    }

    /**
     * click the no stops button
     */
    public void pressNumberOfStopsNoStops(){
        click(ResultsPageLocator.NUMBER_OF_STOPS_NO_STOPS.getLocator());
    }

    /**
     * press the slide for price(left -> right)
     * @param value expected to stop
     */
    public void sliderUpPrice(Double value){
        moveSliderUp(ResultsPageLocator.PRICE_HANDLE_LEFT.getLocator(),ResultsPageLocator.PRICE_VALUE_LEFT.getLocator(), value);
    }

    /**
     * press the slide for price(right -> left)
     * @param value expected to stop
     */
    public void sliderDownPrice(Double value){
        moveSliderDown(ResultsPageLocator.PRICE_HANDLE_RIGHT.getLocator(),ResultsPageLocator.PRICE_VALUE_RIGHT.getLocator(), value);
    }

    /**
     * press the button to reset data if needed
     */
    public void pressResetData(){
        if(isElementPresent(ResultsPageLocator.RESET_BUTTON.getLocator())) {
            click(ResultsPageLocator.RESET_BUTTON.getLocator());
        }
    }

    /**
     * Select all button when we select airlines
     */
    public void addSelectAllFilterAirlines(){
        WebElement e = launchDriver.getDriver().findElement(By.xpath("//*[text()='Select all']"));
        e.click();

    }

    /**
     * clear all button when we select airlines
     */
    public void addClearAllFilterAirlines(){
        WebElement e = launchDriver.getDriver().findElement(By.xpath("//*[text()='Clear all']"));
        e.click();

    }

    /**
     * select the departure option for go destination
     */
    public void selectDepartureGo(){
        if(isElementClickable(ResultsPageLocator.RADIO_DEPARTURE_GO.getLocator())) {
            click(ResultsPageLocator.RADIO_DEPARTURE_GO.getLocator());
        }
    }

    /**
     * select the arrival option for go destination
     */
    public void selectArrivalGo(){
        if(isElementClickable(ResultsPageLocator.RADIO_ARRIVAL_GO.getLocator())) {
            click(ResultsPageLocator.RADIO_ARRIVAL_GO.getLocator());
        }
    }

    /**
     * select the departure option for return destination
     */
    public void selectDepartureReturn(){
        if(isElementClickable(ResultsPageLocator.RADIO_DEPARTURE_RETURN.getLocator())) {
            click(ResultsPageLocator.RADIO_DEPARTURE_RETURN.getLocator());
        }
    }

    /**
     * select the arrival option for go destination
     */
    public void selectArrivalReturn(){
        if(isElementClickable(ResultsPageLocator.RADIO_ARRIVAL_RETURN.getLocator())) {
            click(ResultsPageLocator.RADIO_ARRIVAL_RETURN.getLocator());
        }
    }

    /**
     * press the slide for go destination with departure option (left -> right)
     * @param value expected to stop
     */
    public void sliderUpGoDeparture(Double value){
        moveSliderUp(ResultsPageLocator.GO_HANDLE_LEFT_DEPARTURE.getLocator(),ResultsPageLocator.GO_RADIO_LEFT_HOUR_DEPARTURE.getLocator(), value);
    }

    /**
     * press the slide for go arrival with departure option(left -> right)
     * @param value expected to stop
     */
    public void sliderUpGoArrival(Double value){
        moveSliderUp(ResultsPageLocator.GO_HANDLE_LEFT_ARRIVAL.getLocator(),ResultsPageLocator.GO_RADIO_LEFT_HOUR_ARRIVAL.getLocator(), value);
    }

    /**
     * press the slide for go departure with departure option(right -> left)
     * @param value expected to stop
     */
    public void sliderDownGoDeparture(Double value){
        moveSliderDown(ResultsPageLocator.GO_HANDLE_RIGHT_DEPARTURE.getLocator(),ResultsPageLocator.GO_RADIO_RIGHT_HOUR_DEPARTURE.getLocator(), value);
    }

    /**
     * press the slide for go departure with departure option(right -> left)
     * @param value expected to stop
     */
    public void sliderDownGoArrival(Double value){
        moveSliderDown(ResultsPageLocator.GO_HANDLE_RIGHT_ARRIVAL.getLocator(),ResultsPageLocator.GO_RADIO_RIGHT_HOUR_ARRIVAL.getLocator(), value);
    }

    /**
     * press the slide for return destination with departure option (left -> right)
     * @param value expected to stop
     */
    public void sliderUpReturnDeparture(Double value){
        moveSliderUp(ResultsPageLocator.RETURN_HANDLE_LEFT_DEPARTURE.getLocator(),ResultsPageLocator.RETURN_RADIO_LEFT_HOUR_DEPARTURE.getLocator(), value);
    }

    /**
     * press the slide for return destination with arrival option (left -> right)
     * @param value expected to stop
     */
    public void sliderUpReturnArrival(Double value){
        moveSliderUp(ResultsPageLocator.RETURN_HANDLE_LEFT_ARRIVAL.getLocator(),ResultsPageLocator.RETURN_RADIO_LEFT_HOUR_ARRIVAL.getLocator(), value);
    }

    /**
     * press the slide for return destination with departure option (right -> left)
     * @param value expected to stop
     */
    public void sliderDownReturnDeparture(Double value){
        moveSliderDown(ResultsPageLocator.RETURN_HANDLE_RIGHT_DEPARTURE.getLocator(),ResultsPageLocator.RETURN_RADIO_RIGHT_HOUR_DEPARTURE.getLocator(), value);
    }

    /**
     * press the slide for return destination with arrival option (right -> left)
     * @param value expected to stop
     */
    public void sliderDownReturnArrival(Double value){
        moveSliderDown(ResultsPageLocator.RETURN_HANDLE_RIGHT_ARRIVAL.getLocator(),ResultsPageLocator.RETURN_RADIO_RIGHT_HOUR_ARRIVAL.getLocator(), value);
    }

    /**
     * press the slide for travel time option (right -> left)
     * @param value expected to stop
     */
    public void sliderDownTravelTime(Double value){
        scrollDown();
        moveSliderDown(ResultsPageLocator.TRAVEL_TIME_HANDLE.getLocator(),ResultsPageLocator.TRAVEL_TIME_TIME.getLocator(), value);
    }


}
