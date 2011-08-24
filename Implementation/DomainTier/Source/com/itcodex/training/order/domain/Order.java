package com.itcodex.training.order.domain;

import java.util.ArrayList;
import java.util.List;

import com.itcodex.training.party.domain.Party;

public class Order {
   private static Integer lastNumber = 1; 
   private Party vendor;
   private Party customer;
   private String orderNumber;
   private List<OrderItem> items = new ArrayList<OrderItem>();
   
   public Order( Party vendor, Party customer ) {
      this.vendor = vendor;
      this.customer = customer;
      generateNewOrderNumber();
   }
   
   public void addItem( OrderItem newItem ) {
      items.add( newItem );
   }

   public static void initializeOrderNumber( Integer startingNumber ) {
      lastNumber = startingNumber;
   }
   
   public Double total() {
      Double total = 0.0;
      for( OrderItem item : items ){
         total += item.getPrice();
      }
      return total;
   }

   //Properties
   public Party getVentor() { return vendor; }
   public Party getCustomer() { return customer; }
   public String getOrderNumber() { return orderNumber; }

   //Protected, private helper methods
   protected void generateNewOrderNumber() {
      Integer orderSerial = ++lastNumber;
      orderNumber = "GL-" + orderSerial.toString() + "/2010";
   }

   public Integer getItemCount() {
      return items.size();
   }
}
