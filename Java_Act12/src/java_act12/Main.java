package java_act12;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        AddressBook book = new AddressBook();
        String choose = "";
        String name;
        String number;

        do {
            System.out.println("""
                           Indique una opcion:
                           1.- Listar los contactos
                           2.- Crear un nuevo contacto
                           3.- Borrar un contacto
                           4.- Cargar lista de contactos
                           5.- Guardar lista de contactos
                           6.- Salir""");
            choose = in.nextLine();
            switch (choose) {
                case "1":
                    book.list();
                    break;
                case "2":
                    System.out.println("Indique el numero a guardar:");
                    number = in.nextLine();
                    System.out.println("Indique el nombre a guardar:");
                    name = in.nextLine();
                    book.create(number, name);
                    break;
                case "3":
                    System.out.println("Indique el numero a eliminar:");
                    number = in.nextLine();
                    book.delete(number);
                    break;
                case "4":
                    book.load();
                    break;
                case "5":
                    book.save();
                    break;
                case "6":
                    System.out.println("Gracias por usar mi codigo");
                    break;
                default:
                    System.out.println("Opcion incorrecta, indique un valor numerico");
                    break;
            }
        } while (!choose.equals("6"));

    }
}
