package Clases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class Doctor extends Usuario {

    private String especialidad;

    public Doctor(Integer age, String name, String password, String apellido, String especialidad) {
        super(age, name, password, apellido);
        this.especialidad = especialidad;
    }

    public Doctor(Long id, Integer age, String name, String password, String apellido, String especialidad) {
        super(id, age, name, password, apellido);
        this.especialidad = especialidad;
    }

    public Doctor() {
    }

    //metodo para ver las citas del doctor
    public void verCitas(Doctor doctor) {
        boolean bandera = false;
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("citas.json"));
            TypeReference<List<Cita>> typeReference = new TypeReference<List<Cita>>() {
            };
            List<Cita> citas = mapper.readValue(inputStream, typeReference);
            for (Cita cita : citas) {
                if (cita.getDoctor().equals(doctor)) {
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
            InputStream inputStream = new FileInputStream(new File("doctores.json"));
            TypeReference<List<Doctor>> typeReference = new TypeReference<List<Doctor>>() {
            };
            List<Doctor> doctores = mapper.readValue(inputStream, typeReference);
            for (Doctor doctor : doctores) {
                if (doctor.getId().equals(this.id)) {
                    System.out.println(doctor.toString());
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
            InputStream inputStream = new FileInputStream(new File("doctores.json"));
            TypeReference<List<Doctor>> typeReference = new TypeReference<List<Doctor>>() {
            };
            List<Doctor> doctores = mapper.readValue(inputStream, typeReference);
            for (Doctor doctor : doctores) {
                if (doctor.getName().equals(nombre) && doctor.getPassword().equals(password)) {
                    return true;
                }
            }
            System.out.println("No se encontro un usuario indicado");
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Doctor{\n" + "Id: " + id + "\nNombre: " + name + "\nApellido: " + apellido + "\nEdad: " + age + "\nEspecialidad:" + especialidad + "\n}";
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Doctor other = (Doctor) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.especialidad, other.especialidad);
    }

}
