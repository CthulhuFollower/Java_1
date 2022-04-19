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

        String figura, parametro;

        //Perimetro y Tringulo
        do {

            System.out.println("""
                               Indique una figura
                               1.- Cuadrado
                               2.- Circulo
                               3.- Triangulo Equilatero
                               4.- Salir""");

            figura = entrada.nextLine();

            System.out.println("""
                               Indique el parametro que quiere obtener
                               1.- Area
                               2.- Perimetro""");

            parametro = entrada.nextLine();
            try {

                switch (figura) {
                    case "1" -> {
                        if (parametro.equals("1")) {

                            System.out.println("Indique un lado del cuadrado: ");
                            float lado = Integer.parseInt(entrada.nextLine());

                            System.out.println(cuadrado.getArea(lado));
                            break;

                        } else if (parametro.equals("2")) {
                            System.out.println("Indique un lado del cuadrado: ");
                            float lado = Integer.parseInt(entrada.nextLine());

                            System.out.println(cuadrado.getPerimeter(lado));
                            break;
                        }

                        System.out.println("Opcion invalida");
                    }
                    case "2" -> {
                        if (parametro.equals("1")) {
                            System.out.println("Indique el radio del circulo: ");
                            float radio = Integer.parseInt(entrada.nextLine());
                            
                            System.out.println(circulo.getArea(radio));

                            break;
                        } else if (parametro.equals("2")) {
                            System.out.println("Indique el radio del circulo: ");
                            float radio = Integer.parseInt(entrada.nextLine());
                            
                            System.out.println(circulo.getPerimeter(radio));
                            
                            break;
                        }
                        System.out.println("Opcion invalida");
                    }
                    case "3" -> {
                        if (parametro.equals("1")) {
                            
                            System.out.println("Indique la base del triangulo: ");
                            float base = Integer.parseInt(entrada.nextLine());
                            
                            System.out.println("Indique la altura del triangulo: ");
                            float altura = Integer.parseInt(entrada.nextLine());
                            
                            System.out.println(triangulo.getArea(base, altura));
                            
                            break;
                        } else if (parametro.equals("2")) {
                            System.out.println("Indique un lado del triangulo: ");
                            float lado = Integer.parseInt(entrada.nextLine());
                            
                            System.out.println(triangulo.getPerimeter(lado));
                            
                            break;
                        }
                        System.out.println("Opcion invalida");
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
