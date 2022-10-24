package com.etraveli.assignment.verifications;


import org.springframework.stereotype.Component;
import org.testng.asserts.SoftAssert;

/**
 * the assert class for adding validations
 */
@Component
public class Validations {


    /**
     * validation for 2 strings
     * @param a
     * @param b
     */
    public void validateStrings(String a, String b,SoftAssert softAssert){
        System.out.println("Actual is " + b);
        System.out.println("Expected is " + a);
        softAssert.assertEquals(b,a);
    }

    /**
     * assert all
     * @param softAssert
     */
    public void assertAll(SoftAssert softAssert){
        softAssert.assertAll();
    }
}
