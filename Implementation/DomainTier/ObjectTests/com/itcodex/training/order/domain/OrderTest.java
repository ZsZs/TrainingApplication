package com.itcodex.training.order.domain;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.itcodex.training.order.domain.Order;
import com.itcodex.training.order.domain.OrderItem;
import com.itcodex.training.party.domain.Party;

public class OrderTest {
   private static final Double FIRST_ITEM = 15.0;
   private static final Double SECOND_ITEM = 40.0;
   private static final Double ITEM_TOTAL = 55.0;
   private static final Double ITEM_TOTAL_WITH_NEW = 65.0;
   private static final Integer STARTING_ORDER_NUMBER = 222;
   private Party vendor;
   private Party customer;
   private Order previousOrder;
   private Order newOrder;
   private OrderItem firstItem;
   private OrderItem secondItem;
   private OrderItem newItem;

   @Before
   public void beforeEachTest() {
      
      vendor = mock( Party.class );
      customer = mock( Party.class );
   
      Order.initializeOrderNumber( STARTING_ORDER_NUMBER );
      
      
      previousOrder = new Order( vendor, customer );
      newOrder = new Order( vendor, customer );

   }

   @Test
   public void construction_NeedsVendorAndCustomer() {
      assertThat( newOrder.getVentor(), notNullValue() );
      assertThat( newOrder.getVentor(), instanceOf( Party.class ));
      
      assertThat( newOrder.getCustomer(), notNullValue() );
   }
   
   @Test
   public void construction_CreatesOrderNumber() {
      assertThat( newOrder.getOrderNumber(), notNullValue() );
      assertThat( newOrder.getOrderNumber(), equalTo( formattedOrderNumber( STARTING_ORDER_NUMBER + 2 ) ));
      
   }
   
   @Test
   public void constructor_IncreasesTheOrderNumber() {
      assertThat( newOrder.getOrderNumber(), equalTo( incrementOrderNumeber( previousOrder.getOrderNumber() )));
   }
   
   @Test
   public void total_SumsTheItemPrices() {
      stubItems();

      assertThat( newOrder.getItemCount(), equalTo( 2 ));
      
      newOrder.total();
      verify( firstItem ).getPrice();
      
      assertThat( newOrder.total(), equalTo( ITEM_TOTAL ));

      newOrder.addItem( newItem );
      assertThat( newOrder.total(), equalTo( ITEM_TOTAL_WITH_NEW ));
   }

   private String formattedOrderNumber( Integer orderSerialNumber ) {
      return "GL-" + orderSerialNumber + "/2010";
   }

   private String incrementOrderNumeber( String orderNumber ) {
      Integer orderSerial = new Integer( orderNumber.substring( 3, orderNumber.indexOf( "/" )));
      return "GL-" + ++orderSerial + "/2010";
   }

   private void stubItems() {
      firstItem = mock( OrderItem.class );
      when( firstItem.getPrice() ).thenReturn( FIRST_ITEM );
      
      secondItem = mock( OrderItem.class );
      when( secondItem.getPrice() ).thenReturn( SECOND_ITEM );
      
      newItem = mock( OrderItem.class );
      when( newItem.getPrice() ).thenReturn( 10.0 );
      
      newOrder.addItem( firstItem );
      newOrder.addItem( secondItem );
   }
}
