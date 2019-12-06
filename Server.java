import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.net.*;
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
            pool.execute(clientThread); 
            if(size>=4){
                System.out.println("Game Start");
                cards = Game.starts(size);
                break;
            }
        }
        for(int i = 0; i<size; i++){
            System.out.println(clients.get(i).getClient().getInetAddress().toString());
            OutputStream os = clients.get(i).getClient().getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(cards[i][0]);
            bw.write(cards[i][1]);
            bw.write(cards[i][2]);
            bw.write(cards[i][3]);
            bw.flush();
        }


        
    }


}