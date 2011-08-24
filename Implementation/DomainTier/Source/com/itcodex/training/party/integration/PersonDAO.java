package com.itcodex.training.party.integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import com.itcodex.training.party.domain.Person;

public class PersonDAO {
   public static final String PERSON_TABLE_NAME = "T_PERSON";
   public static final String ID_COLUMN_NAME = "id"; 
   public static final String ID_COLUMN_DEFINITION = ID_COLUMN_NAME + " identity NOT NULL PRIMARY KEY"; 
   public static final String FIRST_NAME_COLUMN_NAME = "firstName";
   public static final String FIRST_NAME_COLUMN_DEFINITION = FIRST_NAME_COLUMN_NAME + " VARCHAR(50)";
   public static final String LAST_NAME_COLUMN_NAME = "lastName";
   public static final String LAST_NAME_COLUMN_DEFINITION = LAST_NAME_COLUMN_NAME + " VARCHAR(50)";
   public static final String COLUMNS_DEFINITION = ID_COLUMN_DEFINITION + ", " + FIRST_NAME_COLUMN_DEFINITION + ", " + LAST_NAME_COLUMN_DEFINITION;
   public static final String CREATE_TABLE_STATEMENT_TEMPLATE = "CREATE TABLE {0} ({1})";
   public static final String INSERT_RECORD_STATEMENT_TEMPLATE = "INSERT INTO {0} ({1}) VALUES ({2})";
   public static final String SELECT_STATEMENT_TEMPLATE = "SELECT * FROM {0} WHERE {1}";
   private String driverName;
   private String connectionURL;
   private String user;
   private String password;
   private Connection connection;

   //Constructors
   public PersonDAO( String driverName, String connectionURL, String user, String password ) {
      this.driverName = driverName;
      this.connectionURL = connectionURL;
      this.user = user;
      this.password = password;
   }

   //Public mutator and accessor methods
   public void close() {
      try{
         connection.close();
      }catch( SQLException e ){ e.printStackTrace(); }
   }

   public Connection connect() {
      try{
         Class.forName( driverName );
         connection = DriverManager.getConnection( connectionURL, user, password );
         connection.setAutoCommit( true );
      }catch( ClassNotFoundException e ){ e.printStackTrace();
      }catch( SQLException e ){ e.printStackTrace(); }
      return connection;
   }

   public Integer executeUpdate( String sqlStatement ) {
      Statement statement = null;
      Integer updateResult = null;
      try{
         statement = connection.createStatement();
         updateResult = statement.executeUpdate( sqlStatement );
         statement.close();
      }catch( SQLException e ){
         e.printStackTrace();
      }
      return updateResult;
   }

   public Person findPersonByName( String lastName, String firstName ) {
      String where = FIRST_NAME_COLUMN_NAME + " = '" + firstName + "' AND " + LAST_NAME_COLUMN_NAME + " = '" + lastName + "'";
      ResultSet resultSet = executeQuery( where );
      Integer id = null;
      try{
         resultSet.next();
         id = resultSet.getInt( ID_COLUMN_NAME );
      }catch( SQLException e ){
         e.printStackTrace();
      }
      return new Person( id, lastName, firstName );
   }

   public ResultSet executeQuery( String where ) {
      String sql = MessageFormat.format( SELECT_STATEMENT_TEMPLATE, new Object[]{PERSON_TABLE_NAME, where } );
      Statement statement = null;
      ResultSet resultSet = null;
      try{
         statement = connection.createStatement();
         resultSet = statement.executeQuery( sql );
      }catch( SQLException e ){
         e.printStackTrace();
      }
      return resultSet;
   }

   //Properties
   public Connection getConnection() { return connection; }

}
