/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab9p1_josealvarez;

import java.util.Scanner;
   public class Lab9P1_JoseAlvarez {

    
    public static void main(String[] args) {
        
               Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el alto del tablero (entre 4 y 10): ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el ancho del tablero (entre 4 y 10): ");
        int columnas = scanner.nextInt();

        Gusanito gusanito = new Gusanito(filas, columnas);

        System.out.println("Tablero inicial:");
        gusanito.mostrarTablero();

        System.out.println("Ingrese las instrucciones (formato magnitud-dirección), o escriba 'fin' para terminar:");
        String instruccion = scanner.next();

        while (!instruccion.equalsIgnoreCase("fin")) {
            gusanito.agregarInstruccion(instruccion);
            instruccion = scanner.next();
        }

        gusanito.ejecutarInstrucciones();

        System.out.println("Estado final del tablero:");
        gusanito.mostrarTablero();
    }
    }
    

    

