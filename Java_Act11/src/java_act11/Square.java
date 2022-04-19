/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_act11;

/**
 *
 * @author julia
 */
public class Square implements Shape{

    @Override
    public float getArea(float lado) {
        return lado * lado;
    }

    @Override
    public float getPerimeter(float lado) {
        return lado * 4;
    }

    @Override
    public float getArea(float nada, float no) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
