package com.etraveli.assignment.businessObjects;

import com.etraveli.assignment.objects.Flight;
import com.etraveli.assignment.pageObjects.HomePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.text.ParseException;

/**
 * Business object for all the business related to home page
 * abstraction layer before Page Object
 */
@Component
public class HomeBO {

    @Autowired
    protected HomePO homePO;

    /**
     * fill all the relevant fields for the fight and search for it
     * @param flight
     * @throws ParseException
     */
    public void selectFlight(Flight flight) throws ParseException {
        selectFromDestination(flight.getFromDestination(),"0");
        selectToDestination(flight.getToDestination(),"0");
        addDepartureDate(flight.getDepartureDate());
        addReturnDate(flight.getReturnDate());
        addAdults(flight.getPassengers());
        passengerClassAdd(flight.getPassengerClass());
        searchFlight();
    }

    /**
     * select from destination
     * @param destination
     * @param option
     */
    public void selectFromDestination(String destination,String option){
        homePO.inputFromDestination(destination,option);
    }

    /**
     * select to destination
     * @param destination
     * @param option
     */
    public void selectToDestination(String destination,String option){
        homePO.inputToDestination(destination,option);
    }

    /**
     * search flight
     */
    public void searchFlight(){
        homePO.pressSearchButton();
    }

    /**
     * add departure date
     * @param date
     * @throws ParseException
     */
    public void addDepartureDate(String date) throws ParseException {
        homePO.selectDepartureDate(date);
    }

    /**
     * add return date
     * @param date
     * @throws ParseException
     */
    public void addReturnDate(String date) throws ParseException {
        homePO.selectReturnDate(date);

    }

    /**
     * add passegner class
     * @param passengerClass
     */
    public void passengerClassAdd(String passengerClass){
        homePO.addPassengerClass(passengerClass);
    }

    /**
     * add adults as passengers
     * @param number
     */
    public void addAdults(String number){
        homePO.addPassenger(number);
    }
}
