package remoteDesktop;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

public class RemoteServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(5000);
			while (true) {
				Socket socket = server.accept();
				System.out.println("[remoteDesktop-RemoteServer-main] >> " + socket.getInetAddress().getHostAddress());

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

	@SuppressWarnings("deprecation")
	private static void handelClietnRequest(Socket socket) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			while (true) {
				String request = reader.readLine();
				switch (request) {
				case "shutdown":
					Runtime.getRuntime().exec("shutdown -s - t 3600");
					writer.println("Dang tat...");
					break;
				case "restart":
					Runtime.getRuntime().exec("shutdown -r - t 3600");
					writer.println("Dang khoi dong lai...");
					break;
				case "open":
					String[] command = { "cmd.exe", "/c", "start", "chrome", "--incognito", "www.youtube.com" };
					try {
						Process process = Runtime.getRuntime().exec(command);
					} catch (IOException e) {
						e.printStackTrace();
					}
					writer.println("Dang mo...");
					break;
				case "screen":
					BufferedImage buffImg = new Robot()
							.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(buffImg, "png", baos);
					
					byte[] image = baos.toByteArray();
					baos.close();
					
					writer.println(image.length);
					writer.flush();
					socket.getOutputStream().write(image);
					writer.println("Dang chup...");
					break;
				default:
					break;
				}
				writer.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
