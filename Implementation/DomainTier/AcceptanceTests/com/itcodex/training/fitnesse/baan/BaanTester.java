package com.itcodex.training.fitnesse.baan;

import fit.Fixture;

public class BaanTester {
   public boolean chekIfPartsExists() {
      return true;
   }
   
   public Fixture uploadPartListToBAAN(){
      return new UploadPartlistToBAAN();
   }
   
   public boolean jobStartsWithFrequency( String jobName, Integer frequency ){
      return true;
   }
   
   public boolean expectedXmlIs( String xmlFile ){
      return true;
   }
}
