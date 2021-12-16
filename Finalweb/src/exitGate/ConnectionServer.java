package exitGate;

import java.io.InputStream;
import java.io.OutputStream;


public class ConnectionServer {
	ArduinoSerial serialObj;
	OutputStream serialOut;
	
	public ConnectionServer() {
		serialObj = new ArduinoSerial();
		serialObj.connect("COM4");
		serialOut = serialObj.getOutput();
	}
	
	public void connect() {
		Thread start = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					InputStream serialIn = serialObj.getInput();
					ReceiveInputThread receive = new ReceiveInputThread(serialIn, serialOut);
					receive.connect();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		start.start();
	}
	
	public static void main(String[] args) {
		new ConnectionServer().connect();
	}

}