package exitGate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReceiveInputThread {
	InputStream serialIn;
	OutputStream serialOut;
	public ReceiveInputThread(InputStream serialIn, OutputStream serialOut) {
		this.serialIn = serialIn;
		this.serialOut = serialOut;
	}
	
	public void connect() {
		Thread send = new Thread(new Runnable() {
			
			@Override
			public void run() {
				byte[] buffer = new byte[1024];
				int len = -1;
				try {
					if((len=serialIn.read(buffer)) > 0){
						String data = new String(buffer, 0 ,len).trim();
						System.out.println("data:"+data);
						if(data.equals("0")) {
							SendHttpThread send = new SendHttpThread("A", serialOut);
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
