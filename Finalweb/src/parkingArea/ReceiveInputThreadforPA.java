package parkingArea;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReceiveInputThreadforPA {
	InputStream serialIn;
	OutputStream serialOut;
	public ReceiveInputThreadforPA(InputStream serialIn, OutputStream serialOut) {
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
						String data = new String(buffer, 0 ,len);
						System.out.println("data:"+data);
						SendHttpThreadforPA send = new SendHttpThreadforPA(data.trim(), serialOut);
						send.sendHttp();					
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		send.start();
	}
}