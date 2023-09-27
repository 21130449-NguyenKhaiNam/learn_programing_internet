package chatRoom;

import static chatRoom.IDataAddress.HOST;
import static chatRoom.IDataAddress.PORT;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public Client() {
		start();
	}
	
	private void start() {
		try {
			Socket socket = new Socket(HOST, PORT);
			
			clientListener clientListener = new clientListener(socket);
			new Thread(clientListener).start();
			
			OutputStream output = socket.getOutputStream();
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.print(">> ");
				String mess = sc.nextLine();
				output.write(mess.getBytes());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
