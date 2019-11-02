package br.com.dvs;

import org.eclipse.californium.core.CoapServer;

import br.com.dvs.resources.ActuatorResource;
import br.com.dvs.resources.SensorResource;
import br.com.dvs.service.ArduinoService;

public class MyCoapServer extends CoapServer{
	
	public static void main(String[] args) {
		ArduinoService service = ArduinoService.getSingleton();
		
		MyCoapServer tutorialServer = new MyCoapServer();
		
		SensorResource sensor = new SensorResource("sensor", service);
		tutorialServer.add(sensor);
		
		ActuatorResource actuator = new ActuatorResource("actuator", service);
		tutorialServer.add(actuator);
		
		tutorialServer.start(); 
	}

}
