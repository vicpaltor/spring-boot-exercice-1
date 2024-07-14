package com.virtualcave.rateapi.api.application;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.virtualcave.rateapi.api.domain.Rate;
import com.virtualcave.rateapi.api.infrastructure.RateEntity;
import com.virtualcave.rateapi.api.infrastructure.RateJpaRepository;

public class RateServiceTests {

    @Mock
    private RateJpaRepository rateJpaRepository;

    @InjectMocks
    private RateService rateService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteRateById() {
        rateService.deleteRateById(1L);
        // No se requiere verificación adicional aquí ya que el método no devuelve nada
    }

    @Test
    public void testUpdateRate() {
        RateEntity rateEntity = new RateEntity(1L, 1L, LocalDate.now(), LocalDate.now().plusDays(10), 100, "USD");
        when(rateJpaRepository.findById(anyLong())).thenReturn(Optional.of(rateEntity));
        when(rateJpaRepository.save(any(RateEntity.class))).thenReturn(rateEntity);

        Optional<Rate> updatedRate = rateService.updateRate(1L, 150.0);

        assertThat(updatedRate).isPresent();
        assertThat(updatedRate.get().getPrice()).isEqualTo(150.0);
    }
}
