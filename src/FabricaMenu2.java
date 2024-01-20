import Entidades.Inventario;
import Utileria.Input;
import Utileria.MisErrores;

public class FabricaMenu2 {
    
    public static void menu2(Inventario inventario) {
        int res = 0;
        boolean flag = true;

        do {
            try {
                if(flag) {
                    System.out.println(
                        "\n##################################################\n" +
                        " * " + inventario.getBodega() + "\n" +
                        "##################################################\n" +
                        "#  1) Crear estante                              #\n" +
                        "#  2) Ver categorías                             #\n" +
                        "#  3) Agregar categorías                         #\n" +
                        "#  4) Agregar productos                          #\n" +
                        "#  5) Disminuir productos                        #\n" +
                        "#  6) Eliminar productos                         #\n" +
                        "#  7) Ver todos los productos                    #\n" +
                        "#  8) Modificar productos                        #\n" +
                        "#  9) Eliminar categorías                        #\n" +
                        "# 10) Ver por categorías                         #\n" +
                        "# 11) Regresar                                   #\n" +
                        "##################################################\n"
                    );
                    System.out.print("> ");
    
                    res = Input.input().nextInt();
                }
                else {}
    
                switch (res) {
                    // Crear estante
                    case 1:
                        inventario.getCategorias(true);
                        System.out.print("\nSeleccione la categoría: > ");
                        
                        int selCat = Input.input().nextInt();

                        if(selCat == inventario.getCantCategorias() + 1) {
                            flag = true;
                        }
                        else if(selCat < 1 || selCat > inventario.getCantCategorias() + 1) {
                            MisErrores.seleccionIncorrecta();
                            flag = false;
                        }
                        else {
                            if(inventario.setCrearEstante(selCat)) {
                                System.out.println("\n+++++++++++++++++++++++++++++++++++++");
                                System.out.println("\n      Estante creado con éxito.");
                                System.out.println("\n+++++++++++++++++++++++++++++++++++++");
                            }
                            else {
                                System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                                System.out.println("\n            Fallo en la creación, estante existente.");
                                System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                            }

                            System.out.println("¿Desea crear otro estante? S/N: ");
                            System.out.print("\n> ");
                            if(Input.input().next().toLowerCase().equals("s")) {
                                flag = false;
                            }
                            else {
                                flag = true;
                            }

                        }
                        
                        break;

                    case 2:
                        inventario.getCategorias(false);

                        System.out.println("Enter para continuar...");
                        Input.enterToContinue();
                        break;

                    case 3:
                        Input.input().nextLine();
                        System.out.println("\nIngrese el nombre de la nueva categoría: ");
                        System.out.print("> ");
                        String nombre = Input.input().nextLine();
                        if(inventario.setCategorias(nombre)) {
                            System.out.println("\nSe agregó " + nombre + " a las categorías disponibles.");
                        }
                        else {
                            System.out.println("\nYa existe la categoría " + nombre);
                        }

                        System.out.println("\n¿Desea ingresar otra categoría? S/N");
                        System.out.print("> ");
                        String s = Input.input().next().toLowerCase();
                        if(s.equals("s")) {
                            flag = false;
                        }
                        else {
                            flag = true;
                        }
                        break;
                    
                    case 7:
                        inventario.getMostrarEstante(false, true);
                        break;
                    
                    case 10:
                        inventario.getMostrarEstante(true, true);
                        break;
                
                    default:
                        MisErrores.seleccionIncorrecta();
                        break;
                }
            } catch (Exception e) {
                // TODO: handle exception
                MisErrores.soloNumeros();
            }

        } while (res != 11);
    }

}
