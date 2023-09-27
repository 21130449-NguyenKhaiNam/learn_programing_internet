package chatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandel implements Runnable {
	private Socket socket;
	private int id;
	private Server server;
	private InputStream input;
	private OutputStream output;

	/**
	 * @param socket
	 * @param id
	 * @param server
	 */
	public ClientHandel(Socket socket, int id, Server server) {
		this.socket = socket;
		this.id = id;
		this.server = server;
		try {
			this.input = socket.getInputStream();
			this.output = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buffer)) != -1) {
				String mess = new String(buffer, 0, bytesRead);
				server.broadcastMess("Client " + this.id + " " + mess);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMess(String mess) throws IOException {
		output.write(mess.getBytes());
	}

}
