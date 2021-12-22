package httpSerial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendHttpThread {
	String urlmapping = "http://192.168.0.140/Finalweb/carIn.mc";
	URL url;
	String data;
	HttpURLConnection connect;
	BufferedReader br;
	
	public SendHttpThread(String data) {
		this.data = data;
	}
	
	public void sendHttp() {
		Thread send = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {					
					url = new URL(urlmapping+"?car="+data);
					connect = (HttpURLConnection) url.openConnection();
					connect.setReadTimeout(5000);
					connect.setRequestMethod("POST");
					br = new BufferedReader(new InputStreamReader(connect.getInputStream()));	
				}catch (IOException e) {
					e.printStackTrace();
				} finally {
					connect.disconnect();
					if(br != null) {
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
			}
		});
		send.start();
	}
}
