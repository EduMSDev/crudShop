package com.sprinter.demo.repositorytests;

import com.sprinter.demo.model.Client;
import com.sprinter.demo.repository.ClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void notFindClientsTest() {
        Iterable<Client> clients = clientRepository.findAll();

        assertThat(clients).isEmpty();
    }

    @Test
    public void addClientTest() {
        Client client = clientRepository.save(Client.builder().name("Test Name").email("6ussyqkpik@blu.it").dni("05544922J").build());

        assertThat(client).hasFieldOrPropertyWithValue("name", "Test Name");
    }

    @Test
    public void findAllClientTest() {
        Client client1 = Client.builder().name("Test Name").email("6ussyqkpik@blu.it").dni("05544922J").build();
        Client client2 = Client.builder().name("Test Name").email("02e35mgln6@unforgettable.com").dni("02546050L").build();
        Client client3 = Client.builder().name("Test Name").email("k0s55coi@lycos.it").dni("99610256Q").build();
        entityManager.persist(client1);
        entityManager.persist(client2);
        entityManager.persist(client3);

        Iterable<Client> clients = clientRepository.findAll();

        assertThat(clients).hasSize(3).contains(client1, client2, client3);
    }

    @Test
    public void findClientByIdTest() {
        Client client1 = Client.builder().name("Test Name1").email("6ussyqkpik@blu.it").dni("05544922J").build();
        Client client2 = Client.builder().name("Test Name2").email("k0s55coi@lycos.it").dni("99610256Q").build();
        entityManager.persist(client1);
        entityManager.persist(client2);

        Client getClient = clientRepository.findById(client2.getId()).get();

        assertThat(getClient).isEqualTo(client2);
    }

}
