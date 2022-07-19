package com.jquispeluyo.demodi.rest;

import com.jquispeluyo.demodi.application.CertificateService;
import com.jquispeluyo.demodi.domain.Certificate;
import com.jquispeluyo.demodi.domain.CertificateRepository;
import com.jquispeluyo.demodi.infraestructure.CertificateMysql;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    // Oracle
    // StudentRepository studentRepository = new StudentOracle();

    //Mysql
    CertificateRepository certificateRepository = new CertificateMysql();

    CertificateService certificateService = new CertificateService(certificateRepository);

    @PostMapping
    public Certificate saveCertificate() {
        Certificate certificate = new Certificate();
        certificate.setPerson("person");
        certificate.setType("type");
        certificate.setDate("date");
        return certificateService.saveCertificate(certificate);
    }

}
