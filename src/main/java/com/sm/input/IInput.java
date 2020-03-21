package com.sm.input;

import java.util.List;

import com.sm.command.ICommand;
import com.sm.input.exception.HeaderNotCorrectException;
import com.sm.input.exception.PositionOutOfPoundException;

public interface IInput {
	
	public List<Integer> readHeader() throws HeaderNotCorrectException, PositionOutOfPoundException;

	public List<ICommand> readCommand();

}
