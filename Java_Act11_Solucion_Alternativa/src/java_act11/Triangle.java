/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_act11;

import java.util.Arrays;

/**
 *
 * @author julia
 */
public class Triangle implements Shape {
    
    double[] lados = new double[3];

    @Override
    public double getArea() {
        double semiperimetro = Arrays.stream(lados).sum()/2;
        return Math.sqrt(semiperimetro * (semiperimetro - lados[0]) * (semiperimetro - lados[1]) * (semiperimetro - lados[2]));
    }

    @Override
    public double getPerimeter() {
        return Arrays.stream(lados).sum();
    }    

    public double[] getLados() {
        return lados;
    }

    public void setLados(double[] lados) {
        this.lados = lados;
    }

   public void addLados(double lado, int posicion) {
        this.lados[posicion] = lado;
    }
    
    
}
