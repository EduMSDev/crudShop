package com.sprinter.demo.controllertests;

import com.sprinter.demo.controller.ClientController;
import com.sprinter.demo.model.Client;
import com.sprinter.demo.repository.ClientRepository;
import com.sprinter.demo.service.GenericService;
import com.sprinter.demo.testutils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class GenericControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GenericService<Client, ClientRepository> genericService;

    @Test
    public void addClient() throws Exception {
        Client client = Client.builder().name("Test Name").build();

        given(genericService.add(client)).willReturn(client);

        mockMvc.perform(post("/clients").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(client))).andExpect(status().isCreated()).andExpect((ResultMatcher) jsonPath("$.name", is(client.getName())));
    }
}
