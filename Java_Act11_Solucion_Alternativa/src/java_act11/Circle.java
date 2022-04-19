/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_act11;

/**
 *
 * @author julia
 */
public class Circle implements Shape {
    
    double radio;
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radio;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}
