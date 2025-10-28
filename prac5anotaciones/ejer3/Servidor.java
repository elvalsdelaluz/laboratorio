package prac5anotaciones.ejer3;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Servidor {
    //Se utiliza para anotar una clase que funcionará como un
    //servidor HTTP.
    String direccionIP();
    int puerto();
    String archivo();
}
