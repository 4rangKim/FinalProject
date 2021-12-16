package exitGate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class ArduinoSerial {
	OutputStream out;
	InputStream in;
	
	public void connect(String portName) {
		try {
			CommPortIdentifier comPortIdentifier = CommPortIdentifier.getPortIdentifier(portName);
			
			if(comPortIdentifier.isCurrentlyOwned()) {
				System.out.println("Port Unavailable");
			}else {
				System.out.println("Port Available");
				CommPort commPort = comPortIdentifier.open("basic_serial", 3000);
				System.out.println(commPort);
				if(commPort instanceof SerialPort) {
					SerialPort serialPort = (SerialPort)commPort;
					serialPort.setSerialPortParams(
							9600,
							SerialPort.DATABITS_8,
							SerialPort.STOPBITS_1,
							SerialPort.PARITY_NONE);
					
					in = serialPort.getInputStream();
					out = serialPort.getOutputStream();
					System.out.println("Serial Connected!!");
					
				}
			}
		} catch (NoSuchPortException e) {
			e.printStackTrace();
		} catch (PortInUseException e) {
			e.printStackTrace();
		} catch (UnsupportedCommOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//
	public OutputStream getOutput() {
		return out;
	}
	
	public InputStream getInput() {
		return in;
	}
}