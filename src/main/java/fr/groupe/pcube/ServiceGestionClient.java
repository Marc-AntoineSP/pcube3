package fr.groupe.pcube;

import java.util.HashMap;
import java.util.Map;

public class ServiceGestionClient {
    private Map<String, Client> clients; //Gestion mémoire, Map pour retrieve avec mail.

    public ServiceGestionClient(){
        this.clients = new HashMap<>();
    }

    public void addClient(Client client){
        if(this.clients.containsKey(client.getEmail())) throw new IllegalArgumentException("Le client existe déjà !");
        this.clients.put(client.getEmail(), client);
    }

    public Client getClient(String email){
        return this.clients.getOrDefault(email, null);
    }
}
