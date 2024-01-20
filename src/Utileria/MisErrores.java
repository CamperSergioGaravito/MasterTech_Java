package Utileria;

public class MisErrores extends Exception {
    
    public static void seleccionIncorrecta() {
        System.out.println("\nSelección incorrecta");
    }

    public static void soloNumeros() {
        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.err.println("X         Solo se permiten números         X");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
        Input.input().nextLine();
    }

}
