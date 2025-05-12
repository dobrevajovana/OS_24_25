import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.Buffer;

public class ClientNet {
    public static void main(String[] args) throws UnknownHostException, IOException {
        //server
        Socket server = new Socket("194.149.135.49",9753);
        System.out.println("Connected to server: " + server.getInetAddress());
        // reader / writer
        BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream())); 
        PrintWriter writer = new PrintWriter(server.getOutputStream(), true);
        // user input
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
