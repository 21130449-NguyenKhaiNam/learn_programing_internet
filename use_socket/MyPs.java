package use_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyPs extends Thread {
	private Socket socket;

	/**
	 * @param socket
	 */
	public MyPs(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			Scanner sc = new Scanner(System.in);
			while (true) {
				String mess = reader.readLine();
				System.out.println("Client: " + mess);
				// Send
				System.out.println("Server: ");
				mess = sc.nextLine();
				writer.println(mess);
				writer.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
