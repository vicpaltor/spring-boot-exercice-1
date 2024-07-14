package com.virtualcave.rateapi.adapter.in.web;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcave.rateapi.api.application.RateService;
import com.virtualcave.rateapi.api.domain.Rate;

@RestController
@RequestMapping("/api/rates")
public class RateController {

    @Autowired
    private RateService rateService;
/*Crea una nueva tarifa a partir del cuerpo de la solicitud (@RequestBody).
 * Devuelve la tarifa creada como respuesta (ResponseEntity<Rate>).
*/
    @PostMapping
    public ResponseEntity<Rate> createRate(@RequestBody Rate rate) {
        return ResponseEntity.ok(rateService.createRate(rate));
    }
/*Obtiene una tarifa por su ID (@PathVariable)..
 * Devuelve la tarifa si se encuentra, o un 404 Not Found si no se encuentra.
*/
    @GetMapping("/{id}")
    public ResponseEntity<Rate> getRateById(@PathVariable Long id) {
        return rateService.getRateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
/*Elimina una tarifa por su ID (@PathVariable).
 * Devuelve una respuesta sin contenido (204 No Content).
*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRateById(@PathVariable Long id) {
        rateService.deleteRateById(id);
        return ResponseEntity.noContent().build();
    }

/*Actualizar el precio de una tarifa por su ID (@PathVariable).
 * Devuelve una tarifa.
*/
@PutMapping("/{id}")
public ResponseEntity<Rate> updateRate(@PathVariable Long id, @RequestBody Map<String, Double> updateRequest){
    Double newPrice = updateRequest.get("price");
    return rateService.updateRate(id, newPrice)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
}

   // Encuentra tarifas basadas en brandId, productId, startDate y endDate
    // Encuentra tarifas basadas en brandId, productId, startDate y endDate.
    @GetMapping("/search")
    public ResponseEntity<List<Rate>> findRates(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Rate> rates = rateService.findRates(brandId, productId, startDate, endDate);
        return ResponseEntity.ok(rates);
    }
}

/*es un archivo Java que maneja las solicitudes HTTP relacionadas con las tarifas (Rate). Actúa como la capa de presentación en nuestra aplicación.*/