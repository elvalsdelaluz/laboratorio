package prac5anotaciones.examplejavanetchat;
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5000);
        System.out.println("Servidor iniciado. Esperando conexión...");

        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado.");

        BufferedReader lectorCliente = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        PrintWriter escritorCliente = new PrintWriter(cliente.getOutputStream(), true);
        BufferedReader lectorConsola = new BufferedReader(new InputStreamReader(System.in));

        String mensajeCliente, mensajeServidor;

        // Bucle de comunicación
        while (true) {
            mensajeCliente = lectorCliente.readLine();

            // Si el cliente se desconecta o escribe "salir"
            if (mensajeCliente == null || mensajeCliente.equalsIgnoreCase("salir")) {
                System.out.println("El cliente se ha desconectado.");
                break;
            }

            System.out.println("Cliente dice: " + mensajeCliente);

            System.out.print("Servidor: ");
            mensajeServidor = lectorConsola.readLine();
            escritorCliente.println(mensajeServidor);

            if (mensajeServidor.equalsIgnoreCase("salir")) {
                System.out.println("Servidor cerrando conexión...");
                break;
            }
        }

        lectorCliente.close();
        escritorCliente.close();
        cliente.close();
        servidor.close();
    }
}
