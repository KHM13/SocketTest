package util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendThread extends Thread{
	
	static HttpURLConnection connection = null;
	
	public SendThread(String target) throws Exception {
		URL url = new URL(target);
	    connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	    connection.setDoOutput(true);

	}
	
	public void run(String strData) throws Exception {
		
	    OutputStream outputStream = connection.getOutputStream();
		
	    outputStream.write(strData.getBytes());
	    outputStream.flush();

	    int responseCode = connection.getResponseCode();
	    String responseMessage = connection.getResponseMessage();
	    
	    System.out.println("Response Code: " + responseCode);
	    System.out.println("Response Message: " + responseMessage);
	    InputStream inputStream = connection.getInputStream();
	    
	    byte[] bytes = new byte[50];
        inputStream.read(bytes);
        String responseBody = new String(bytes);
        System.out.println("Response Body: " + responseBody);
	}
}
