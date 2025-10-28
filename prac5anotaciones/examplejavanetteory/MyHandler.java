package prac5anotaciones.examplejavanetteory;
import com.sun.net.httpserver.*;
import java.io.*;

class MyHandler1 implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
        //Este NO ANDA, me salta el error
        //curl -X POST -d "Hola Tati!" http://localhost:8000/applications/myapp
        //curl: (52) Empty reply from server
        BufferedReader br = new BufferedReader(new InputStreamReader(t.getRequestBody()));
        String line = br.readLine();
        String response = "El cliente envió: " + line;
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

class MyHandler implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
        System.out.println("📩 Llegó una petición!");

        InputStream is = t.getRequestBody();
        is.readAllBytes(); // lee todo el cuerpo (aunque no lo usemos)

        String response = "Esta es la respuesta desde el servidor!";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

