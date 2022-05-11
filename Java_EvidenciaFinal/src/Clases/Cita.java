/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author julia
 */
public class Cita {

    private Long id;
    private String fecha;
    private String motivo;
    private Doctor doctor;
    private Paciente paciente;

    public Cita(Long id, String fecha, String motivo, Doctor doctor, Paciente paciente) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    public Cita() {
    }

    public void imprimirCitas() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("citas.json"));
            TypeReference<List<Cita>> typeReference = new TypeReference<List<Cita>>() {
            };
            List<Cita> citas = mapper.readValue(inputStream, typeReference);
            for (Cita cita : citas) {
                System.out.println(cita.toString());
                System.out.println("");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void agendarCita(Cita cita) {
        try {
            Gson gson = new Gson();
            ObjectMapper mapper = new ObjectMapper();
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("citas.json"));
            JSONArray jsonArray = (JSONArray) obj;

            String json = gson.toJson(cita);
            Map<String, String> mapCita = mapper.readValue(json, Map.class);

            JSONObject citaJson = new JSONObject(mapCita);

            jsonArray.add(citaJson);

            FileWriter file = new FileWriter("citas.json");
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public String toString() {
        return "id: " + id + "\nfecha: " + fecha + "\nmotivo: " + motivo
                + "\n Doctor{" + "\n  Id: " + doctor.getId()
                + "\n  Nombre: " + doctor.getName() + "\n  Apellido: " + doctor.getApellido()
                + "\n  Edad: " + doctor.getAge()
                + "\n  especialidad: " + doctor.getEspecialidad() + "\n},"
                + "\n Paciente{" + "\n  Id: " + paciente.getId()
                + "\n  Nombre: " + paciente.getName() + "\n  Apellido: " + paciente.getApellido()
                + "\n  Edad: " + paciente.getAge() + "\n}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}
