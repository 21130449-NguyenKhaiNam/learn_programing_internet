package use_socket;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		var port = 99;
		try {
			ServerSocket socketSV = new ServerSocket(port);
			
			System.out.println("[use_socket-Server:main] >> Success");
			while(true) {
				Socket socketC = socketSV.accept();
				MyPs ps = new MyPs(socketC);
				ps.start();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[use_socket-Server:main] >> Fail");
		} 
	}
}
