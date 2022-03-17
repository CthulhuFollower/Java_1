/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_act8aux;

/**
 *
 * @author julia
 */
public class Carta {
    
    private String palo;
    private String color;
    private String numero;
    
    public Carta(){
        
    }
    
    public Carta(String palo, String color, String numero) {
        this.palo = palo;
        this.color = color;
        this.numero = numero;
    }
    
    public String getCaracteristicas(){
        String caracteristicas = "{" + palo + "}, {" + color + "}, {" + numero + "}";
        return caracteristicas;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String nummero) {
        this.numero = nummero;
    }
}
