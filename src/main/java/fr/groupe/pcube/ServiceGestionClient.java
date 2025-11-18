package fr.groupe.pcube;

import java.util.HashMap;
import java.util.Map;

public class ServiceGestionClient {

    private ClientRepository clientRepository;


    public ServiceGestionClient(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(String firstName, String lastName, String email, Address address){
        Client exists = clientRepository.findByEmail(email);
        if(exists != null){
            return exists;
        }
        Client newClient = new Client(firstName, lastName, email, address);
        clientRepository.save(newClient);
        return newClient;
    }

    public Client getClient(String email){
        Client client = clientRepository.findByEmail(email);
        if(client == null){
            throw new IllegalArgumentException("Aucun client avec le mail : "+email);
        }
        return client;
    }

    public void deleteClient(String email){
        Client client = clientRepository.findByEmail(email);
        if(client != null){
            clientRepository.deleteById(client.getId());
        }
    }
}
