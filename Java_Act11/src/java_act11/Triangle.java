/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_act11;

/**
 *
 * @author julia
 */
public class Triangle implements Shape {

    @Override
    public float getArea(float base, float altura) {
        return (base * altura) / 2;
    }

    @Override
    public float getPerimeter(float lado) {
        return lado * 3;
    }

    @Override
    public float getArea(float no) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
