package chatRoom;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class clientListener implements Runnable {
	private Socket socket;
	private InputStream input;

	/**
	 * @param socket
	 */
	public clientListener(Socket socket) {
		this.socket = socket;
		try {
			input = socket.getInputStream();
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
				System.out.println(mess);
				System.out.print(">> ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
