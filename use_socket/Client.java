package use_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		var port = 99;
		try {
			Socket socket = new Socket("localhost", port);
			System.out.println("[use_socket-Client:main] >> Success");
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			Scanner sc = new Scanner(System.in);
			String mess;
			while (true) {
				// Send
				System.out.println("Client: ");
				mess = sc.nextLine();
				writer.println(mess);
				writer.flush();
				
				mess = reader.readLine();
				System.out.println("Server: " + mess);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[use_socket-Client:main] >> Fail");
		}
	}
}
