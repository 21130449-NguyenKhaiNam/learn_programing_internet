package remoteDesktop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("localhost", 5000);

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			Scanner sc = new Scanner(System.in);

			boolean exit = false;

			while (!exit) {
				System.out.println("MENU: ");
				System.out.println("1. Shutdown");
				System.out.println("2. Restart");
				System.out.println("3. Open: Chrome");
				System.out.println("4. Screen Shot");

				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					writer.println("shutdown");
					break;

				case 2:
					writer.println("restart");
					break;
				case 3:
					writer.println("open");
					break;
				case 4:
					writer.println("screen");
					writer.flush();
					int imgSize = Integer.parseInt(reader.readLine());
					byte[] buffByte = new byte[imgSize];
					int byteRead = socket.getInputStream().read(buffByte);
					if (byteRead > 0) {
						String path = "C:\\Users\\PC\\OneDrive\\Desktop\\Code\\java\\learn_program_internet\\src\\remoteDesktop\\";
						System.out.println("Name: ");
						String fileName = sc.nextLine();
						sc.nextLine();
						Path image = Paths.get(path + fileName + ".png");
						Files.write(image, buffByte);
						System.out.println("Done!");
					}
					break;

				default:
					break;
				}

				writer.flush();
				System.out.println(reader.readLine());

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
