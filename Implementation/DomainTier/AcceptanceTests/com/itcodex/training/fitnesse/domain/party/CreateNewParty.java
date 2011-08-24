package com.itcodex.training.fitnesse.domain.party;

import com.itcodex.training.party.domain.Party;
import com.itcodex.training.party.integration.PartyRepository;

import fitlibrary.SetUpFixture;

public class CreateNewParty extends SetUpFixture {
   public String name;
   public String type;
   
   public void nameType( String name, String type ) {
      this.name = name;
      this.type = type;
      
      PartyRepository.add( new Party( name ));
   }
}
