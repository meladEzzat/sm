package com.sm.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import com.sm.command.EmptyCommand;
import com.sm.command.ICommand;
import com.sm.command.MoveBackward;
import com.sm.command.MoveForward;
import com.sm.command.RotateClockwise;
import com.sm.command.RotateCounterClockwise;
import com.sm.input.exception.HeaderNotCorrectException;
import com.sm.input.exception.PositionOutOfPoundException;

import static org.hamcrest.CoreMatchers.instanceOf;

public class InputTest {

    ConsoleInput consoleInput= new ConsoleInput();

	
	@Test
	public void shouldReadHeader() throws HeaderNotCorrectException, PositionOutOfPoundException {

	    String userInput = "4,4,1,1";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);

	    assertEquals(4,consoleInput.readHeader().size());
	}
	
	@Test(expected = PositionOutOfPoundException.class)
	public void shouldThrowPositionOutOfPoundException() throws HeaderNotCorrectException, PositionOutOfPoundException {

	    String userInput = "4,4,4,4";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);

	    consoleInput.readHeader();
	}
	
	@Test(expected = HeaderNotCorrectException.class)
	public void shouldThrowHeaderNotCorrectException() throws HeaderNotCorrectException, PositionOutOfPoundException {

	    String userInput = "4,4,4";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);

	    consoleInput.readHeader();
	}
	
	@Test
	public void shouldReadCommandString() throws HeaderNotCorrectException, PositionOutOfPoundException {

	    String userInput = "1,4,1,3,2,3,2,4,1,0";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);
	    assertEquals(9,consoleInput.readCommand().size());
	   
	}
	
	@Test
	public void shouldReadCommandString_TerminateWith0() throws HeaderNotCorrectException, PositionOutOfPoundException {

	    String userInput = "1,4,0,3,2,3,2,4,1,1";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);
	    assertEquals(2,consoleInput.readCommand().size());

	}
	
	@Test
	public void validateCommands() throws HeaderNotCorrectException, PositionOutOfPoundException {

	    String userInput = "1,2,3,4,5,0";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);
	    List<ICommand> commands=consoleInput.readCommand();

        assertThat(commands.get(0), instanceOf(MoveForward.class));
        assertThat(commands.get(1), instanceOf(MoveBackward.class));
        assertThat(commands.get(2), instanceOf(RotateClockwise.class));
        assertThat(commands.get(3), instanceOf(RotateCounterClockwise.class));
        assertThat(commands.get(4), instanceOf(EmptyCommand.class));
	    
	}

}
