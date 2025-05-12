import java.io.IOException;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.nio.Buffer;
public class Server {
    public static void main(String[] args) throws IOException {
        int port  = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        while(true){
            Socket client = serverSocket.accept();
            System.out.println("Client connected: " + client.getInetAddress());
            WorkingThread thread = new WorkingThread(client);
            thread.start();
            
        }

    }
}

class WorkingThread  extends Thread{
    private Socket client;
    public WorkingThread(Socket client){
        this.client = client;
    }
    @Override
    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
    
        String line;
        while((line = reader.readLine()) != null){
            System.out.println("Received: " + line);
            writer.println("Echo: " + line);
        }

    
}

