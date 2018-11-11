package br.com.sicredi.testeQA.rest.api;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

/**
 * Classe de teste para a API Simulador do Woop Sicredi
 * @author Ruan Osorio 
 * @since 11/11/2018
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimuladorApiTest {
	String uriBase = "http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador";
	
	@Test
	public void testAGetSucessoConsultaSimulacao() {
		
		given()
			.relaxedHTTPSValidation()
			.param("id", "1")
		.when()
			.get(uriBase)
		.then()
			.body("id", notNullValue())
			.body("meses", notNullValue())
			.body("valor", notNullValue())
			.statusCode(200)
			.contentType(ContentType.JSON);
	}
	
	@Test
	public void testBPostSucessoCriarSimulacao() {
		
		given()
			.relaxedHTTPSValidation()
			.body("{\"meses\" : \"12\"}")
			.body("{\"valor\" : \"50.00\"}")
		.when()
			.post(uriBase)
		.then()
			.statusCode(201)
			.contentType(ContentType.JSON);
	}

	@Test
	public void testCDeleteFalhaRequisicaoInvalidaSimulacao() {
				
		given()
			.relaxedHTTPSValidation()
		.when()
			.delete(uriBase + "?id=2")
		.then()
			.statusCode(400)
			.contentType(ContentType.JSON)
			.body("msg", equalTo("Invalid request"));
	}
	
	@Test
	public void testDGetSucessoApiSemAutenticacaoSimulacao() {
		RestAssured.authentication = RestAssured.DEFAULT_AUTH;
		
		given()
			.relaxedHTTPSValidation()
		.when()
			.get(uriBase)
		.then()
			.statusCode(200);
	}	
	
}
