package com.jquispeluyo.demodi.application;

import com.jquispeluyo.demodi.domain.CertificateRepository;
import com.jquispeluyo.demodi.domain.Certificate;

public class CertificateService {

   CertificateRepository certificateRepository;

   public CertificateService(CertificateRepository certificateRepository) {
      this.certificateRepository = certificateRepository;
   }

   public Certificate saveCertificate(Certificate certificate){
      return certificateRepository.save(certificate);
   }

}
