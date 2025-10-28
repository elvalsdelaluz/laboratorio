package prac5anotaciones.examplejavanetchat;
import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Conectado al servidor.");

        BufferedReader lectorServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter escritorServidor = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader lectorConsola = new BufferedReader(new InputStreamReader(System.in));

        String mensajeCliente, mensajeServidor;

        while (true) {
            System.out.print("Cliente: ");
            mensajeCliente = lectorConsola.readLine();
            escritorServidor.println(mensajeCliente);

            if (mensajeCliente.equalsIgnoreCase("salir")) {
                System.out.println("Desconectando...");
                break;
            }

            mensajeServidor = lectorServidor.readLine();

            if (mensajeServidor == null || mensajeServidor.equalsIgnoreCase("salir")) {
                System.out.println("El servidor se ha desconectado.");
                break;
            }

            System.out.println("Servidor dice: " + mensajeServidor);
        }

        lectorServidor.close();
        escritorServidor.close();
        socket.close();
    }
}

