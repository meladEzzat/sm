package com.sm.plan;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sm.command.CommandFactory;
import com.sm.command.CommandType;
import com.sm.command.ICommand;
import com.sm.coordinate.Coordinates;
import com.sm.direction.IDirectionState;
import com.sm.direction.North;
import com.sm.movable_object.MovableObject;

public class PlanTest {

	private final IPlan rectangle = new Rectangle(new Coordinates(0, 0), new Coordinates(5, 5));
	private IDirectionState direction;
	private MovableObject movableObject;

	
	@Before
	public void setUp() throws Exception {
		movableObject = new MovableObject();
		movableObject.setCoordinates(new Coordinates(2, 2));
		movableObject.setPlan(rectangle);
	}
	
	@Test
	public void getLocation() throws Exception {
		
		direction = new North();
		movableObject.setDirection(direction);

		ICommand moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_FORWARD);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getLocation(),"[2,1]");
		
		moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_BACKWARD);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getLocation(),"[2,2]");

		moveForwardComand = CommandFactory.createCommand(CommandType.ROTATE_CLOCK_WISE);	
		moveForwardComand.execute(movableObject);
		moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_FORWARD);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getLocation(),"[3,2]");

		moveForwardComand = CommandFactory.createCommand(CommandType.ROTATE_COUNTER_CLOCK_WIZE);
		moveForwardComand.execute(movableObject);
		moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_FORWARD);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getLocation(),"[3,1]");

		moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_FORWARD);
		for (int i = 0; i < 3; i++) {
			moveForwardComand.execute(movableObject);			
		}
		Assert.assertEquals(movableObject.getLocation(),"[-1,-1]");

		
	}
	
}
