package com.virtualcave.rateapi.api.infrastructure;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class RateEntityTest {

    @Test
    public void testNoArgsConstructor() {
        RateEntity rateEntity = new RateEntity();
        assertNotNull(rateEntity);
    }

    @Test
    public void testAllArgsConstructor() {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        RateEntity rateEntity = new RateEntity(1L, 1L, startDate, endDate, 100, "USD");

        assertNotNull(rateEntity);
        assertEquals(1L, rateEntity.getBrandId());
        assertEquals(1L, rateEntity.getProductId());
        assertEquals(startDate, rateEntity.getStartDate());
        assertEquals(endDate, rateEntity.getEndDate());
        assertEquals(100, rateEntity.getPrice());
        assertEquals("USD", rateEntity.getCurrencyCode());
    }

    @Test
    public void testGettersAndSetters() {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        RateEntity rateEntity = new RateEntity();

        rateEntity.setId(1L);
        rateEntity.setBrandId(1L);
        rateEntity.setProductId(1L);
        rateEntity.setStartDate(startDate);
        rateEntity.setEndDate(endDate);
        rateEntity.setPrice(100);
        rateEntity.setCurrencyCode("USD");

        assertEquals(1L, rateEntity.getId());
        assertEquals(1L, rateEntity.getBrandId());
        assertEquals(1L, rateEntity.getProductId());
        assertEquals(startDate, rateEntity.getStartDate());
        assertEquals(endDate, rateEntity.getEndDate());
        assertEquals(100, rateEntity.getPrice());
        assertEquals("USD", rateEntity.getCurrencyCode());
    }
}
