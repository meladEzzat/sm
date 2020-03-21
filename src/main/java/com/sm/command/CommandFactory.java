package com.sm.command;

public class CommandFactory {

	public static ICommand createCommand(CommandType commandType) {
		
		if(CommandType.MOVE_FORWARD.equals(commandType)) {
			return new MoveForward();
		}
		
		if(CommandType.MOVE_BACKWARD.equals(commandType)) {
			return new MoveBackward();
		}

		if(CommandType.ROTATE_CLOCK_WISE.equals(commandType)) {
			return new RotateClockwise();
		}

		if(CommandType.ROTATE_COUNTER_CLOCK_WIZE.equals(commandType)) {
			return new RotateCounterClockwise();
		}

		return new EmptyCommand();		
	}
}
