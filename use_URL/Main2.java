package use_URL;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] website = { "https://titv.vn", "https://google.com", "https://youtube2com" };

		for (String url : website) {
			isConnect(url);
		}
	}
	
	private static void isConnect(String urlStr) {
		try {
			URL url = new URI(urlStr).toURL();
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			
			int responseCode = connect.getResponseCode();
			
			if(responseCode == 200) {
				System.out.println("Success");
			} else {
				System.out.println("Don't know");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
