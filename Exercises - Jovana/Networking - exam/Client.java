import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket server = new Socket("localhost", 7301);
        System.out.println("Connected to server: " + server.getInetAddress());
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter writer = new PrintWriter(server.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);
        String line;

        while((line = scanner.nextLine()) != null) {
            // send to server
            writer.println(line);
            // read from server
            String response = reader.readLine();
            System.out.println("Server: " + response);
        }
    }
}
