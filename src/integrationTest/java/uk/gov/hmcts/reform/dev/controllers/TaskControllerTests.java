package uk.gov.hmcts.reform.dev.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import uk.gov.hmcts.reform.dev.Application;
import uk.gov.hmcts.reform.dev.repositories.TaskRepository;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@WebMvcTest
class TaskControllerTests {

    @Mock
    private transient TaskRepository taskRepository;

    @InjectMocks
    private transient TaskController controller;

    private transient WebTestClient client;

    @BeforeEach
    void initApplication() {
        client = WebTestClient.bindToController(new TaskController()).build();
    }

    @DisplayName("Should return list of tasks")
    @Test
    void indexEndpoint() throws Exception {
        client.get().uri("/index")
            .exchange()
            .expectAll(
                x -> x.expectHeader().contentType(MediaType.APPLICATION_JSON),
                x -> x.expectStatus().isOk(),
                x -> x.expectBody().json("[]")
            );
    }
}
