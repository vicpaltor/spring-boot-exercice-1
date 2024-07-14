package com.virtualcave.rateapi.api.infrastructure;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RateJpaRepository extends JpaRepository<RateEntity, Long> {
    List<RateEntity> findByBrandIdAndProductIdAndStartDateAndEndDate(Long brandId, Long productId, LocalDate startDate, LocalDate endDate);
}


/*define cómo interactuamos con la base de datos para manejar los datos de las tarifas (Rate).
 * 
 * JpaRepository proporciona estos métodos básicos como guardar, encontrar, actualizar o eliminar tarifas automáticamente.
*/




