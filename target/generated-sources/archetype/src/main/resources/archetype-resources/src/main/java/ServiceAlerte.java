#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

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
