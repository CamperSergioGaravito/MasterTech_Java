import java.util.ArrayList;
import java.util.List;

import Entidades.Inventario;
import Utileria.*;

public class App {

    private static List<Inventario> inventarios = new ArrayList<>();

    private static void setMenu() {
        int sel = 0;

        do {
            try {
                
                System.out.println(
                    "\n##################################################\n" +
                    "#                      MENU                      #\n" +
                    "##################################################\n" +
                    "#  1) Crear inventario                           #\n" +
                    "#  2) Seleccionar inventario                     #\n" +
                    "#  3) Salir                                      #\n" +
                    "##################################################\n"
                );
                System.out.print("> ");

                /* FabricaMenu menu1 = new FabricaMenu(); */
                sel = Input.input().nextInt();
                
                if(sel == 1) {
                    Inventario newInvetario = FabricaMenu.getSelMenu1(inventarios);
                    
                    if(newInvetario != null) {
                        inventarios.add(newInvetario);
                        System.out.println("\nInventario creado con éxito.\n");
                    }
                    else {
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.out.println("\nYa existe el inventario seleccionado o muy parecido");
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    }
                    
                }
                else if (sel == 2) {
                    FabricaMenu.setInventario(inventarios);
                }
                else if(sel == 3) {
                    System.out.println("\nAdios!");
                }

                else {
                    MisErrores.seleccionIncorrecta();
                }
                
                
       
            } catch (Exception e) {
                MisErrores.soloNumeros();
            }
        } while (sel != 3);

    }

    public static void main(String[] args) throws Exception {
        setMenu();
    }
}
