/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_josealvarez;

import java.util.ArrayList;
import java.util.Random;


    public class Gusanito {
    public ArrayList<String> instrucciones;
    public char[][] tablero;
    public int xGusano, yGusano, xManzana, yManzana;

        public Gusanito(int filas, int columnas) {
        if (filas < 4 || filas > 10 || columnas < 4 || columnas > 10) {
            System.out.println("Las dimensiones del tablero deben estar entre 4 y 10.");
        }

        instrucciones = new ArrayList<>();
        tablero = new char[filas][columnas];

        Random rand = new Random();
        xGusano = rand.nextInt(filas);
        yGusano = rand.nextInt(columnas);
        xManzana = rand.nextInt(filas);
        yManzana = rand.nextInt(columnas);

        while (xManzana == xGusano && yManzana == yGusano) {
            xManzana = rand.nextInt(filas);
            yManzana = rand.nextInt(columnas);
        }

        int numObstaculos = rand.nextInt(filas * columnas / 4) + 1; // Ajustar la cantidad de obstáculos
        for (int i = 0; i < numObstaculos; i++) {
            int obstaculoX = rand.nextInt(filas);
            int obstaculoY = rand.nextInt(columnas);

            while ((obstaculoX == xGusano && obstaculoY == yGusano) ||
                    (obstaculoX == xManzana && obstaculoY == yManzana)) {
                obstaculoX = rand.nextInt(filas);
                obstaculoY = rand.nextInt(columnas);
            }

            tablero[obstaculoX][obstaculoY] = '#'; 
        }
    }

    public void agregarInstruccion(String instruccion) {
    instrucciones.add(instruccion);
    }

    public void ejecutarInstrucciones() {
       for (int i = 0; i < instrucciones.size(); i++) {
            String instruccion = instrucciones.get(i);
    
        char direccion = instruccion.charAt(instruccion.length() - 1);
    
        int magnitud = Integer.parseInt(instruccion.substring(0, instruccion.length() - 1));

        if (direccion == 'U') {
            xGusano -= magnitud;
        } else if (direccion == 'D') {
         xGusano += magnitud;
        } else if (direccion == 'R') {
            yGusano += magnitud;
        } else if (direccion == 'L') {
         yGusano -= magnitud;
        }
    
    // Validar límites del tablero
        if (xGusano < 0) {
            xGusano = 0;
        } else if (xGusano >= tablero.length) {
            xGusano = tablero.length - 1;
        }

        if (yGusano < 0) {
            yGusano = 0;
        } else if (yGusano >= tablero[0].length) {
            yGusano = tablero[0].length - 1;
        }
       }

    }

    public void mostrarTablero() {
    for (int i = 0; i < tablero.length; i++) {
        for (int j = 0; j < tablero[i].length; j++) {
            if (i == xGusano && j == yGusano) {
                System.out.print("[G]"); // '[G]' para el gusanito
            } else if (i == xManzana && j == yManzana) {
                System.out.print("[Ó]"); // '[Ó]' para la manzana
            } else if (tablero[i][j] == '#') {
                System.out.print("[#]"); // '[#]' para obstáculos
            } else {
                System.out.print("[ ]"); // '[ ]' para celdas vacías
            }
        }
        System.out.println();
    }
}

}