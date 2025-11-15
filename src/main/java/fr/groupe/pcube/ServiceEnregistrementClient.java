package fr.groupe.pcube;

import java.util.ArrayList;
import java.util.List;

public class ServiceEnregistrementClient {
    private List<Client> clients;

    public ServiceEnregistrementClient(){
        this.clients = new ArrayList<>();
    }

    public void enregistrer(Client client){
        if(clients.contains(client)){
            System.out.println("Client déjà existant");
        }else{
            clients.add(client);
        }
    }
}
// Gerera avec la DB.