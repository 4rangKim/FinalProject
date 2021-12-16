package parkingArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendHttpThreadforPA {
	String urlmapping;
	URL url;
	String data;
	HttpURLConnection connect;
	BufferedReader br;
	OutputStream serialOut;
	
	public SendHttpThreadforPA(String data, OutputStream serialOut) {
		this.data = data;
		this.serialOut = serialOut;
	}
	
	public void sendHttp() {
		Thread send = new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(data.length()<=3) {
					try {						
						if(data != null && data != "") {
							urlmapping = "http://192.168.0.140/Finalweb/parkingArea.mc";
							url = new URL(urlmapping+"?parking="+data);
							connect = (HttpURLConnection) url.openConnection();
							connect.setReadTimeout(5000);
							connect.setRequestMethod("POST");
							br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
						}												
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
			}
		});
		send.start();
	}
}