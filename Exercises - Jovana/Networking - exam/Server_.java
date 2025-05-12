import java.io.BufferedReader;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
// client1 ---> <<< worker >>>>server 
// client2 ---> server
public class Server_ {
    private static int totalMessages = 0;
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(7301);

        while(true){
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getInetAddress());
            //worker thread
            Worker worker = new Worker(client);
            worker.start();
        }
    }

    public static synchronized int getMessages(){
        // get messages from client
        return totalMessages;
    }

    public static synchronized void increment(){
        // increment messages from client
        totalMessages++;
    }


    private static class Worker extends Thread {
        private Socket client;
        private String logFile = "log.txt";
        
        public Worker(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            // handle client
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                // log file
                FileWriter fileWriter = new FileWriter(logFile, true);
                BufferedWriter fileBufferWriter = new BufferedWriter(fileWriter);
                // read from client
                String line;
                while((line = reader.readLine()) != null){
                    if(line.equals("LOGIN")){
                        writer.println("LOGIN IN CLIENT: " + client.getInetAddress().getHostAddress());

                    }
                    else if (line.contains("LOGOUT")){
                        writer.println("LOGGED OUT IN CLIENT: " + client.getInetAddress().getHostAddress());
                        fileBufferWriter.write(client.getInetAddress().getHostAddress() + " "+ getMessages() + "\n");
                    }
                    else{
                        increment();
                        writer.println("MESSAGE IN CLIENT: " + client.getInetAddress().getHostAddress() + " " + line);
                        fileBufferWriter.write(client.getInetAddress().getHostAddress() + " " + line + "\n");
                    }
                }
                // write to client
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }   
    
}

