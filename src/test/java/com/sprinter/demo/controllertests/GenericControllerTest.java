package com.sprinter.demo.controllertests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprinter.demo.controller.ClientController;
import com.sprinter.demo.model.Client;
import com.sprinter.demo.service.ClientService;
import com.sprinter.demo.testutils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class GenericControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Test
    public void addClientTest() throws Exception {
        Client client = Client.builder().name("Test Name").email("6ussyqkpik@blu.it").dni("05544922J").build();

        given(clientService.add(client)).willReturn(client);

        mockMvc.perform(post("/clients/").contentType(MediaType.APPLICATION_JSON).
                        content(JsonUtils.toJson(client))).andDo(print()).andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(client.getName())));

    }

    @Test
    public void getAllClientsTest() throws Exception {
        Client client = Client.builder().name("Test Name").email("6ussyqkpik@blu.it").dni("05544922J").build();
        List<Client> allUsers = List.of(client);

        given(clientService.findAll()).willReturn(allUsers);

        mockMvc.perform(get("/clients/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(client.getName())));

    }

    @Test
    public void deleteClientTest() throws Exception {
        Client client = Client.builder().name("Test Name").email("6ussyqkpik@blu.it").dni("05544922J").id(1L).build();
        doNothing().when(clientService).delete(client.getId());

        mockMvc.perform(delete("/clients/client?id=" + client.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getClientByIdTest() throws Exception {
        Client client = Client.builder().name("Test Name").email("6ussyqkpik@blu.it").dni("05544922J").id(1L).build();

        given(clientService.findById(client.getId())).willReturn(client);

        mockMvc.perform(get("/clients/client?id=" + client.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("name", is(client.getName())));
    }


    @Test
    public void updateClientTest() throws Exception {
        Client client = Client.builder().name("Test Name").email("6ussyqkpik@blu.it").dni("05544922J").id(1L).build();

        given(clientService.update(client.getId(), client)).willReturn(client);

        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(put("/clients/client?id=" + client.getId()).content(mapper.writeValueAsString(client))
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(client.getName())));
    }
}
