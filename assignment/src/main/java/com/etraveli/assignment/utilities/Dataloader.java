package com.etraveli.assignment.utilities;

import com.etraveli.assignment.objects.Flight;
import org.springframework.stereotype.Component;

/**
 * the data loader class.
 * All the loaders for all the objects should be here
 * in our case we have only one object->flight
 */
@Component
public class Dataloader {

    /**
     * loads flight object
     * @param fromDes
     * @param toDest
     * @param depDate
     * @param reDate
     * @param pass
     * @param passClass
     * @return
     */
    public Flight setUpFlightObject(String fromDes,String toDest,String depDate,String reDate,String pass,String passClass ){
        Flight flight = new Flight();
        flight.setFromDestination(fromDes);
        flight.setToDestination(toDest);
        flight.setDepartureDate(depDate);
        flight.setReturnDate(reDate);
        flight.setPassengers(pass);
        flight.setPassengerClass(passClass);

        return flight;
    }
}
