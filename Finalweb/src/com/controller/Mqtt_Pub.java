package com.controller;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class Mqtt_Pub {
	private MqttClient client;
	public Mqtt_Pub(){
		try {
			client = new MqttClient("tcp://192.168.0.140:1883", "PC_Publishing");
			client.connect();
			System.out.println("MQTT Connected");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
	public boolean send(String topic, String msg) {
		MqttMessage message = new MqttMessage();
		message.setPayload(msg.getBytes()); 
		try {
			client.publish(topic, message);
			System.out.println("Message Published");
		} catch (MqttPersistenceException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		} 		
		return true;
	}
	
	public void close() {
		try {
			if(client != null) {
				client.disconnect();
				client.close(); 
			} 
		} catch (MqttException e) {
				e.printStackTrace();
			}
		
	}

}
