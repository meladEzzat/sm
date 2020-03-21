package com.sm.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sm.command.CommandFactory;
import com.sm.command.CommandType;
import com.sm.command.ICommand;
import com.sm.input.exception.HeaderNotCorrectException;
import com.sm.input.exception.PositionOutOfPoundException;

public class ConsoleInput implements IInput {

	public List<Integer> readHeader() throws HeaderNotCorrectException, PositionOutOfPoundException {
		Scanner scanner = new Scanner(System.in);
		List<Integer> headerInputs = new ArrayList<>();

		scanner.useDelimiter("\\D");
		while (scanner.hasNextInt()) {
			headerInputs.add(scanner.nextInt());
		}

		if (headerInputs == null || headerInputs.size() < 4)
			throw new HeaderNotCorrectException();

		if (headerInputs.get(2) >= headerInputs.get(0) || headerInputs.get(3) >= headerInputs.get(1))
			throw new PositionOutOfPoundException();

		return headerInputs;
	}

	public List<ICommand> readCommand() {
		Scanner scanner = new Scanner(System.in);
		List<ICommand> commands = new ArrayList<>();

		scanner.useDelimiter("\\D");
		while (scanner.hasNextInt()) {
			int nextInt = scanner.nextInt();
			if (0 == nextInt)
				break;
			commands.add(CommandFactory.createCommand(CommandType.valueOf(nextInt)));
		}

		scanner.close();
		return commands;
	}

}
