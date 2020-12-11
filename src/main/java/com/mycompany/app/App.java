package com.mycompany.app;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App
{

    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        
        while(true) {

            System.out.println("Calculadora - v1.1");
            System.out.println("");
            System.out.println("0. Sair");
            System.out.println("1. Adicao");
            System.out.println("");

            int operation = -1;
            do {
                System.out.print("Escolha (0-1): ");
                try {
                    operation = sc.nextInt();
                } catch (Exception e) {
                    sc.next();
                } 
            }while(operation < 0 || operation > 1);
            
            if (operation == 0) {
                break;
            }
            
            System.out.println("");

            float num = requestFloat(sc, "Primeiro operando: ");
            float num1 = requestFloat(sc, "Segundo operando: ");

            float result = 0f;

            switch(operation) {
                case 1:
                    result = num + num1;
                    break;
            }
            
            System.out.println("");
            System.out.println(String.format("Resultado: %s", result));
            System.out.println("");

        }

        sc.close();
    }

    public static float add(float a, float b) {
        return a + b;
    }

    private static float requestFloat(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextFloat();
            } catch (Exception e) {
                sc.next();
                continue;
            }
        }
    }

}
