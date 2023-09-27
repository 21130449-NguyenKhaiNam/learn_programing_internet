package chatRoom;

import static chatRoom.IDataAddress.PORT;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private int port;
	private List<ClientHandel> clients;

	/**
	 * @param port
	 */
	public Server(int port) {
		this.port = port;
		clients = new ArrayList<>();
		start();
	}

	private void start() {
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println("[chatRoom-server: main] >> Server start");
			int i = 1;
			while (true) {
				Socket socket = server.accept();
				ClientHandel client = new ClientHandel(socket, i++, this);
				clients.add(client);
				System.out.printf("[chatRoom-server: main] >> Client %s join chat\n", i - 1);
				new Thread(client).start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server(PORT);
	}

	public void broadcastMess(String mess) {
		// TODO Auto-generated method stub
		clients.forEach(e -> {
			try {
				e.sendMess(mess);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

}
