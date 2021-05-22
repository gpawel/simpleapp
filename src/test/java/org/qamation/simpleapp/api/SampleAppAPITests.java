package org.qamation.simpleapp.api;


import org.junit.jupiter.api.Test;
import org.qamation.simpleapp.controllers.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleAppAPITests {

    //@Autowired
    private WebTestClient webTestClient = WebTestClient.bindToController(EmployeeController.class).build();;

    @Test
    public void testAll() {
        this.webTestClient
                .get()
                .uri("/employee/all")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.length()").isEmpty();
    }
}
