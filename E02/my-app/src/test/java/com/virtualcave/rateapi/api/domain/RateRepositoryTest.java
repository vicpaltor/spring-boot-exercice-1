package com.virtualcave.rateapi.api.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RateRepositoryTest {

    @Mock
    private RateRepository rateRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveRate() {
        Rate rate = new Rate(1L, 1L, 1L, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), 100.0, "USD");
        when(rateRepository.save(any(Rate.class))).thenReturn(rate);

        Rate savedRate = rateRepository.save(rate);

        assertNotNull(savedRate);
        assertEquals(1L, savedRate.getId());
        assertEquals(100.0, savedRate.getPrice());
    }

    @Test
    void testFindById() {
        Rate rate = new Rate(1L, 1L, 1L, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), 100.0, "USD");
        when(rateRepository.findById(1L)).thenReturn(Optional.of(rate));

        Optional<Rate> foundRate = rateRepository.findById(1L);

        assertTrue(foundRate.isPresent());
        assertEquals(1L, foundRate.get().getId());
    }

    @Test
    void testDeleteById() {
        doNothing().when(rateRepository).deleteById(1L);

        rateRepository.deleteById(1L);

        verify(rateRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindByBrandIdAndProductIdAndDate() {
        Rate rate1 = new Rate(1L, 1L, 1L, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 6, 30), 100.0, "USD");
        Rate rate2 = new Rate(2L, 1L, 1L, LocalDate.of(2024, 7, 1), LocalDate.of(2024, 12, 31), 200.0, "USD");
        List<Rate> rates = Arrays.asList(rate1, rate2);

        when(rateRepository.findByBrandIdAndProductIdAndDate(1L, 1L, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31))).thenReturn(rates);

        List<Rate> foundRates = rateRepository.findByBrandIdAndProductIdAndDate(1L, 1L, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31));

        assertNotNull(foundRates);
        assertEquals(2, foundRates.size());
    }
}
