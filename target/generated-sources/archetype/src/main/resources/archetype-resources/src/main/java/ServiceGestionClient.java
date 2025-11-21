#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

public class ServiceGestionClient {

    private ClientRepository clientRepository;


    public ServiceGestionClient(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(String firstName, String lastName, String email, Address address){
        Client exists = this.clientRepository.findByEmail(email);
        if(exists != null){
            return exists;
        }
        Client newClient = new Client(firstName, lastName, email, address);
        this.clientRepository.save(newClient);
        return newClient;
    }

    public Client getClient(String email){
        Client client = this.clientRepository.findByEmail(email);
        if(client == null){
            throw new IllegalArgumentException("Aucun client avec le mail : "+email);
        }
        return client;
    }

    public void deleteClient(String email){
        Client client = this.clientRepository.findByEmail(email);
        if(client != null){
            this.clientRepository.deleteById(client.getId());
        }
    }
}
