package com.virtualcave.rateapi.api.application;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcave.rateapi.api.domain.Rate;
import com.virtualcave.rateapi.api.infrastructure.RateEntity;
import com.virtualcave.rateapi.api.infrastructure.RateJpaRepository;

@Service
public class RateService {

    @Autowired
    private RateJpaRepository rateJpaRepository;
//Crea una nueva tarifa.
    public Rate createRate(Rate rate) {
        RateEntity rateEntity = new RateEntity(rate.getBrandId(), rate.getProductId(), rate.getStartDate(), rate.getEndDate(), rate.getPrice().intValue(), rate.getCurrencyCode());
        RateEntity savedEntity = rateJpaRepository.save(rateEntity);
        return new Rate(savedEntity.getId(), savedEntity.getBrandId(), savedEntity.getProductId(), savedEntity.getStartDate(), savedEntity.getEndDate(), savedEntity.getPrice().doubleValue(), savedEntity.getCurrencyCode());
    }
//Obtiene una tarifa por su ID.
    public Optional<Rate> getRateById(Long id) {
        return rateJpaRepository.findById(id).map(rateEntity -> new Rate(rateEntity.getId(), rateEntity.getBrandId(), rateEntity.getProductId(), rateEntity.getStartDate(), rateEntity.getEndDate(), rateEntity.getPrice().doubleValue(), rateEntity.getCurrencyCode()));
    }
//Elimina una tarifa por su ID.
    public void deleteRateById(Long id) {
        rateJpaRepository.deleteById(id);
    }
 //Actualizar una tarifa por su ID.

public Optional<Rate> updateRate(Long id, Double newPrice) {
    return rateJpaRepository.findById(id)
		.map(rateEntity -> {
				rateEntity.setPrice(newPrice.intValue());
				rateJpaRepository.save(rateEntity);
				return new Rate(rateEntity.getId(), rateEntity.getBrandId(), rateEntity.getProductId(), rateEntity.getStartDate(), rateEntity.getEndDate(), rateEntity.getPrice().doubleValue(), rateEntity.getCurrencyCode());
			}
			);
}

    /*  Encuentra tarifas basadas en brandId, productId, startDate y endDate.
    public List<Rate> findRates(Long brandId, Long productId, LocalDate startDate, LocalDate endDate) {
        return rateJpaRepository.findByBrandIdAndProductIdAndStartDateAndEndDate(brandId, productId, startDate, endDate).stream()
                .map(rateEntity -> new Rate(rateEntity.getId(), rateEntity.getBrandId(), rateEntity.getProductId(), rateEntity.getStartDate(), rateEntity.getEndDate(), rateEntity.getPrice().doubleValue(), rateEntity.getCurrencyCode()))
                .collect(Collectors.toList());
    }
    */

    // Encuentra tarifas basadas en brandId, productId, startDate y endDate.
    public List<Rate> findRates(Long brandId, Long productId, LocalDate startDate, LocalDate endDate) {
        return rateJpaRepository.findAll().stream()
                .filter(rateEntity -> rateEntity.getBrandId().equals(brandId))
                .filter(rateEntity -> rateEntity.getProductId().equals(productId))
                .filter(rateEntity -> !rateEntity.getStartDate().isAfter(endDate) && !rateEntity.getEndDate().isBefore(startDate))
                .map(rateEntity -> new Rate(rateEntity.getId(), rateEntity.getBrandId(), rateEntity.getProductId(), rateEntity.getStartDate(), rateEntity.getEndDate(), rateEntity.getPrice().doubleValue(), rateEntity.getCurrencyCode()))
                .collect(Collectors.toList());
    }

}

/*RateService.java es un archivo Java que contiene la lógica de negocio para manejar las tarifas (Rate). Es el intermediario entre el controlador (que maneja las solicitudes HTTP) y el repositorio (que interactúa con la base de datos).*/