package com.itcodex.training.party.integration;

import java.util.HashMap;
import java.util.Map;

import com.itcodex.training.party.domain.Party;

public class PartyRepository {
   private static Map<String,Party> parties = new HashMap<String, Party>();

   public static void add( Party party ) {
      parties.put( party.getName(), party );
   }

   public static void delete( String name ) {
      parties.remove( name );
   }

   public static Party findPartyByName( String partyName ) {
      return parties.get( partyName );
   }

}
