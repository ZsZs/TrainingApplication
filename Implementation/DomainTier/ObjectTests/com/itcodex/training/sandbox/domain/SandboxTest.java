package com.itcodex.training.sandbox.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SandboxTest {
	private static final String SANDBOX_NAME = "Hello world!";

	@Test public void instantiation_Requires_Name() {
		Sandbox newSandbox = new Sandbox( SANDBOX_NAME );
		assertThat( newSandbox, notNullValue() );
		assertThat( newSandbox.getName(), equalTo(SANDBOX_NAME ));
	}

}
