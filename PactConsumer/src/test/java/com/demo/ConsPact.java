package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.model.RequestResponsePact;

@ExtendWith(PactConsumerTestExt.class)
public class ConsPact {

	@Pact(provider = "Pact Provider", consumer = "Pact Consumer")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		return builder.given("Success Flow").uponReceiving("Seelan & 29").path("/pro/seelan/29").method("GET")
				.willRespondWith().status(200).body("{\"name\":\"seelan\",\"age\":29,\"welcome\":\"Hello seelan\"}")
				.toPact();
	}

	@Pact(provider = "Pact Provider", consumer = "Pact Consumer")
	public RequestResponsePact createPact1(PactDslWithProvider builder) {
		return builder.given("Exception One").uponReceiving("Seelan & 50").path("/pro/seelan/50").method("GET")
				.willRespondWith().status(404).body("This is not accepted.").toPact();
	}

	@Pact(provider = "Pact Provider", consumer = "Pact Consumer")
	public RequestResponsePact createPact2(PactDslWithProvider builder) {
		return builder.given("Exception Two").uponReceiving("Seelan & 55").path("/pro/seelan/55").method("GET")
				.willRespondWith().status(404).body("This is not ok too.").toPact();
	}

	@Test
	@PactTestFor(pactMethod = "createPact")
	void TestServer(MockServer mockServer) throws IOException {
		HttpResponse httpResponse = Request.Get(mockServer.getUrl() + "/pro/seelan/29").execute().returnResponse();
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
	}

	@Test
	@PactTestFor(pactMethod = "createPact1")
	void TestServer2(MockServer mockServer) throws IOException {
		HttpResponse httpResponse = Request.Get(mockServer.getUrl() + "/pro/seelan/50").execute().returnResponse();
		assertEquals(404, httpResponse.getStatusLine().getStatusCode());
	}

	@Test
	@PactTestFor(pactMethod = "createPact2")
	void TestServer3(MockServer mockServer) throws IOException {
		HttpResponse httpResponse = Request.Get(mockServer.getUrl() + "/pro/seelan/55").execute().returnResponse();
		assertEquals(404, httpResponse.getStatusLine().getStatusCode());
	}

}
