package exitGate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendHttpThread {
	String urlmapping;
	URL url;
	String data;
	HttpURLConnection connect;
	BufferedReader br;
	OutputStream serialOut;
	
	public SendHttpThread(String data, OutputStream serialOut) {
		this.data = data;
		this.serialOut = serialOut;
	}
	
	public void sendHttp() {
		Thread send = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					urlmapping = "http://192.168.0.140/Finalweb/carOut.mc"+"?parkingLot="+data;
					url = new URL(urlmapping);
					connect = (HttpURLConnection) url.openConnection();
					connect.setReadTimeout(5000);
					connect.setRequestMethod("GET");
					br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
					BufferedReader charge = new BufferedReader(new InputStreamReader(connect.getInputStream()));
					int amount = Integer.parseInt(charge.readLine());
					int fee1 = amount/255;
					int fee2 = amount%255;
					serialOut.write(fee1);
					serialOut.write(fee2);
					Thread.sleep(1000);
					serialOut.write(0);
				}catch (IOException | InterruptedException e) {
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
