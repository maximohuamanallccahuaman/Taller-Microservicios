package com.ms.pedido.vallegrande.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Document(collection = "stock")
@Data
public class Stock {

    @Id
    private String id;
    private Integer stock;

}
