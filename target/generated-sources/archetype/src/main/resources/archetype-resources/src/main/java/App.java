#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.List;

/**
 * JavaFX App
 */
public class App {

    public static void main(String[] args) {
        VinRepository vr = new VinRepository();
        Vin vin1 = new Vin("test", "Bordeau", 10, 52);
        Vin vin2 = new Vin("test2", "VCliquot", 10, 5);
        Vin vin3 = new Vin("test3", "Pnoir", 10, 15);
        vr.save(vin1);
        vr.save(vin2);
        vr.save(vin3);
        List<Vin> list = vr.findAll();
        list.forEach(v -> System.out.println(v));
    }

}