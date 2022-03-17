/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java_act8aux;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author julia
 */
public class main {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        Deck d = new Deck();
        showMenu(d);
    }

    static void showMenu(Deck d) {
        int seleccion;
        do {
            System.out.println("Indique una opcion: \n"
                    + "1.- Crear una nuevo deck \n"
                    + "2.- Barajear el deck \n"
                    + "3.- Tomar una carta de hasta arriba \n"
                    + "4.- Tomar una carta aleatoria \n"
                    + "5.- Tomar una mano (5 cartas) \n"
                    + "6.- Terminar programa");
            seleccion = entrada.nextInt();
            switch (seleccion) {
                case 1:
                    d.crearBaraja();
                    System.out.println("");
                    break;
                case 2:
                    d.shuffle();
                    System.out.println("");
                    break;
                case 3:
                    d.head();
                    System.out.println("");
                    break;
                case 4:
                    d.pick();
                    System.out.println("");
                    break;
                case 5:
                    d.hand();
                    System.out.println("");
                    break;
                case 6:
                    System.out.println("Gracias por usar el codigo");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    System.out.println("");
                    break;
            }
        } while (seleccion != 6);
    }
}
