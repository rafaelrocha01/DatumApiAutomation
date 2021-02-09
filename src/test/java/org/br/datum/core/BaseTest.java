package org.br.datum.core;

import io.restassured.RestAssured;

import static org.br.datum.config.Parametro.urlApi;

public class BaseTest {

    public BaseTest(){
        RestAssured.baseURI = urlApi;
    }
}
