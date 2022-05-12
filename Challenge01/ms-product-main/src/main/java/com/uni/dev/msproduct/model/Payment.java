package com.uni.dev.msproduct.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "payment")
public class Payment {

    /* Datos de la tarjeta de crédito */
    @Id
    private String id;
    private String type;
    private String number;
    private String expiration;
}