package exitGateAndParking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendHttpThread {
	String urlmapping;
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
				if(data != null && data != "") {
					System.out.println("쓰레드안의 데이터: "+data);
					try {					
						if(data.equals("0")) {
							urlmapping = "http://192.168.0.140/Finalweb/car.mc";
							url = new URL(urlmapping+"?car="+data);
						}else if(data.equals("A10") || data.equals("A11")) {
							urlmapping = "http://192.168.0.140/Finalweb/parkingArea.mc";
							url = new URL(urlmapping+"?parking="+data);						
						}						
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
			}
		});
		send.start();
	}
}
