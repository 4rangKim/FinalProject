package httpSerial;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReceiveFromLPThread {
	InputStream serialIn;
	
	public ReceiveFromLPThread(InputStream serialIn) {
		this.serialIn = serialIn;
	}
	
	public void connect() {
		Thread send = new Thread(new Runnable() {
			
			@Override
			public void run() {
				byte[] buffer = new byte[1024];
				int len = -1;
				try {
					if((len=serialIn.read(buffer)) > -1){
						String data = new String(buffer, 0 ,len);
						if(data.equals("1")) {
							System.out.println("차 들어옴!");
							SendHttpThread send = new SendHttpThread("A");
							send.sendHttp();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		send.start();
	}
}
