package com.itcodex.training.party.integration;

import hu.itkodex.litest.template.RepositoryTestEnvironment;
import hu.itkodex.litest.template.RepositoryTestFixture;

import com.itcodex.training.party.domain.Person;
import com.itcodex.training.party.integration.PersonRepository;

public class PersonRepositoryTestFixture extends RepositoryTestFixture<PersonRepository, Person> {

   protected PersonRepositoryTestFixture( RepositoryTestEnvironment<PersonRepository, RepositoryTestFixture<PersonRepository, Person>> testEnvironment ) {
      super( testEnvironment );
   }

   @Override
   protected void afterAggregateCreation() {
   }

   @Override
   protected void afterAggregateDeletion() {
   }

   @Override
   protected void beforeAggregateCreation() {
   }

   @Override
   protected Person createNewAggregate() throws Exception {
      return null;
   }

}
