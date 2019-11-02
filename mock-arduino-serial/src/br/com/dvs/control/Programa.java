package br.com.dvs.control;

import br.com.dvs.domain.ArduinoMock;
import br.com.dvs.domain.Operations;
import br.com.dvs.exception.SendDataException;

public class Programa {

	public static void main(String[] args) {
		try {
			ArduinoMock arduino = ArduinoMock.getSingleton();
			arduino.execute(Operations.TURN_ON);
		} 
		catch (SendDataException e) {
			e.printStackTrace();
		}
	}
}
