package com.itcodex.training.party.integration;

public class PersonDAOFixture {
   protected static final String JDBC_CONNECTION_URL = "jdbc:hsqldb:mem:TRAINING_APPLICATION_DB";
   protected static final String JDBC_DRIVER_NAME = "org.hsqldb.jdbc.JDBCDriver";
   protected static final String USER = "sa";
   protected static final String PASSWORD = "";
   protected PersonDAO personDAO;

   public void setUp() {
      personDAO = new PersonDAO( JDBC_DRIVER_NAME, JDBC_CONNECTION_URL, USER, PASSWORD );
   }
   
   public void tearDown() {
      personDAO.close();
   }

   public PersonDAO getPersonDAO() { return personDAO; }

}
