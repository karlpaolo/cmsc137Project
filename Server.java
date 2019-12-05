import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import game.Game;
public class Server {
    private static final int PORT = 3002;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);
    public static int size;
    private static String[][] cards;
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);
        while(true) {
            System.out.println("Waiting for client connection...");
            Socket client = listener.accept();
            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);  
            size = clients.size();
            System.out.println(size);
            if(size>=4){
                cards = Game.starts(size);
                
            }
            pool.execute(clientThread); 
        }


        
    }


}