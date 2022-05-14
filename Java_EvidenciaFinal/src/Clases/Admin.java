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
public class Admin extends Usuario {

    public Admin() {
    }

    public Admin(Long id, Integer age, String name, String password, String apellido) {
        super(id, age, name, password, apellido);
    }
    
    @Override
    public void imprimirDatos() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("admins.json"));
            TypeReference<List<Admin>> typeReference = new TypeReference<List<Admin>>() {
            };
            List<Admin> admins = mapper.readValue(inputStream, typeReference);
            for (Admin admin : admins) {
                if (admin.getId().equals(this.id)) {
                    System.out.println(admin.toString());
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
            InputStream inputStream = new FileInputStream(new File("admins.json"));
            TypeReference<List<Admin>> typeReference = new TypeReference<List<Admin>>() {
            };
            List<Admin> admins = mapper.readValue(inputStream, typeReference);
            for (Admin admin : admins) {
                if (admin.getName().equals(nombre) && admin.getPassword().equals(password)) {
                    return true;
                }
            }
            System.out.println("No se encontro un usuario indicado");
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public boolean registrarAdmin(Admin admin) {
        try {
            Gson gson = new Gson();
            ObjectMapper mapper = new ObjectMapper();
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("admins.json"));
            JSONArray jsonArray = (JSONArray) obj;

            String json = gson.toJson(admin);
            Map<String, String> mapCita = mapper.readValue(json, Map.class);

            JSONObject adminJson = new JSONObject(mapCita);

            jsonArray.add(adminJson);

            FileWriter file = new FileWriter("admins.json");
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public boolean registrarDoctor(Doctor doctor) {
        try {
            Gson gson = new Gson();
            ObjectMapper mapper = new ObjectMapper();
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("doctores.json"));
            JSONArray jsonArray = (JSONArray) obj;

            String json = gson.toJson(doctor);
            Map<String, String> mapCita = mapper.readValue(json, Map.class);

            JSONObject doctorJson = new JSONObject(mapCita);

            jsonArray.add(doctorJson);

            FileWriter file = new FileWriter("doctores.json");
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public boolean registrarPaciente(Paciente paciente) {
        try {
            Gson gson = new Gson();
            ObjectMapper mapper = new ObjectMapper();
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("pacientes.json"));
            JSONArray jsonArray = (JSONArray) obj;

            String json = gson.toJson(paciente);
            Map<String, String> mapCita = mapper.readValue(json, Map.class);

            JSONObject pacienteJson = new JSONObject(mapCita);

            jsonArray.add(pacienteJson);

            FileWriter file = new FileWriter("pacientes.json");
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public void eliminarAdmin(Long id) {
        try {
            Integer index = 0;
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("admins.json"));
            JSONArray jsonArray = (JSONArray) obj;

            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("admins.json"));
            TypeReference<List<Admin>> typeReference = new TypeReference<List<Admin>>() {
            };
            List<Admin> admins = mapper.readValue(inputStream, typeReference);

            for (Admin admin : admins) {
                if (admin.getId().equals(id)) {
                    jsonArray.remove(Integer.parseInt(String.valueOf(index)));
                    break;
                }
                index++;
            }

            FileWriter file = new FileWriter("admins.json");
            System.out.println(jsonArray.toJSONString());
            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void imprimirTodosAdmins() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("admins.json"));
            TypeReference<List<Admin>> typeReference = new TypeReference<List<Admin>>() {
            };
            List<Admin> admins = mapper.readValue(inputStream, typeReference);
            for (Admin admmin : admins) {
                System.out.println(admmin.toString());
                System.out.println("");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void eliminarPaciente(String nombre, String apellido) {
        try {
            Integer index = 0;
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("pacientes.json"));
            JSONArray jsonArray = (JSONArray) obj;

            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("pacientes.json"));
            TypeReference<List<Paciente>> typeReference = new TypeReference<List<Paciente>>() {
            };
            List<Paciente> pacientes = mapper.readValue(inputStream, typeReference);

            for (Paciente paciente : pacientes) {
                if (paciente.getName().equals(nombre) && paciente.getApellido().equals(apellido)) {
                    jsonArray.remove(Integer.parseInt(String.valueOf(index)));
                    break;
                }
                index++;
            }

            FileWriter file = new FileWriter("pacientes.json");
            System.out.println(jsonArray.toJSONString());
            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void eliminarPaciente(Long id) {
        try {
            Integer index = 0;
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("pacientes.json"));
            JSONArray jsonArray = (JSONArray) obj;

            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("pacientes.json"));
            TypeReference<List<Paciente>> typeReference = new TypeReference<List<Paciente>>() {
            };
            List<Paciente> pacientes = mapper.readValue(inputStream, typeReference);

            for (Paciente pacienteAux : pacientes) {
                if (pacienteAux.getId().equals(id)) {
                    jsonArray.remove(Integer.parseInt(String.valueOf(index)));
                    break;
                }
                index++;
            }

            FileWriter file = new FileWriter("pacientes.json");
            System.out.println(jsonArray.toJSONString());
            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void eliminarDoctor(String nombre, String apellido) {
        try {
            Integer index = 0;
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("doctores.json"));
            JSONArray jsonArray = (JSONArray) obj;

            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("doctores.json"));
            TypeReference<List<Doctor>> typeReference = new TypeReference<List<Doctor>>() {
            };
            List<Doctor> doctores = mapper.readValue(inputStream, typeReference);

            for (Doctor doctor : doctores) {
                if (doctor.getName().equals(nombre) && doctor.getApellido().equals(apellido)) {
                    jsonArray.remove(Integer.parseInt(String.valueOf(index)));
                    break;
                }
                index++;
            }

            FileWriter file = new FileWriter("doctores.json");
            System.out.println(jsonArray.toJSONString());
            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void eliminarDoctor(Long id) {
        try {
            Integer index = 0;
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("doctores.json"));
            JSONArray jsonArray = (JSONArray) obj;

            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("doctores.json"));
            TypeReference<List<Doctor>> typeReference = new TypeReference<List<Doctor>>() {
            };
            List<Doctor> doctores = mapper.readValue(inputStream, typeReference);

            for (Doctor doctor : doctores) {
                if (doctor.getId().equals(id)) {
                    jsonArray.remove(Integer.parseInt(String.valueOf(index)));
                    break;
                }
                index++;
            }

            FileWriter file = new FileWriter("doctores.json");
            System.out.println(jsonArray.toJSONString());
            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void eliminarCita(Long id) {
        try {
            Integer index = 0;
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("citas.json"));
            JSONArray jsonArray = (JSONArray) obj;

            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("citas.json"));
            TypeReference<List<Cita>> typeReference = new TypeReference<List<Cita>>() {
            };
            List<Cita> citas = mapper.readValue(inputStream, typeReference);

            for (Cita cita : citas) {
                if (cita.getId().equals(id)) {
                    jsonArray.remove(Integer.parseInt(String.valueOf(index)));
                    break;
                }
                index++;
            }

            FileWriter file = new FileWriter("citas.json");
            System.out.println(jsonArray.toJSONString());
            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void imprimirTodosDoctores() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("doctores.json"));
            TypeReference<List<Doctor>> typeReference = new TypeReference<List<Doctor>>() {
            };
            List<Doctor> doctores = mapper.readValue(inputStream, typeReference);
            for (Doctor doctor : doctores) {
                System.out.println(doctor.toString());
                System.out.println("");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public boolean buscarPorNombreCompletoDoctor(String nombre, String apellido) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("doctores.json"));
            TypeReference<List<Doctor>> typeReference = new TypeReference<List<Doctor>>() {
            };
            List<Doctor> doctores = mapper.readValue(inputStream, typeReference);
            for (Doctor doctor : doctores) {
                if (doctor.getName().equals(nombre) && doctor.getApellido().equals(apellido)) {
                    System.out.println(doctor.toString());
                    return true;
                }
            }
            System.out.println("No se encontro un usuario indicado");
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public Doctor buscarPorIdDoctor(Long id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("doctores.json"));
            TypeReference<List<Doctor>> typeReference = new TypeReference<List<Doctor>>() {
            };
            List<Doctor> doctores = mapper.readValue(inputStream, typeReference);
            for (Doctor doctor : doctores) {
                if (doctor.getId().equals(id)) {
                    System.out.println(doctor.toString());
                    return doctor;
                }
            }
            System.out.println("No se encontro un usuario indicado");
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public void imprimirTodosPaciente() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("pacientes.json"));
            TypeReference<List<Paciente>> typeReference = new TypeReference<List<Paciente>>() {
            };
            List<Paciente> pacientes = mapper.readValue(inputStream, typeReference);
            for (Paciente paciente : pacientes) {
                System.out.println(paciente.toString());
                System.out.println("");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public Paciente buscarPorIdPaciente(Long id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("pacientes.json"));
            TypeReference<List<Paciente>> typeReference = new TypeReference<List<Paciente>>() {
            };
            List<Paciente> pacientes = mapper.readValue(inputStream, typeReference);
            for (Paciente paciente : pacientes) {
                if (paciente.getId().equals(id)) {
                    System.out.println(paciente.toString());
                    return paciente;
                }
            }
            System.out.println("No se encontro un usuario indicado");
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public boolean buscarPorNombreCompleto(String nombre, String apellido) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("pacientes.json"));
            TypeReference<List<Paciente>> typeReference = new TypeReference<List<Paciente>>() {
            };
            List<Paciente> pacientes = mapper.readValue(inputStream, typeReference);
            for (Paciente paciente : pacientes) {
                if (paciente.getName().equals(nombre) && paciente.getApellido().equals(apellido)) {
                    System.out.println(paciente.toString());
                    return true;
                }
            }
            System.out.println("No se encontro un usuario indicado");
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public Paciente getPaciente(String nombre, String password) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("pacientes.json"));
            TypeReference<List<Paciente>> typeReference = new TypeReference<List<Paciente>>() {
            };
            List<Paciente> pacientes = mapper.readValue(inputStream, typeReference);
            for (Paciente paciente : pacientes) {
                if (paciente.getName().equals(nombre) && paciente.getPassword().equals(password)) {
                    return new Paciente(paciente.getId(), paciente.age, paciente.getName(), paciente.getPassword(), paciente.getApellido());
                }
            }
            System.out.println("No se encontro un usuario indicado");
        } catch (Exception e) {
            System.err.println(e);
        }
        return new Paciente();
    }

    public Doctor getDoctor(String nombre, String password) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("doctores.json"));
            TypeReference<List<Doctor>> typeReference = new TypeReference<List<Doctor>>() {
            };
            List<Doctor> doctores = mapper.readValue(inputStream, typeReference);
            for (Doctor doctor : doctores) {
                if (doctor.getName().equals(nombre) && doctor.getPassword().equals(password)) {
                    return new Doctor(doctor.getId(), doctor.age, doctor.getName(), doctor.getPassword(), doctor.getApellido(), doctor.getEspecialidad());
                }
            }
            System.out.println("No se encontro un usuario indicado");
        } catch (Exception e) {
            System.err.println(e);
        }
        return new Doctor();
    }
    
    public Admin getAdmin(String nombre, String password) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("admins.json"));
            TypeReference<List<Admin>> typeReference = new TypeReference<List<Admin>>() {
            };
            List<Admin> admins = mapper.readValue(inputStream, typeReference);
            for (Admin admin : admins) {
                if (admin.getName().equals(nombre) && admin.getPassword().equals(password)) {
                    return new Admin(admin.getId(), admin.age, admin.getName(), admin.getPassword(), admin.getApellido());
                }
            }
            System.out.println("No se encontro un usuario indicado");
        } catch (Exception e) {
            System.err.println(e);
        }
        return new Admin();
    }
}
