import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HelloWorldServer {
    public static void main(String[] args) throws IOException {
        // Create an HTTP server on port 3000
        HttpServer server = HttpServer.create(new InetSocketAddress(3000), 0);

        server.createContext("/", new HelloHandler());
        server.setExecutor(null); // default executor
        server.start();
        System.out.println("Server running on http://0.0.0.0:3000/");
    }

    static class HelloHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello, World from Java Web Server!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
