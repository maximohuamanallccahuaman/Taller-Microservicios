package com.jquispeluyo.demodi.rest;

import com.jquispeluyo.demodi.application.CertificateService;
import com.jquispeluyo.demodi.domain.Certificate;
import com.jquispeluyo.demodi.domain.CertificateRepository;
import com.jquispeluyo.demodi.infraestructure.CertificateOracle;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    CertificateRepository certificateRepository = new CertificateOracle();

    CertificateService certificateService = new CertificateService(certificateRepository);

    @PostMapping
    public Certificate saveCertificate(){
        Certificate certificate = new Certificate();
        certificate.getPerson();
        return certificateService.saveCertificate(certificate);
    }
}
