import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.io.IOException;

public class Client{
	private static final String SERVER_IP = "192.168.1.13";
	private static final int SERVER_PORT = 9999;

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(SERVER_IP,SERVER_PORT);

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		while (true) {
			String command = keyboard.readLine();

			out.println(command);
			System.out.println(input.readLine());
		}
	}

}