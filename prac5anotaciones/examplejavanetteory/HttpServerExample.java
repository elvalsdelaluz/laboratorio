package prac5anotaciones.examplejavanetteory;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.*;

public class HttpServerExample {
    public static void main (String args[]) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/applications/myapp", new MyHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor iniciado en http://localhost:8000/applications/myapp");
    }
}

