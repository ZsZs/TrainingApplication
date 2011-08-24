package com.itcodex.training.fitnesse.baan;

import fit.ColumnFixture;

public class UploadPartlistToBAAN extends ColumnFixture {
   public String partNumber;
   public String description;
   public String type;
   public String revision;
   
   
   @Override
   public void execute() throws Exception {
      super.execute();
      //System.out.println( "New part is added." );
   }
   
   

}
