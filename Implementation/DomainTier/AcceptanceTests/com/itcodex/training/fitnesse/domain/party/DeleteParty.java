package com.itcodex.training.fitnesse.domain.party;

import com.itcodex.training.party.integration.PartyRepository;

import fitlibrary.SetUpFixture;

public class DeleteParty extends SetUpFixture {
   public void name( String name ) {
      PartyRepository.delete( name );
   }
}
