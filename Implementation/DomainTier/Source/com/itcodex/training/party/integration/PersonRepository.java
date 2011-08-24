package com.itcodex.training.party.integration;

import hu.itkodex.commons.persistence.PersistenceStrategy;

import com.itcodex.training.party.domain.Person;
import com.processpuzzle.application.configuration.domain.ProcessPuzzleContext;
import com.processpuzzle.persistence.domain.GenericRepository;

public class PersonRepository extends GenericRepository<Person> {

   public PersonRepository( PersistenceStrategy strategy, ProcessPuzzleContext applicationContext ) {
      super( strategy, applicationContext );
   }

}
