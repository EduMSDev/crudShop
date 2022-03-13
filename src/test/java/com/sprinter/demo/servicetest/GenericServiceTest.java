package com.sprinter.demo.servicetest;

import com.sprinter.demo.model.Client;
import com.sprinter.demo.repository.ClientRepository;
import com.sprinter.demo.repository.GenericRepository;
import com.sprinter.demo.service.GenericService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GenericServiceTest {

    public final String TEST_NAME = "Test Name";

    @InjectMocks
    private GenericService<Client, ClientRepository> genericService;

    @Mock
    private GenericRepository<Client> genericRepository;

    @Test
    public void addClientTest() {
        Client client = Client.builder().name(TEST_NAME).id(1L).build();

        when(genericRepository.save(ArgumentMatchers.any(Client.class))).thenReturn(client);
        Client newClient = genericService.add(client);

        assertThat(newClient.getName()).isSameAs(client.getName());
        assertThat(newClient.getId()).isSameAs(client.getId());
        verify(genericRepository).save(client);
    }

    @Test
    public void getAllClientsTest() {
        List<Client> clients = new ArrayList<>();
        clients.add(Client.builder().build());

        given(genericRepository.findAll()).willReturn(clients);
        List<Client> expected = genericService.findAll();

        assertEquals(expected, clients);
        verify(genericRepository).findAll();
    }

    @Test
    public void deleteClientTest() {
        Client client = Client.builder().name(TEST_NAME).id(1L).build();

        genericService.delete(client.getId());
        verify(genericRepository).deleteById(client.getId());
    }

    @Test
    public void updateClientTest() {
        Client client = Client.builder().name(TEST_NAME).id(1L).build();
        Client newClient = Client.builder().name("NewTestName").build();
        ;

        given(genericRepository.findById(client.getId())).willReturn(Optional.of(client));
        genericService.update(client.getId(), newClient);

        verify(genericRepository).findById(client.getId());
        verify(genericRepository).save(newClient);
        assertThat(client.getId()).isSameAs(newClient.getId());
    }

    @Test
    public void findClientById() {
        Client client = Client.builder().id(1L).build();
        client.setId(1L);

        when(genericRepository.findById(client.getId())).thenReturn(Optional.of(client));
        Client expected = genericService.findById(client.getId());

        assertThat(expected).isSameAs(client);
        verify(genericRepository).findById(client.getId());
    }


}
