package com.itcodex.training.party.domain;

import hu.itkodex.commons.persistence.AggregateRoot;

import com.processpuzzle.fundamental_types.domain.GenericEntity;
import com.processpuzzle.persistence.query.domain.DefaultIdentityExpression;

public class Person extends GenericEntity<Person> implements AggregateRoot {
   private String lastName;
   private String firstName;
   
   public Person( Integer id, String lastName, String firstName ) {
      this.id = id;
      this.lastName = lastName;
      this.firstName = firstName;
   }

   @Override
   protected void defineIdentityExpressions() {}

   @Override
   public <I extends DefaultIdentityExpression<Person>> I getDefaultIdentity() {
      return null;
   }

   public String getFullName() { return firstName + " " + lastName; }

   //Properties
   public String getFirstName() { return firstName; }
   public String getLastName() { return lastName; }
}
