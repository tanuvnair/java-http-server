import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPServer {
    public static void main(String args[]) throws Exception {
        // Creates a net socket that accepts connections on the port 8080
        final ServerSocket server = new ServerSocket(8080);
        
        System.out.println("Listening for connection on port 8080....");

        while(true) {
            try (Socket socket = server.accept()) {
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n";

                String myString = httpResponse + today;

                socket.getOutputStream().write(myString.getBytes("UTF-8"));
            }
        }
    }
}
