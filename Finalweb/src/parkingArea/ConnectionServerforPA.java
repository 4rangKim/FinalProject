package parkingArea;

import java.io.InputStream;
import java.io.OutputStream;


public class ConnectionServerforPA {
	ArduinoSerialforPA serialObj;
	OutputStream serialOut;
	
	public ConnectionServerforPA() {
		serialObj = new ArduinoSerialforPA();
		serialObj.connect("COM5");
		serialOut = serialObj.getOutput();
	}
	
	public void connect() {
		Thread start = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					InputStream serialIn = serialObj.getInput();
					ReceiveInputThreadforPA receive = new ReceiveInputThreadforPA(serialIn, serialOut);
					receive.connect();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		start.start();
	}
	
	public static void main(String[] args) {
		new ConnectionServerforPA().connect();
	}

}