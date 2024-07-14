package com.virtualcave.rateapi.api.infrastructure.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currencyServiceClient", url = "${currency.service.url}")
public interface CurrencyServiceClient {

    @GetMapping("/v1/currencies/{currencyCode}")
    Optional<Currency> getCurrencyByCode(@PathVariable("currencyCode") String currencyCode);

    class Currency {
        private String symbol;
        private String code;
        private int decimals;

        // Getters and Setters
        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getDecimals() {
            return decimals;
        }

        public void setDecimals(int decimals) {
            this.decimals = decimals;
        }
    }
}

/*integraremos el servicio externo de monedas (currency service) en nuestro proyecto. Usaremos OpenFeign para realizar las llamadas HTTP a este servicio.*/