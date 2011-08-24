package com.itcodex.training.party.integration;

import com.itcodex.training.party.domain.Person;
import com.itcodex.training.party.integration.PersonRepository;
import com.itcodex.training.sharedfixtures.TrainingExerciseTestConfiguration;

import hu.itkodex.litest.template.RepositoryTestTemplate;


public class PersonRepositoryTest extends RepositoryTestTemplate<PersonRepository, PersonRepositoryTestFixture, Person> {

   public PersonRepositoryTest( ) {
      super( TrainingExerciseTestConfiguration.FIXTURE_CONTAINER_DEFINITION_PATH );
   }

   @Override
   public void testAdd_ForOwnedAttributesAndComponents() throws Exception {
   }

   @Override
   public void testAdd_ForReferencedAggregateRoots() {
   }

   @Override
   public void testDelete_ForOwnedAttributesAndComponents() throws Exception {
   }

   @Override
   public void testFindAll_ForResultCount() {
   }

   @Override
   public void testFindById() {
   }

   @Override
   public void testFindById_ForEagerLoadedComponents() {
   }

   @Override
   public void testFindById_ForLazyLoadedComponents() {
   }

   @Override
   public void testFindByQuery_ForComponentAttributes() {
   }

   @Override
   public void testFindByQuery_ForDirectAttributes() {
   }

   @Override
   public void testUpdate_ForOwnedAttributesAndComponents() throws Exception {
   }

   @Override
   public void testUpdate_ForReferencedAggregateRoots() {
   }

}
