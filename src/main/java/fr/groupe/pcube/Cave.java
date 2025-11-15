package fr.groupe.pcube;

import java.util.HashMap;
import java.util.Map;

public class Cave {
    private Map<Vin, Integer> vins;

    public Cave(){
        this.vins = new HashMap<>();
    }

    public int getStock(Vin vin){
        if(this.vins.containsKey(vin)){
            return this.vins.get(vin);
        }
        throw new IllegalArgumentException("Le vin n'existe pas");
    }

    public void addStock(Vin vin, int stock){
        if(!this.vins.containsKey(vin)){
            this.vins.put(vin, 0);
        }
        this.vins.put(vin, this.vins.get(vin) + stock);
    }

    public void decreaseStock(Vin vin, int amount){
        if(!this.vins.containsKey(vin)) throw new IllegalArgumentException("Pas de vin : "+ vin.getName());
        if(this.vins.get(vin) < amount) throw new IllegalArgumentException("Pas assez de vin : "+vin.getName());
        this.vins.put(vin, this.vins.get(vin) - amount);
    }
}
