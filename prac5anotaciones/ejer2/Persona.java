package prac5anotaciones.ejer2;

@Archivo(name="PersonaMapeado.txt")
public class Persona {
    @AlmacenarAtributo
    private String nombre;
    @AlmacenarAtributo
    private String descripcion;
    private int edad;


    public Persona(String nombre, String descripcion, int edad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edad = edad;
    }
}
