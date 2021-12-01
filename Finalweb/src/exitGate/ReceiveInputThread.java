package exitGate;

import java.io.IOException;
import java.io.InputStream;

public class ReceiveInputThread {
	InputStream serialIn;
	
	public ReceiveInputThread(InputStream serialIn) {
		this.serialIn = serialIn;
	}
	
	public void connect() {
		Thread send = new Thread(new Runnable() {
			
			@Override
			public void run() {
				byte[] buffer = new byte[1024];
				int len = -1;
				
				try {
					if((len=serialIn.read(buffer)) >-1){
						String data = new String(buffer, 0 ,len);
						if(data.equals("0")) {
							SendHttpThread send = new SendHttpThread(data.trim());
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
