package com.itcodex.training.party.integration;

import java.text.MessageFormat;

public class PersonDAOFixtureForManipulation extends PersonDAOFixture {
   public static final String PERSON_FIRST_NAME = "John";
   public static final String PERSON_LAST_NAME = "Smith";
   public static final String PERSON_FULL_NAME = "John Smith";

   @Override
   public void setUp() {
      super.setUp();
      personDAO.connect();
      createPersonTable();
      addPersons();
   }

   @Override
   public void tearDown() {
      super.tearDown();
      personDAO.close();
   }

   private void addPersons() {
      String columns = PersonDAO.ID_COLUMN_NAME + ", " + PersonDAO.FIRST_NAME_COLUMN_NAME + ", " + PersonDAO.LAST_NAME_COLUMN_NAME;
      String values = "1, '" + PERSON_FIRST_NAME + "', '" + PERSON_LAST_NAME + "'"; 
      String insertRecordStatement = MessageFormat.format( PersonDAO.INSERT_RECORD_STATEMENT_TEMPLATE, new Object[] {PersonDAO.PERSON_TABLE_NAME, columns, values});
      personDAO.executeUpdate( insertRecordStatement );
   }

   private void createPersonTable() {
      String createTableStatement = MessageFormat.format( PersonDAO.CREATE_TABLE_STATEMENT_TEMPLATE, new Object[] { PersonDAO.PERSON_TABLE_NAME, PersonDAO.COLUMNS_DEFINITION } );
      personDAO.executeUpdate( createTableStatement );
   }

}
