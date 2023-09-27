package use_socket;

import java.net.Socket;

public class PostScanner {
	public static void main(String[] args) {
		getPort("titv.vn");
	}
	
	private static void getPort(String urlString) {
		var startPort = 1;
		var endPort = 10000;
		System.out.println("[use-socket_PostScanner:getPort] >> Quet cac port cua may: " + urlString);
		
		for (int i = startPort; i < endPort; i++) {
			try {
				Socket socket = new Socket(urlString, i);
				System.out.println("[use-socket_PostScanner:getPort] >> Cong " + i + " dang mo");
				socket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}
