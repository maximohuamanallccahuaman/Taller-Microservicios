package com.jquispeluyo.demodi.infraestructure;

import com.jquispeluyo.demodi.domain.Certificate;
import com.jquispeluyo.demodi.domain.CertificateRepository;

public class CertificateDbTest implements CertificateRepository {
   //Connect H2
   @Override
   public Certificate save(Certificate certificate) {
      Certificate certificateResult = new Certificate();
      certificateResult.setId("1");
      certificateResult.setPerson("Máximo Huamán");
      certificateResult.setType("Const. de estudio");
      certificateResult.setDate("19-07-2022");
      return certificateResult;
   }
}
