package prac5anotaciones.ejer2;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //TYPE SE USA PARA INTERFACES, ENUMERATIVOS Y CLASES
public @interface Archivo {
    String name ();
}
