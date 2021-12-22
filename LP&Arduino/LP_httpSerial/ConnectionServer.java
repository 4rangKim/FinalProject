package httpSerial;

import java.io.InputStream;
import java.io.OutputStream;

public class ConnectionServer {
	ArduinoSerial serialObj;
	Mqtt_Sub subscribe;
	
	public ConnectionServer() {
		serialObj = new ArduinoSerial();
		serialObj.connect("COM5");
		OutputStream serialOut = serialObj.getOutput();
		System.out.println("Mqtt Connection Start!");
		subscribe = new Mqtt_Sub().init("tcp://192.168.0.140:1883", "LattePanda", serialOut);
		subscribe.subscribe("gate");
	}
	
	public void connect() {
		Thread start = new Thread(new Runnable() {
			//Receiving signals from LattePanda
			@Override
			public void run() {
				while(true) {
					InputStream serialIn = serialObj.getInput();
					ReceiveFromLPThread receive = new ReceiveFromLPThread(serialIn);
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
		new ConnectionServer();
		
	}

}
