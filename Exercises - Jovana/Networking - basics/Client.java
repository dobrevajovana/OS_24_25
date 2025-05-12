import java.io.IOException;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        int port = 8080;
        String host = "localhost";
        try {
            Socket clientSocket = new Socket(host, port);
            System.out.println("Connected to server: " + clientSocket.getInetAddress());
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
