package com.jquispeluyo.demodi.domain;


import lombok.Data;

import java.awt.*;

@Data
public class Certificate {

    private String id;
    private String signature;
    private String hash;
    private Boolean documents;
}
