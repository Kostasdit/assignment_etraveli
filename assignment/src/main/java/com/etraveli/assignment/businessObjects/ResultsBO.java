package com.etraveli.assignment.businessObjects;

import com.etraveli.assignment.pageObjects.ResultsPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Business object for all the business related to results page(open filters)
 * abstraction layer before Page Object
 */
@Component
public class ResultsBO {

    @Autowired
    protected ResultsPO resultsPO;

    /**
     * open the filter
     */
    public void openFilter(){
        resultsPO.pressFilters();
    }

    /**
     * select the number of the stops
     * @return number of flights available
     */
    public String selectAllNumberOfStops(){
        resultsPO.pressAllNumberOfStops();
        return resultsPO.returnFilterResults();
    }

    /**
     * select max 1 number of stops
     * @return number of flights available
     */
    public String selectNumberOfStopsMax1(){
        resultsPO.pressNumberOfStopsMax1();
        return resultsPO.returnFilterResults();
    }

    /**
     * return no stops flights
     * @return number of flights available
     */
    public String selectNumberOfStopsNoStops(){
        resultsPO.pressNumberOfStopsNoStops();
        return resultsPO.returnFilterResults();
    }

    /**
     * select the price by adding money
     * @param value
     * @return number of flights available
     */
    public String selectPriceUp(Double value){
        resultsPO.pressResetData();
        resultsPO.sliderUpPrice(value);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the price by removing money
     * @param value
     * @return number of flights available
     */
    public String selectPriceDown(Double value){
        resultsPO.pressResetData();
        resultsPO.sliderDownPrice(value);
        return resultsPO.returnFilterResults();
    }

    /**
     * select flight by applying both handles
     * @param valueLeft
     * @param valueRight
     * @return number of flights available
     */
    public String selectPriceBothHandles(Double valueLeft,Double valueRight){
        resultsPO.pressResetData();
        resultsPO.sliderUpPrice(valueLeft);
        resultsPO.sliderDownPrice(valueRight);
        return resultsPO.returnFilterResults();
    }

    /**
     * select all airlines
     * @return number of flights available
     */
    public String selectAllAirlines(){
        resultsPO.pressResetData();
        resultsPO.addSelectAllFilterAirlines();
        return resultsPO.returnFilterResults();
    }

    /**
     * clear all airlines
     * @return number of flights available
     */
    public String clearAllAirlines(){
        resultsPO.addClearAllFilterAirlines();
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to go using departure option and adding time
     * @param value
     * @return number of flights available
     */
    public String selectHourUpDepartureGo(Double value){
        resultsPO.pressResetData();
        resultsPO.selectDepartureGo();
        resultsPO.sliderUpGoDeparture(value);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to go using arrival option and adding time
     * @param value
     * @return number of flights available
     */
    public String selectHourUpArrivalGo(Double value){
        resultsPO.pressResetData();
        resultsPO.selectArrivalGo();
        resultsPO.sliderUpGoArrival(value);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to go using departure option and removing time
     * @param value
     * @return number of flights available
     */
    public String selectHourDownDepartureGo(Double value){
        resultsPO.pressResetData();
        resultsPO.selectDepartureGo();
        resultsPO.sliderDownGoDeparture(value);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to go using arrival option and removing time
     * @param value
     * @return number of flights available
     */
    public String selectHourDownArrivalGo(Double value){
        resultsPO.pressResetData();
        resultsPO.selectArrivalGo();
        resultsPO.sliderDownGoArrival(value);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to go using arrival option and both handlers
     * @param valueUp valueDown
     * @return number of flights available
     */
    public String selectHourArrivalBothHandlesGo(Double valueUp,Double valueDown){
        resultsPO.pressResetData();
        resultsPO.selectArrivalGo();
        resultsPO.sliderUpGoArrival(valueUp);
        resultsPO.sliderDownGoArrival(valueDown);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to go using departure option and both handlers
     * @param valueUp valueDown
     * @return number of flights available
     */
    public String selectHourDepartureBothHandlesGo(Double valueUp,Double valueDown){
        resultsPO.pressResetData();
        resultsPO.selectDepartureGo();
        resultsPO.sliderUpGoDeparture(valueUp);
        resultsPO.sliderDownGoDeparture(valueDown);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to return using departure option and adding time
     * @param value
     * @return number of flights available
     */
    public String selectHourUpDepartureReturn(Double value){
        resultsPO.pressResetData();
        resultsPO.selectDepartureReturn();
        resultsPO.sliderUpReturnDeparture(value);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to return using arrival option and adding time
     * @param value
     * @return number of flights available
     */
    public String selectHourUpArrivalReturn(Double value){
        resultsPO.pressResetData();
        resultsPO.selectArrivalReturn();
        resultsPO.sliderUpReturnArrival(value);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to return using departure option and removing time
     * @param value
     * @return number of flights available
     */
    public String selectHourDownDepartureReturn(Double value){
        resultsPO.pressResetData();
        resultsPO.selectDepartureReturn();
        resultsPO.sliderDownReturnDeparture(value);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to return using arrival option and removing time
     * @param value
     * @return number of flights available
     */
    public String selectHourDownArrivalReturn(Double value){
        resultsPO.pressResetData();
        resultsPO.selectArrivalReturn();
        resultsPO.sliderDownReturnArrival(value);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to return using arrival option and both handlers
     * @param valueUp valueDown
     * @return number of flights available
     */
    public String selectHourArrivalBothHandlesReturn(Double valueUp,Double valueDown){
        resultsPO.pressResetData();
        resultsPO.selectArrivalReturn();
        resultsPO.sliderUpReturnArrival(valueUp);
        resultsPO.sliderDownReturnArrival(valueDown);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to return using departure option and both handlers
     * @param valueUp valueDown
     * @return number of flights available
     */
    public String selectHourDepartureBothHandlesReturn(Double valueUp,Double valueDown){
        resultsPO.pressResetData();
        resultsPO.selectDepartureReturn();
        resultsPO.sliderUpReturnDeparture(valueUp);
        resultsPO.sliderDownReturnDeparture(valueDown);
        return resultsPO.returnFilterResults();
    }

    /**
     * select the hour to travel by removing time
     * @param value
     * @return number of flights available
     */
    public String selectTravelTime(Double value){
        resultsPO.pressResetData();
        resultsPO.sliderDownTravelTime(value);
        return resultsPO.returnFilterResults();
    }


}
