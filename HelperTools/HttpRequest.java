package HelperTools;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
 

 
public class HttpRequest {
 
	
 
	public static void GetRequest(String url) throws Exception {
		URL u = new URL(url);
		HttpURLConnection c = (HttpURLConnection) u.openConnection();
		c.setRequestMethod("GET");
		c.setRequestProperty("User-Agent", "Mozilla/5.0");
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(c.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
 

 
}
