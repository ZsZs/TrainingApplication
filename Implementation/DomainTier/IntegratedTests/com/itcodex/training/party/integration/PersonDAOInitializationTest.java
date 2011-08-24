package com.itcodex.training.party.integration;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonDAOInitializationTest {
   private PersonDAOFixture fixture;
   
   @Before
   public void beforeEachTests() {
      fixture = new PersonDAOFixture();
      fixture.setUp();
   }
   
   @After public void afterEachTests() {
      fixture.tearDown();
   }
   
   @Test public void connect_WhenSuccessfull_ReturnsJdbcConnection() throws SQLException {
      fixture.getPersonDAO().connect();
      
      assertThat( fixture.getPersonDAO().getConnection(), instanceOf( Connection.class ));
      assertThat( fixture.getPersonDAO().getConnection().isClosed(), is( false ));
   }
   
   @Test public void close_WhenConnected_ClosesTheConnection() throws SQLException {
      fixture.getPersonDAO().connect();
      fixture.getPersonDAO().close();
      
      assertThat( fixture.getPersonDAO().getConnection().isClosed(), is( true ));
   }
}
