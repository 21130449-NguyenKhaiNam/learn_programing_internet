package use_URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String domain = "https://thienanjjzt.wordpress.com/";
		
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL(domain);
			
			// Read website
			InputStreamReader inp = new InputStreamReader(url.openStream());
			BufferedReader reader = new BufferedReader(inp);
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
