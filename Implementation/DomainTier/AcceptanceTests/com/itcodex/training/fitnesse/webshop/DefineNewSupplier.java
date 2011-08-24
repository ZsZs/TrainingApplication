package com.itcodex.training.fitnesse.webshop;

import fit.ColumnFixture;

public class DefineNewSupplier extends ColumnFixture{
   public String name;
   public String type;
   
   @Override
   public void execute() throws Exception {
      super.execute();
      
      Supplier newSupplier = new Supplier( name );
   }
   
   public boolean success(){
      return true;
   }
}
