package com.sm.command;

import static org.junit.Assert.assertEquals;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sm.coordinate.Coordinates;
import com.sm.direction.East;
import com.sm.direction.North;
import com.sm.direction.West;
import com.sm.movable_object.MovableObject;
import com.sm.plan.Rectangle;

public class CommandTest {

	private final Rectangle rectangle = new Rectangle(new Coordinates(0, 0), new Coordinates(5, 5));
	private North direction;
	private MovableObject movableObject;

	@Before
	public void setUp() throws Exception {
		direction = new North();
		movableObject = new MovableObject();
		movableObject.setCoordinates(new Coordinates(2, 2));
		movableObject.setDirection(direction);
		movableObject.setPlan(rectangle);
	}

	@Test
	public void moveForwardCommand() throws Exception {
		ICommand moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_FORWARD);
		moveForwardComand.execute(movableObject);

		Assert.assertEquals(movableObject.getCoordinates().getxCoordinate(), 2);
		Assert.assertEquals(movableObject.getCoordinates().getyCoordinate(), 1);

	}
	
	@Test
	public void moveBackCommand() throws Exception {
		ICommand moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_BACKWARD);
		moveForwardComand.execute(movableObject);

		Assert.assertEquals(movableObject.getCoordinates().getxCoordinate(), 2);
		Assert.assertEquals(movableObject.getCoordinates().getyCoordinate(), 3);

	}
	
	@Test
	public void rotateClockwiseCommand() throws Exception {
		ICommand moveForwardComand = CommandFactory.createCommand(CommandType.ROTATE_CLOCK_WISE);
		moveForwardComand.execute(movableObject);

		Assert.assertEquals(movableObject.getDirection().getClass(), new East().getClass());

	}
	
	@Test
	public void rotateCounterClockwiseCommand() throws Exception {
		ICommand moveForwardComand = CommandFactory.createCommand(CommandType.ROTATE_COUNTER_CLOCK_WIZE);
		moveForwardComand.execute(movableObject);

		Assert.assertEquals(movableObject.getDirection().getClass(), new West().getClass());

	}


}
