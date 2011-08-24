package com.itcodex.training.fitnesse.domain.order;

import fit.ColumnFixture;


import com.itcodex.training.order.domain.Order;
import com.itcodex.training.party.domain.Party;
import com.itcodex.training.party.integration.PartyRepository;

public class CreateNewOrder extends ColumnFixture {
   private Order order;
   public String vendorNameZz;
   public String purchaserName;

   public boolean create() {
      Party vendor = findParty( vendorNameZz );
      Party purchaser = findParty( purchaserName );
      order = new Order( vendor, purchaser );
      
      return true;
   }

   public String orderNumber() {
      return order.getOrderNumber();
   }
   
   private Party findParty( String name ) {
      return PartyRepository.findPartyByName( name );
   }

}
