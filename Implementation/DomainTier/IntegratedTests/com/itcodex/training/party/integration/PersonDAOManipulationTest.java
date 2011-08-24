package com.itcodex.training.party.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonDAOManipulationTest {
   private static final String DUMMY_TABLE = "DUMMY_TABLE";
   private static PersonDAOFixture fixture;
   
   @BeforeClass public static void beforeAllTests() {
      fixture = new PersonDAOFixtureForManipulation();
      fixture.setUp();
   }
   
   @Before
   public void beforeEachTests() {
   }
   
   @After
   public void afterEachTests() {
   }
   
   @AfterClass public static void afterAllTests() {
      fixture.tearDown();
   }
   
   @Test public void executeStatement_RunsSQL() throws SQLException {
      fixture.getPersonDAO().executeUpdate( "create table " + DUMMY_TABLE + "( ID identity NOT NULL PRIMARY KEY, Column_One VARCHAR(20), Column_Two VARCHAR(20))" );
      
      DatabaseMetaData databaseMetaData = fixture.getPersonDAO().getConnection().getMetaData();
      ResultSet tables = databaseMetaData.getTables( null, null, null, null );
      assertThat( tables.first(), is( true ) );
      
      boolean newTableFounded = false;
      while( tables.next() ){
         if( (tables.getString( 3 ).equals( DUMMY_TABLE )) && ( tables.getString( 4 ).equals( "TABLE" )))
            newTableFounded = true;
         //System.out.println( tables.getString( 3 ) + " - " + tables.getString( 4 ) );
      }
      assertThat( newTableFounded, is( true ) );
   }
   
   @Test
   public void findPersonByName_ReturnsSinglePersonObject() {
      assertThat( fixture.getPersonDAO().findPersonByName( 
            PersonDAOFixtureForManipulation.PERSON_LAST_NAME, PersonDAOFixtureForManipulation.PERSON_FIRST_NAME ).getFullName(), 
            equalTo( PersonDAOFixtureForManipulation.PERSON_FULL_NAME ) );
   }

}
