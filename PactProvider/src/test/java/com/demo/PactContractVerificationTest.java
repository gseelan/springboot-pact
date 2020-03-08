package com.demo;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;

@Provider("Pact Provider")
@PactFolder("target/pacts")
public class PactContractVerificationTest {

	@TestTemplate
	@ExtendWith(PactVerificationInvocationContextProvider.class)
	void pactVerificationTestTemplate(PactVerificationContext context) {
		context.verifyInteraction();
	}
	
    @State("Success Flow")
    public void toDefaultState() {
      
    }
    
    @State("Exception One")
    public void toDefaultState2() {
      
    }
    
    @State("Exception Two")
    public void toDefaultState3() {
      
    }
}
