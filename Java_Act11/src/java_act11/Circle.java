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

    @Override
    public float getPerimeter(float radio) {
        return (float) (2 * Math.PI * radio);
    }

    @Override
    public float getArea(float radio) {
        return (float) ((Math.PI) * Math.pow(radio, 2));
    }

    @Override
    public float getArea(float nada, float no) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
