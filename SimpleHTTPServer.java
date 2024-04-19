import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
* Java program to create a simple HTTP Server to demonstrate how to use 
* ServerSocket and Socket class
*
* @author 0xb13 
*/

public class SimpleHTTPServer {
    public static void main(String[] args) throws Exception {
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ...");

        while (true) {
            //final Socket client = server.accept();
            /* 
            1. Read HTTP request from the client Socket
            2. Prepare a HTTP response
            3. Send HTTP response to the client
            4. Close the socket 
            */
            
            /* 
            Socket clientSocket = server.accept();
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            
            while(!line.isEmpty()) {
                System.out.println(line);
                line = reader.readLine();
                System.out.println(line);
            }
             */
            
            try (Socket socket = server.accept()) {
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                socket.getOutputStream()
                    .write(httpResponse.getBytes("UTF-8"));
            }

        }
    }
}