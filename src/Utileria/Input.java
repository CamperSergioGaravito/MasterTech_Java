package Utileria;

import java.util.Scanner;

public class Input {
    
    private static Scanner inputs = new Scanner(System.in);

    public static Scanner input() {
        return inputs;
    }
    
    public static void enterToContinue() {
        input().nextLine();
        input().nextLine();
    }
}
