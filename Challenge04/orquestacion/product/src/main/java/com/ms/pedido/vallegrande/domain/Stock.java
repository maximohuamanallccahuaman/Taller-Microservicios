package com.ms.pedido.vallegrande.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Stock {
    private String id;
    private Integer stock;
}
