package com.etraveli.assignment.objects;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Flight object has all the fields in order to search for flight
 * getters setters using lombok
 */
@Getter
@Setter
@Component
public class Flight {
    String fromDestination;
    String toDestination;
    String departureDate;
    String returnDate;
    String passengers;
    String passengerClass;
}
