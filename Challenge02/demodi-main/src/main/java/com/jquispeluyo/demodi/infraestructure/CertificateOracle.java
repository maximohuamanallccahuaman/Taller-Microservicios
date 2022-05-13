package com.jquispeluyo.demodi.infraestructure;

import com.jquispeluyo.demodi.domain.Certificate;
import com.jquispeluyo.demodi.domain.CertificateRepository;

public class CertificateOracle implements CertificateRepository {

    @Override
    public Certificate save(Certificate certificate){
        Certificate certificateResult = new Certificate();
        certificateResult.setId("1");
        certificateResult.setPerson("name Oracle");
        return certificateResult;
    }
}
