package com.virtualcave.rateapi.api.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class RateTest {

    @Test
    void testNoArgsConstructor() {
        Rate rate = new Rate();
        assertNull(rate.getId());
        assertNull(rate.getBrandId());
        assertNull(rate.getProductId());
        assertNull(rate.getStartDate());
        assertNull(rate.getEndDate());
        assertNull(rate.getPrice());
        assertNull(rate.getCurrencyCode());
    }

    @Test
    void testAllArgsConstructor() {
        Rate rate = new Rate(1L, 1L, 1L, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), 100.0, "USD");
        assertEquals(1L, rate.getId());
        assertEquals(1L, rate.getBrandId());
        assertEquals(1L, rate.getProductId());
        assertEquals(LocalDate.of(2024, 1, 1), rate.getStartDate());
        assertEquals(LocalDate.of(2024, 12, 31), rate.getEndDate());
        assertEquals(100.0, rate.getPrice());
        assertEquals("USD", rate.getCurrencyCode());
    }

    @Test
    void testSettersAndGetters() {
        Rate rate = new Rate();
        rate.setId(2L);
        rate.setBrandId(2L);
        rate.setProductId(2L);
        rate.setStartDate(LocalDate.of(2023, 1, 1));
        rate.setEndDate(LocalDate.of(2023, 12, 31));
        rate.setPrice(200.0);
        rate.setCurrencyCode("EUR");

        assertEquals(2L, rate.getId());
        assertEquals(2L, rate.getBrandId());
        assertEquals(2L, rate.getProductId());
        assertEquals(LocalDate.of(2023, 1, 1), rate.getStartDate());
        assertEquals(LocalDate.of(2023, 12, 31), rate.getEndDate());
        assertEquals(200.0, rate.getPrice());
        assertEquals("EUR", rate.getCurrencyCode());
    }

}

