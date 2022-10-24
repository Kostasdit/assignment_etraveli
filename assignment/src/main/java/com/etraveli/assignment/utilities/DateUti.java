package com.etraveli.assignment.utilities;

import org.springframework.stereotype.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * the date class
 * All available date manipulation functions should be here
 */
@Component
public class DateUti {

    /**
     * Take as a string the date we want
     * @return today in a sepcific format
     */
    public String getDateWithSpecificFormat(String dateString) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dateString);
        return new SimpleDateFormat("MMMMM yyyy").format(date);
    }
}
