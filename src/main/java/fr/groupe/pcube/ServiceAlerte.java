package fr.groupe.pcube;

public class ServiceAlerte {
    private Cave cave;

    public ServiceAlerte(Cave cave) {
        this.cave = cave;
    }

    public void checkStock(Vin vin){
        try{
            if(this.cave.getStock(vin) < vin.getSeuil()){
                System.out.println("VIN : "+vin.getName()+" BAS !");
            }else{
                System.out.println("ok");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
