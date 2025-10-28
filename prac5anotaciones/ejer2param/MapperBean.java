package prac5anotaciones.ejer2param;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
//Mi primer parser
public class MapperBean {
    public static void main (String [] args) throws Exception {
        //Cargo en ejecución una clase cualquiera
        //Si intento cargar una .class que no existe voy a tener una excepcion
        Class<?> testClass = Class.forName(args[0]);
        //Creo una instancia del objeto
        Object obj = testClass.getDeclaredConstructor().newInstance();
        //Tengo que abrir el archivo o crearlo
        try {
            System.out.println("holaaaa");
            //Recupero la propiedad name de la anotacion Archivo
            String name = testClass.getAnnotation(Archivo.class).name();
            FileWriter arch = new FileWriter(name);
            BufferedWriter writeArch = new BufferedWriter(arch);
            //Luego recorro cada variable y la guardo en el archivo
            for (Field var : testClass.getDeclaredFields()) {
                if (var.isAnnotationPresent(AlmacenarAtributo.class)) {
                    //Modifico la accesibilidad de la variable
                    var.setAccessible(true);
                    Object value = var.get(obj);
                    //Escribo en el archivo
                    writeArch.write(var.getName() + ": "+ value);
                    writeArch.newLine();

                }
            }
            writeArch.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); // Print error details
        }

    }
}
