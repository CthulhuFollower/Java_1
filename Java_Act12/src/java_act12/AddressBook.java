package java_act12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {

    private HashMap<String, String> addressBook = new HashMap<>();
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;
    private String separator = FileSystems.getDefault().getSeparator();
    private String path = String.format(
            "src%sjava_Act12%sinput.txt",
            separator, separator
    );

    public AddressBook() {
    }

    public void load() {

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line = null;
            HashMap<String, String> map = new HashMap<String, String>();

            while ((line = bufferedReader.readLine()) != null) {
                String str[] = line.split(",");
                map.put(str[0], str[1]);
            }
            setAddressBook(map);
            System.out.println("Los datos se cargaron correctamente");
        } catch (IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }

    public void save() {
        String eol = System.getProperty("line.separator");

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (Map.Entry<String, String> entry : this.addressBook.entrySet()) {
                bufferedWriter.append(entry.getKey())
                        .append(",")
                        .append(entry.getValue())
                        .append(eol);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                    System.out.println("Los datos se guardaron correctamente");
                }
            } catch (Exception e) {
            }
        }
    }

    public void create(String number, String name) {
        try {
            System.out.println("Se creo correctamente");
            this.addressBook.put(number, name);
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
    }

    public void delete(String key) {
        if (this.addressBook.get(key) != null) {
            this.addressBook.remove(key);
            System.out.println("Se elimino correctamente");
        } else {
            System.out.println("El numero que indico no existe");
        }
    }

    public void list() {
        System.out.println("Esta es la lista de contactos: ");
        for (String i : this.addressBook.keySet()) {
            System.out.println("{" + i + "}:{" + this.addressBook.get(i) + "}");
        }
        System.out.println("");
    }

    public HashMap<String, String> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(HashMap<String, String> addressBook) {
        this.addressBook = addressBook;
    }
}
