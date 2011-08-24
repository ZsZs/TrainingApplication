package com.itcodex.training.fitnesse.sandbox;

import fit.ColumnFixture;

public class Echo extends ColumnFixture {
   public String message;
   
   public String echo() { return message; }
}
