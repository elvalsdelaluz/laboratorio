package prac5anotaciones.examplejavanet;
import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        escritor.println("Hola servidor, soy el cliente");

        String respuesta = lector.readLine();
        System.out.println("Servidor dice: " + respuesta);

        socket.close();
        System.out.println("Conexión cerrada.");
    }
}
