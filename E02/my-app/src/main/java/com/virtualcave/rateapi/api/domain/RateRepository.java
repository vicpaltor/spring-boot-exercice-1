package com.virtualcave.rateapi.api.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RateRepository {
    /*Guarda una tarifa en la base de datos.*/
    Rate save(Rate rate);
    /*Encuentra una tarifa por su ID.*/
    Optional<Rate> findById(Long id);
    /*Elimina una tarifa por su ID.*/
    void deleteById(Long id);
    /*Encuentra tarifas basadas en brandId, productId y date.*/
    List<Rate> findByBrandIdAndProductIdAndDate(Long brandId, Long productId, LocalDate startDate, LocalDate endDate);
}

/*es una interfaz que define los métodos que nuestra aplicación utilizará para interactuar con la base de datos de tarifas (Rate).*/