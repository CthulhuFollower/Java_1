package java_evidenciafinal;

import Clases.Admin;
import Clases.Cita;
import Clases.Doctor;
import Clases.Paciente;
import java.io.FileReader;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Java_EvidenciaFinal {

    public static Scanner entrada = new Scanner(System.in);
    public static String adminsJson = "admins.json";
    public static String citasJson = "citas.json";
    public static String doctoresJson = "doctores.json";
    public static String pacientesJson = "pacientes.json";

    public static Admin sistema = new Admin();
    public static Doctor usuarioDoctor = new Doctor();
    public static Paciente usuarioPaciente = new Paciente();
    public static Admin usuarioAdmin = new Admin();
    public static Cita citas = new Cita();
    public static String tipoUsuario = "";

    public static void main(String[] args) {
        String control = "Inicio";
        do {
            control = inicio();
            System.out.println(tipoUsuario);
            switch (tipoUsuario) {
                case "Paciente":
                    menuPaciente();
                    break;
                case "Doctor":
                    menuDoctor();
                    break;
                case "Admin":
                    menuAdmin();
                    break;
                default:
                    System.out.println("");
                    break;
            }
        } while (!control.equals("Salir"));
        System.out.println("Hasta luego!");
    }

    public static void menuPaciente() {
        String eleccion = "";
        do {
            System.out.println("""
                           Inidque una opcion:
                               1.- Ver datos personales
                               2.- Ver mis citas
                               3.- Agendar cita
                               4.- Cerrar Sesion
                           """);
            eleccion = entrada.nextLine();

            switch (eleccion) {
                case "1":
                    usuarioPaciente.imprimirDatos();
                    break;
                case "2":
                    usuarioPaciente.verCitas(usuarioPaciente);
                    break;
                case "3":
                    if (agendarCita(usuarioPaciente)) {
                        System.out.println("Se agendo una cita exitosamente");
                    } else {
                        System.out.println("Error vuelva a intentarlo");
                    }
                    break;
                case "4":
                    usuarioPaciente = new Paciente();
                    tipoUsuario = "";
                    break;
                default:
                    break;
            }
        } while (!eleccion.equals("4"));
    }

    public static void menuDoctor() {
        String eleccion = "";
        do {
            System.out.println("""
                           Inidque una opcion:
                               1.- Ver datos personales
                               2.- Ver mis citas
                               3.- Agendar cita
                               4.- Cerrar Sesion
                           """);
            eleccion = entrada.nextLine();

            switch (eleccion) {
                case "1":
                    usuarioDoctor.imprimirDatos();
                    break;
                case "2":
                    usuarioDoctor.verCitas(usuarioDoctor);
                    break;
                case "3":
                    if (agendarCita(usuarioDoctor)) {
                        System.out.println("Se agendo una cita exitosamente");
                    } else {
                        System.out.println("Error vuelva a intentarlo");
                    }
                    break;
                case "4":
                    usuarioDoctor = new Doctor();
                    tipoUsuario = "";
                    break;
                default:
                    break;
            }
        } while (!eleccion.equals("4"));
    }

    public static void menuAdmin() {
        String eleccion = "";
        do {
            System.out.println("""
                           Inidque una opcion:
                               1.- Ver datos personales
                               2.- Eliminar cita
                               3.- Eliminar Paciente
                               4.- Eliminar Doctor
                               5.- Eliminar Admin
                               6.- Cerrar sesion
                           """);
            eleccion = entrada.nextLine();

            switch (eleccion) {
                case "1":
                    usuarioAdmin.imprimirDatos();
                    break;
                case "2":
                    if (eliminarCita()) {
                        System.out.println("Se elimino exitosamente");
                    } else {
                        System.out.println("No se encontro la cita indicada");
                    }
                    break;
                case "3":
                    if (eliminarPaciente()) {
                        System.out.println("Se elimino exitosamente");
                    } else {
                        System.out.println("Error vuelva a intentarlo");
                    }
                    break;
                case "4":
                    if (eliminarDoctor()) {
                        System.out.println("Se elimino exitosamente");
                    } else {
                        System.out.println("Error vuelva a intentarlo");
                    }
                    break;
                case "5":
                    if (eliminarAdmin()) {
                        System.out.println("Se elimino exitosamente");
                    } else {
                        System.out.println("Error vuelva a intentarlo");
                    }
                    break;
                case "6":
                    usuarioAdmin = new Admin();
                    tipoUsuario = "";
                    break;
                default:
                    break;
            }
        } while (!eleccion.equals("6"));
    }

    public static String inicio() {
        String eleccion = "";
        do {
            System.out.println("""
                           Inidque una opcion:
                           1.- Iniciar sesion
                           2.- Registrar Cuenta
                           3.- Salir de la aplicacion
                           """);
            eleccion = entrada.nextLine();
            switch (eleccion) {
                case "1":
                    if (login()) {
                        System.out.println("Login exitoso");
                        return "Login";
                    }
                    break;
                case "2":
                    if (registro()) {
                        System.out.println("Registro Existoso");
                    }
                    break;
                case "3":
                    return "Salir";
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (true);
    }

    public static boolean login() {
        String tipoUsuario = "";
        String nombre = "";
        String password = "";

        do {
            System.out.println("""
                           Indique el tipo de usuario:
                           1.- Paciente
                           2.- Doctor
                           3.- Admin
                           4.- Volver
                           """);
            tipoUsuario = entrada.nextLine();
            if (tipoUsuario.equals("4")) {
                System.out.println("Volviendo...");
                return false;
            } else {
                System.out.println("Indique su nombre");
                nombre = entrada.nextLine();
                System.out.println("Indique su contraseña");
                password = entrada.nextLine();

                switch (tipoUsuario) {
                    case "1":
                        if (new Paciente().validar(nombre, password)) {
                            usuarioPaciente = sistema.getPaciente(nombre, password);
                            Java_EvidenciaFinal.tipoUsuario = "Paciente";
                            return true;

                        }
                        break;
                    case "2":
                        if (new Doctor().validar(nombre, password)) {
                            usuarioDoctor = sistema.getDoctor(nombre, password);
                            Java_EvidenciaFinal.tipoUsuario = "Doctor";
                            return true;
                        }
                        break;
                    case "3":
                        if (new Admin().validar(nombre, password)) {
                            usuarioAdmin = sistema.getAdmin(nombre, password);
                            Java_EvidenciaFinal.tipoUsuario = "Admin";
                            return true;
                        }
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }
            }
        } while (true);
    }

    public static boolean registro() {
        String tipoUsuario;

        do {
            System.out.println("""
                           Indique el tipo de usuario:
                           1.- Paciente
                           2.- Doctor
                           3.- Admin
                           4.- Volver
                           """);
            tipoUsuario = entrada.nextLine();

            if (tipoUsuario.equals("4")) {
                System.out.println("Volviendo...");
                return false;
            } else {
                switch (tipoUsuario) {
                    case "1":
                        if (registroPaciente()) {
                            return true;
                        }
                        break;
                    case "2":
                        if (registroDoctor()) {
                            return true;
                        }
                        break;
                    case "3":
                        if (registroAdmin()) {
                            return true;
                        }
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }
            }
        } while (true);
    }

    public static boolean registroAdmin() {
        String nombre = "";
        String apellido = "";
        String edad = "";
        String password = "";
        String passwordAux = " ";

        System.out.println("Indique un nombre");
        nombre = entrada.nextLine();

        System.out.println("Indique un apellido");
        apellido = entrada.nextLine();

        System.out.println("Indique su edad");
        edad = entrada.nextLine();

        do {
            System.out.println("Indique su contraseña");
            password = entrada.nextLine();

            System.out.println("Repita su contraseña");
            passwordAux = entrada.nextLine();
        } while (!password.equals(passwordAux));
        try {
            sistema.registrarAdmin(new Admin(generarId(adminsJson), Integer.parseInt(edad), nombre, password, apellido));
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo realizar el registro");
            return false;
        }
    }

    public static boolean registroPaciente() {
        String nombre = "";
        String apellido = "";
        String edad = "";
        String password = "";
        String passwordAux = " ";

        System.out.println("Indique un nombre");
        nombre = entrada.nextLine();

        System.out.println("Indique un apellido");
        apellido = entrada.nextLine();

        System.out.println("Indique su edad");
        edad = entrada.nextLine();

        do {
            System.out.println("Indique su contraseña");
            password = entrada.nextLine();

            System.out.println("Repita su contraseña");
            passwordAux = entrada.nextLine();
        } while (!password.equals(passwordAux));
        try {
            sistema.registrarPaciente(new Paciente(generarId(pacientesJson), Integer.parseInt(edad), nombre, password, apellido));
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo realizar el registro");
            return false;
        }
    }

    public static boolean registroDoctor() {
        String nombre = "";
        String apellido = "";
        String edad = "";
        String password = "";
        String passwordAux = " ";
        String especialidad = "";

        System.out.println("Indique un nombre");
        nombre = entrada.nextLine();

        System.out.println("Indique un apellido");
        apellido = entrada.nextLine();

        System.out.println("Indique su edad");
        edad = entrada.nextLine();

        System.out.println("Indique su especialidad");
        especialidad = entrada.nextLine();

        do {
            System.out.println("Indique su contraseña");
            password = entrada.nextLine();

            System.out.println("Repita su contraseña");
            passwordAux = entrada.nextLine();
        } while (!password.equals(passwordAux));
        try {
            sistema.registrarDoctor(new Doctor(generarId(doctoresJson), Integer.parseInt(edad), nombre, password, apellido, especialidad));
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo realizar el registro");
            return false;
        }
    }

    public static boolean agendarCita(Paciente paciente) {
        Long id;
        String fecha;
        String motivo;
        Doctor citaDoctor = null;
        do {
            try {
                sistema.imprimirTodosDoctores();
                System.out.println("Indique el Id del doctor con quien quiere agendar");
                id = Long.parseLong(entrada.nextLine());
                citaDoctor = sistema.buscarPorIdDoctor(id);
            } catch (Exception e) {
                System.out.println("Indique un id que este listado");
            }
        } while (citaDoctor == null);

        System.out.println("Indique un fecha con el siguiente formato (dia/mes/año todo con numeros)");
        fecha = entrada.nextLine();

        System.out.println("Indique su motivo");
        motivo = entrada.nextLine();

        try {
            new Cita().agendarCita(new Cita(generarId(citasJson), fecha, motivo, citaDoctor, paciente));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean agendarCita(Doctor doctor) {
        Long id;
        String fecha;
        String motivo;
        Paciente citaPaciente = null;
        do {
            try {
                sistema.imprimirTodosPaciente();
                System.out.println("Indique el Id del paciente con quien quiere agendar");
                id = Long.parseLong(entrada.nextLine());
                citaPaciente = sistema.buscarPorIdPaciente(id);
            } catch (Exception e) {
                System.out.println("Indique un id que este listado");
            }
        } while (citaPaciente == null);

        System.out.println("Indique un fecha con el siguiente formato (dia/mes/año todo con numeros)");
        fecha = entrada.nextLine();

        System.out.println("Indique su motivo");
        motivo = entrada.nextLine();

        try {
            new Cita().agendarCita(new Cita(generarId(citasJson), fecha, motivo, doctor, citaPaciente));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean eliminarCita() {
        Long id;

        citas.imprimirCitas();
        System.out.println("Indique el Id de la cita que quiere eliminar");
        id = Long.parseLong(entrada.nextLine());

        try {
            usuarioAdmin.eliminarCita(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean eliminarPaciente() {
        Long id;

        sistema.imprimirTodosPaciente();
        System.out.println("Indique el Id del paciente que quiere eliminar");
        id = Long.parseLong(entrada.nextLine());

        try {
            usuarioAdmin.eliminarPaciente(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean eliminarDoctor() {
        Long id;

        sistema.imprimirTodosDoctores();
        System.out.println("Indique el Id del doctor que quiere eliminar");
        id = Long.parseLong(entrada.nextLine());

        try {
            usuarioAdmin.eliminarDoctor(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean eliminarAdmin() {
        Long id;

        sistema.imprimirTodosAdmins();
        System.out.println("Indique el Id del admin que quiere eliminar");
        id = Long.parseLong(entrada.nextLine());

        try {
            usuarioAdmin.eliminarAdmin(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Long generarId(String json) {
        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(json));
            JSONArray jsonArray = (JSONArray) obj;

            Long longId = new Long(String.valueOf(jsonArray.size()));
            return longId + 1;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

}
