package com.jquispeluyo.demodi.application;

import com.jquispeluyo.demodi.domain.Certificate;
import com.jquispeluyo.demodi.infraestructure.CertificateDbTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CertificateServiceTest {

   @Test
   void saveCertificate() {
      CertificateDbTest certificateDbTest = new CertificateDbTest();
      CertificateService certificateService = new CertificateService(certificateDbTest);

      Certificate certificate = new Certificate();
      certificate.setPerson("Máximo Huamán");
      certificate.setType("Const. de estudio");
      certificate.setDate("19-07-2022");
      assertEquals(certificateService.saveCertificate(certificate), expectedCertificate());
   }

   private Certificate expectedCertificate(){
      Certificate certificate = new Certificate();
      certificate.setId("1");
      certificate.setPerson("Máximo Huamán");
      certificate.setType("Const. de estudio");
      certificate.setDate("19-07-2022");
      return certificate;
   }
}
