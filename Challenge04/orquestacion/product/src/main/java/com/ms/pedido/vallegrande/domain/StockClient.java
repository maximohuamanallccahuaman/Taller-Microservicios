package com.ms.pedido.vallegrande.domain;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service", fallback = StockHystrixFallbackFactory.class)
public interface StockClient {

    @GetMapping(value = "/stock/{id}")
    public Stock findItemById(@PathVariable String id);
}
