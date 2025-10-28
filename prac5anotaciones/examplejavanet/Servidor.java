package prac5anotaciones.examplejavanet;
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5000);
        System.out.println("Servidor iniciado. Esperando conexión...");

        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado.");

        BufferedReader lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);

        String mensaje = lector.readLine();
        System.out.println("Cliente dice: " + mensaje);

        escritor.println("Hola cliente, soy el servidor");

        cliente.close();
        servidor.close();
        System.out.println("Conexión cerrada.");
    }
}
