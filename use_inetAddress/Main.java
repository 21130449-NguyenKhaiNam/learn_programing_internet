package use_inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String domain = "google.com";
		try {
			InetAddress address = InetAddress.getByName(domain);
			System.out.println(address.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
