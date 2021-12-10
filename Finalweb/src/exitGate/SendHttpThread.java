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
				if(data.length()<=3) {
					System.out.println("쓰레드안의 데이터: "+data);
					try {					
						if(data.equals("0")) {
							//Check how long the one stayed at the ParkingLot
							urlmapping = "http://192.168.0.140/Finalweb/seePayment.mc";
							url = new URL(urlmapping);
							connect = (HttpURLConnection) url.openConnection();
							connect.setReadTimeout(5000);
							connect.setRequestMethod("POST");
							br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
							
							//Calculate and Pay the fee
							BufferedReader charge = new BufferedReader(new InputStreamReader(connect.getInputStream()));
							int data = Integer.parseInt(charge.readLine());
							System.out.println("SendHttpThread의 data: "+data);
							int hour = data/60;
							int minute = data - hour*60;	
							System.out.println("Total hour: "+hour);
							System.out.println("Total minute: "+minute);
							serialOut.write(hour);
							serialOut.write(minute);
							int amount = 3000;
							if(hour >=1 || minute > 30){
								System.out.println("추가 요금!!");
								amount += Math.ceil(((float)((hour*60)+(minute-30))/5))*500;
							}
							System.out.println("Total Amount: "+amount);
							urlmapping = "http://192.168.0.140/Finalweb/pay.mc";
							url = new URL(urlmapping+"?id=HAN"+"&amount="+amount);
							connect = (HttpURLConnection) url.openConnection();
							connect.setReadTimeout(5000);
							connect.setRequestMethod("POST");
							br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
							Thread.sleep(2000);
							
							//Car OUT
							serialOut.write(1);
							urlmapping = "http://192.168.0.140/Finalweb/car.mc";
							url = new URL(urlmapping+"?car=AOut");
							connect = (HttpURLConnection) url.openConnection();
							connect.setReadTimeout(5000);
							connect.setRequestMethod("POST");
							br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
						}
//						else if(data.equals("A10") || data.equals("A11")) {
//							urlmapping = "http://192.168.0.140/Finalweb/parkingArea.mc";
//							url = new URL(urlmapping+"?parking="+data);						
//						}						
//						connect = (HttpURLConnection) url.openConnection();
//						connect.setReadTimeout(5000);
//						connect.setRequestMethod("POST");
//						br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
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
			}
		});
		send.start();
	}
}
