/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_act11;

/**
 *
 * @author julia
 */
public class Square implements Shape {

    double lado;

    @Override
    public double getArea() {
        return lado * lado;
    }

    @Override
    public double getPerimeter() {
        return lado * 4;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
