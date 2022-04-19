/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java_act11;

import java.util.Scanner;

/**
 *
 * @author julia
 */
public class main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Circle circulo = new Circle();
        Square cuadrado = new Square();
        Triangle triangulo = new Triangle();

        String figura;

        //Perimetro y Tringulo
        do {

            System.out.println("""
                               Indique una figura
                               1.- Cuadrado
                               2.- Circulo
                               3.- Triangulo
                               4.- Salir""");

            figura = entrada.nextLine();
            try {
                switch (figura) {
                    case "1" -> {
                        System.out.println("Indique un lado del cuadrado: ");
                        cuadrado.setLado(Double.parseDouble(entrada.nextLine()));

                        System.out.println("Este es el area del cuadrado: " + cuadrado.getArea());
                        System.out.println("Este es el perimetro del cuadrado: " + cuadrado.getPerimeter());
                    }
                    case "2" -> {
                        System.out.println("Indique el radio del circulo: ");
                        circulo.setRadio(Double.parseDouble(entrada.nextLine()));
                        
                        System.out.println("Este es el perimetro del Circulo: " + circulo.getPerimeter());
                        System.out.println("Este es el area del Circulo: " + circulo.getArea());
                    }
                    case "3" -> {
                        for (int i = 0; i < 3; i++) {
                            System.out.println("Indique el lado " + (i + 1) + " del Triangulo: ");
                            double lado = Double.parseDouble(entrada.nextLine());
                            triangulo.addLados(lado, i);
                        }

                        System.out.println("Este es el perimetro del Triangulo: " + triangulo.getPerimeter());
                        System.out.println("Este es el area del Triangulo: " + triangulo.getArea());

                    }
                    case "4" ->
                        System.out.println("Fin del programa");
                    default ->
                        System.out.println("Opcion invalida");
                }

            } catch (NumberFormatException e) {
                System.out.println("Indique valores numericos\n");

            }

        } while (!figura.equals("4"));
    }

}