package prac5anotaciones.ejer2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
//Mi primer parser
public class MapperBean {
    public static void beanToFileSystem(Object object){
        Class<?> testClass = object.getClass();
        try {
            //Tengo que abrir el archivo o crearlo
            //recupero la propiedad name de la anotacion Archivo
            String name = testClass.getAnnotation(Archivo.class).name();
            FileWriter arch = new FileWriter(name);
            BufferedWriter writeArch = new BufferedWriter(arch);
            //Agrego el nombre de la clase al archivo
            writeArch.write("Nombre Clase: "+ object.getClass().getSimpleName());
            writeArch.newLine();
            //Luego recorro cada variable y la guardo en el archivo
            for (Field var : testClass.getDeclaredFields()) {
                if (var.isAnnotationPresent(AlmacenarAtributo.class)) {
                    //Modifico la accesibilidad de la variable
                    var.setAccessible(true);
                    Object value = var.get(object);
                    //Escribo en el archivo
                    writeArch.write(var.getName() + ": "+ value);
                    writeArch.newLine();
                }
            }
            writeArch.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        } catch (IllegalAccessException e) {
            //Este cach lo tenia que poner para obtener el valor
            //var.get(object);
            throw new RuntimeException(e);
        }
    }

    public static void main (String [] args) throws Exception {
        Mapeado mapeado = new Mapeado();
        beanToFileSystem(mapeado);
        Persona persona = new Persona ("Franco", "Roba cuna", 28);
        beanToFileSystem(persona);

        //Me falta chequear que pasa si la clase que se recibe no tiene anotaciones
    }
}
