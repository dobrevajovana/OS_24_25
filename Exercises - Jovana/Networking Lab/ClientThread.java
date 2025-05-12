import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientThread extends Thread {
    private Socket server;
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        ClientThread client1 = new ClientThread();
        client1.start();
        ClientThread client2 = new ClientThread();
        client2.start();

        client1.join();
        client2.join();
    }
    public ClientThread() throws IOException, UnknownHostException {
        this.server = new Socket("194.149.135.49", 9753);
    }

    @Override
    public void run() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(this.server.getInputStream()));
            PrintWriter writer = new PrintWriter(this.server.getOutputStream(), true);
            // user input
            
            writer.println("hello:121212");
                // read from server
            String response = reader.readLine();
            System.out.println("Server: " + response);
            writer.println("hello:123413");
            System.out.println("Server: " + response);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
      
    }
}