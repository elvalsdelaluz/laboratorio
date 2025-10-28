package prac5anotaciones.ejer3;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Invocar {
    //Se utiliza para marcar el o los métodos de clase que deben
    //ser invocados cuando un cliente se conecta al servidor
}
