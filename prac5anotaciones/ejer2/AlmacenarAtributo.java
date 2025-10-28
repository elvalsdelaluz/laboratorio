package prac5anotaciones.ejer2;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AlmacenarAtributo {
}
