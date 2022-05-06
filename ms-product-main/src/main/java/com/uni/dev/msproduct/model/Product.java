package com.uni.dev.msproduct.model;

import com.mongodb.annotations.NotThreadSafe;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

@Data
@Document(collection = "product")
public class Product {

    @Id
    private String id;

    @NotNull(message = "Debes especificar el nombre")
    private String name;

    @NotBlank
    private Integer stock;
    private BigDecimal price;

}
