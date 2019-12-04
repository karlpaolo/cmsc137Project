import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {
    private static final int PORT = 9999;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);
        
        
        while(true) {
            System.out.println("Waiting for client connection...");
            Socket client = listener.accept();

            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);  
            System.out.println(clients.size()); 

            pool.execute(clientThread); 
        }


        
    }


}