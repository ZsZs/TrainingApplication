package com.itcodex.training.fitnesse.domain.order;

import com.itcodex.training.order.domain.Order;

import fitlibrary.SetUpFixture;

public class DefineLastOrderNumber extends SetUpFixture {
   
   public void number( String lastOrderNumber ) {
      Order.initializeOrderNumber( new Integer( lastOrderNumber ));
   }

}
