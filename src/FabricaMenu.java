import java.util.List;

import Entidades.Inventario;
import Utileria.Input;
import Utileria.MisErrores;

public class FabricaMenu {

    private static boolean validarInventario(List<Inventario> lInventarios, String nombre) {
        boolean state = true;
        for (Inventario inventario : lInventarios) {
            if(inventario.getBodega().toLowerCase().replace(" ", "").equals(nombre.toLowerCase().replace(" ",""))) {
                state = false;
                break;
            }
            else {}
        }
        return state;
    }
    
    public static Inventario getSelMenu1(List<Inventario> inventarios) {  
        Input.input().nextLine();
        System.out.println("\nIngrese el nombre del inventario: ");
        System.out.print("> ");

        String nombre = Input.input().nextLine().trim();

        if(validarInventario(inventarios, nombre)) {
            return new Inventario(nombre);
        }
        else {
            return null;
        }
    }

    public static void setInventario(List<Inventario> list) {
        int res = 0;
        do {
            try {
                System.out.println(
                    "\n##################################################\n" +
                    "#                   Inventarios                  #\n" +
                    "##################################################" 
                );

                for (int x=0; x<list.size();x++) {
                    System.out.println("# " + (x+1) + ") " + list.get(x).getBodega());
                }
            
                System.out.println(
                    "# " + (list.size() + 1) + ") Regresar" +
                    "\n##################################################"
                );
                
            
                System.out.println("\nSeleccione inventario: ");
                System.out.print("> ");
                res = Input.input().nextInt();

                if(res > 0 && res <= list.size()) {
                    FabricaMenu2.menu2(list.get(res-1));
                }
                else if(res > list.size() + 1) {
                    MisErrores.seleccionIncorrecta();
                }
                else {}

            } catch (Exception e) {
                MisErrores.soloNumeros();
            }
        } while (res != list.size() + 1);
    }

}
