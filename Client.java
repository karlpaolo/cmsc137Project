import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.io.IOException;

public class Client{
	//private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 3002;

	public static void main(String[] args) throws IOException {
		
		String serverName = args[0];
		Socket socket = new Socket(serverName,SERVER_PORT);
		//Socket socket = new Socket(SERVER_IP,SERVER_PORT);
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		while (true) {
			String command = keyboard.readLine();

			out.println(command);
			if(command.contains("exit")){
				System.exit(1);
			}
			System.out.println(input.readLine());
		}
	}

}
