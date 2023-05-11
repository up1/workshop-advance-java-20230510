package org.example.badcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class RegisterFeeTest {

    @ParameterizedTest
    @CsvSource({
            "1, 500",
            "3, 250",
            "5, 100",
            "9, 50",
            "15, 0"
    })
    public void getFee(int experienceYear, int expectedFee) {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        int actualFee = registerBusiness.getFee(experienceYear);
        assertEquals(expectedFee, actualFee);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 500",
            "3, 250",
            "5, 100",
            "9, 50",
            "15, 0"
    })
    public void getFee2(int experienceYear, int expectedFee) {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        int actualFee = registerBusiness.getFee(experienceYear);
        assertEquals(expectedFee, actualFee);
    }
}