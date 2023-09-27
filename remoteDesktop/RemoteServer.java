package remoteDesktop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(5000);
			while (true) {
				Socket socket = server.accept();
				System.out.println("[remoteDesktop-RemoteServer-main] >> Client connected");

				Thread th = new Thread(() -> {
					handelClietnRequest(socket);
				});
				th.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void handelClietnRequest(Socket socket) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			
			String request = reader.readLine();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
