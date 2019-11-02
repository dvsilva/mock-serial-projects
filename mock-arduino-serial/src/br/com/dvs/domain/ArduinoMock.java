package br.com.dvs.domain;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import br.com.dvs.exception.PortInitializationException;
import br.com.dvs.exception.SendDataException;

/**
 * @author Danyllo
 */
public class ArduinoMock {

	private static ArduinoMock singleton = null;
	
	@SuppressWarnings("unused")
	private int rate;
	@SuppressWarnings("unused")
	private String portName;

	private String lastInputValue;

	/**
	 * Arduino class Constructor method
	 * 
	 */
	public ArduinoMock() {
	}

	public void initialize(String portName, int rate) throws PortInitializationException {
		this.portName = portName;
		this.rate = rate;
		// schedule a periodic update task, otherwise let events call changed()
		Timer timer = new Timer();
		timer.schedule(new UpdateTask(), 0, 1000);
	}

	private class UpdateTask extends TimerTask {

		@Override
		public void run() {
			lastInputValue = String.valueOf(new Random().nextInt(500) + 500);
		}
	}
	
	/**
	 * Method that closes communication with the serial port
	 */
	public void closePort() {
		System.out.println("closePort performed");
	}

	/**
	 * Send command to serial port
	 * 
	 * @param operation
	 *            - Operation that will be executed
	 * @throws SendDataException 
	 */
	public void execute(Operations operation) throws SendDataException {
		sendData(operation.getValue());
	}
	
	/**
	 * @param value
	 *            - Value to send by serial port
	 * @throws SendDataException 
	 */
	public void sendData(int value) throws SendDataException {
		//System.out.println("sendData performed");
	}

	/**
	 * Return the last data sent by the serial port
	 * 
	 * @return the last data collected
	 */
	public String getLastInputValue() {
		return lastInputValue;
	}

	public void setLastInputValue(String lastInputValue) {
		this.lastInputValue = lastInputValue;
	}

	public static ArduinoMock getSingleton() {
		if (singleton == null)
			singleton = new ArduinoMock();
		
		return singleton;
	}
}
