/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_act8aux;

import java_act8aux.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author julia
 */
public class Deck {

    private ArrayList<Carta> Baraja = new ArrayList<>();
    private String[] palos = new String[]{"tréboles", "corazones", "picas", "diamantes"};
    private String[] colores = new String[]{"rojo", "negro"};
    private String[] numeros = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public void crearBaraja() {
        if (!Baraja.isEmpty()) {
            limpiarBaraja();
        }
        for (String palo : palos) {
            for (String numero : numeros) {
                if (("tréboles".equals(palo)) || ("picas".equals(palo))) {
                    Baraja.add(new Carta(palo, colores[1], numero));
                } else {
                    Baraja.add(new Carta(palo, colores[0], numero));
                }
            }
        }
        System.out.println("Se creo una baraja nueva");
    }

    public void shuffle() {
        if (!Baraja.isEmpty()) {
            Random r = new Random();
            for (int i = 0; i < Baraja.size(); i++) {
                Collections.swap(Baraja, i, r.nextInt(0, i + 1));
            }
            System.out.println("Se mezclo el deck");
        } else {
            System.out.println("Cree una baraja primero");
        }
    }

    public void head() {
        if (!Baraja.isEmpty()) {
            System.out.println(Baraja.get(0).getCaracteristicas());
            Baraja.remove(0);
            System.out.println("Quedan " + Baraja.size() + " cartas");
        } else {
            System.out.println("Cree una baraja primero");
        }
    }

    public void pick() {
        if (!Baraja.isEmpty()) {
            Random r = new Random();
            int carta = r.nextInt(0, Baraja.size());
            System.out.println(Baraja.get(carta).getCaracteristicas());
            Baraja.remove(carta);
            System.out.println("Quedan " + Baraja.size() + " cartas");
        } else {
            System.out.println("Cree una baraja primero");
        }
    }

    public void hand() {
        if (!Baraja.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Baraja.get(0).getCaracteristicas());
                Baraja.remove(0);
            }
            System.out.println("Quedan " + Baraja.size() + " cartas");
        } else {
            System.out.println("Cree una baraja primero");
        }
    }

    public void limpiarBaraja() {
        Baraja.clear();
    }

    public void imprimirDeck() {
        for (Carta aux : Baraja) {
            System.out.println(aux.getCaracteristicas());
        }
    }

    public ArrayList<Carta> getBaraja() {
        return Baraja;
    }

    public void setBaraja(ArrayList<Carta> Baraja) {
        this.Baraja = Baraja;
    }

}
