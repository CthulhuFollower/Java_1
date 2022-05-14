/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Objects;

/**
 *
 * @author julia
 */
public abstract class Usuario {

    protected Long id;
    protected Integer age;
    protected String name;
    protected String password;
protected String apellido;

    public Usuario(Long id, Integer age, String name, String password, String apellido) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.apellido = apellido;
        this.age = age;
    }

    public Usuario(Integer age, String name, String password, String apellido) {
        this.name = name;
        this.password = password;
        this.apellido = apellido;
        this.age = age;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{\n" + "Id: " + id + "\nNombre: " + name + "\nApellido: " + apellido + "\nEdad: " + age + "\n}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.age, other.age);
    }

    public void imprimirDatos() {

    }

    public void registrarUsuario() {

    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
