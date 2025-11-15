package fr.groupe.pcube;

public class ServiceAlerte {
    private Cave cave;
    private int seuil;

    public ServiceAlerte(Cave cave, int seuil) {
        this.cave = cave;
        this.seuil = seuil;
    }

    public void checkStock(Vin vin){
        try{
            if(this.cave.getStock(vin) < seuil){
                System.out.println("VIN : "+vin.getName()+" BAS !");
            }else{
                System.out.println("ok");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
