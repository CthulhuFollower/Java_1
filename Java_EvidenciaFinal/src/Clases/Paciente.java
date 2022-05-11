/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class Paciente extends Usuario {

    public Paciente(Long id, Integer age, String name, String password, String apellido) {
        super(id, age, name, password, apellido);
    }

    public Paciente(Integer age, String name, String password, String apellido) {
        super(age, name, password, apellido);
    }

    public Paciente() {
    }

    public void verCitas(Paciente paciente) {
        boolean bandera = false;
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("citas.json"));
            TypeReference<List<Cita>> typeReference = new TypeReference<List<Cita>>() {
            };
            List<Cita> citas = mapper.readValue(inputStream, typeReference);
            for (Cita cita : citas) {
                if (cita.getPaciente().equals(paciente)) {
                    System.out.println(cita.toString());
                    System.out.println("");
                    bandera = true;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        if (!bandera) {
            System.out.println("No hay citas");
        }
    }

    @Override
    public void imprimirDatos() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("pacientes.json"));
            TypeReference<List<Paciente>> typeReference = new TypeReference<List<Paciente>>() {
            };
            List<Paciente> pacientes = mapper.readValue(inputStream, typeReference);
            for (Paciente paciente : pacientes) {
                if (paciente.getId().equals(this.id)) {
                    System.out.println(paciente.toString());
                    return;
                }
            }
            System.out.println("No se encontro un usuario indicado");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public boolean validar(String nombre, String password) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("pacientes.json"));
            TypeReference<List<Paciente>> typeReference = new TypeReference<List<Paciente>>() {
            };
            List<Paciente> pacientes = mapper.readValue(inputStream, typeReference);
            for (Paciente paciente : pacientes) {
                if (paciente.getName().equals(nombre) && paciente.getPassword().equals(password)) {
                    return true;
                }
            }
            System.out.println("No se encontro un usuario indicado");
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

}
