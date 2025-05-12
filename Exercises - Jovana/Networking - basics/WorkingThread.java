import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.nio.Buffer;
public class WorkingThread  extends Thread{
    private Socket client;
    public WorkingThread(Socket client){
        this.client = client;
    }
    @Override
    public void run(){
        BufferedReader reader;
        PrintWriter writer;
        String line;
        try {
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer = new PrintWriter(client.getOutputStream(), true);
            while((line = reader.readLine()) != null){
                System.out.println("Received: " + line);
                writer.println("Echo: " + line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    
}
}
   
