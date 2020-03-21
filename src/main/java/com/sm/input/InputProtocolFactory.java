package com.sm.input;

import com.sm.input.exception.InputProtocoleNotFoundException;

public class InputProtocolFactory {

	public static IInput createInputProtocol(InputProtocolType inputProtocolType)
			throws InputProtocoleNotFoundException {

		if (InputProtocolType.CONSOLE.equals(inputProtocolType))
			return new ConsoleInput();

		throw new InputProtocoleNotFoundException();
	}
}
