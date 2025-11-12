package fr.groupe.pcube;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ServiceOrderClient {
    private final Map<Client, Order> commandesEnCours;

    public ServiceOrderClient() {
        this.commandesEnCours = new HashMap<>();
    }

    private boolean clientExist(Client client) {
        return this.commandesEnCours.containsKey(client);
    }

    private boolean orderExist(Order order) {
        return this.commandesEnCours.values().contains(order);
    }

    public void addOrderToProcess(Client client)
            throws IllegalArgumentException {
        if (!this.clientExist(client)) {
            throw new IllegalArgumentException("Une commande existe déjà !");
        }
        this.commandesEnCours.put(client, new Order(client));
    }

    public void deleteOrder(Client client) throws IllegalArgumentException {
        if (!this.clientExist(client)) {
            throw new IllegalArgumentException(
                    "Aucune commandes n'existent avec le client "
                            + client.getName());
        }
        this.commandesEnCours.remove(client);
    }

    public void deleteOrder(Order order) throws IllegalArgumentException {
        if (!this.commandesEnCours.entrySet()
                .removeIf(c -> Objects.equals(c.getValue(), order))) {
            throw new IllegalArgumentException(
                    "Aucune commande n'existe avec l'order " + order.getId());
        }
    }

    public void clean() {
        this.commandesEnCours.clear();
    }

    public void addLine(Client client, Ligne ligne)
            throws IllegalArgumentException {
        if (!this.clientExist(client)) {
            throw new IllegalArgumentException(
                    "Aucune commandes n'existent avec le client "
                            + client.getName());
        }
        this.commandesEnCours.get(client).addLine(ligne);
    }

    public void addLine(Order order, Ligne ligne) {
        if (!this.orderExist(order)) {
            throw new IllegalArgumentException(
                    "Aucune commande n'existe avec l'order " + order.getId());
        }
        for (Map.Entry<Client, Order> m : this.commandesEnCours.entrySet()) {
            Order v = m.getValue();
            if (v.equals(order)) {
                v.addLine(ligne);
            }
        }
    }
}
