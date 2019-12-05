import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.io.IOException;


public class ClientHandler implements Runnable {
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private String[][]cards;
	public ClientHandler(Socket clientSocket) throws IOException {
		this.client = clientSocket;
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(),true);
	}

	@Override
	public void run() {
		try {
			while(true) {
				String request = in.readLine();
				if(request.contains("hi")) {
					out.println("Connected.");      
				}else if(request.contains("exit")){
					out.close();
					in.close();
					System.exit(1);
				} 
				else{
					out.println("NOT.");
				}

			}
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		} finally {
			out.close();
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}