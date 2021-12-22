package httpSerial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SendtoArduino extends Thread{
	String message;
	OutputStream serialOut;
	
	public SendtoArduino(String message, OutputStream serialOut) {
		super();
		this.message = message;
		this.serialOut = serialOut;
	}
	
	
	@Override
	public void run() {
		try {
			if(message.equals("0")) {
				System.out.println("차 나감");
				serialOut.write(0);
			}else if(message.equals("1") || message.equals("A_in_on")){
				serialOut.write(1);
				System.out.println("차 들어옴");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
