package com.sm.direction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sm.command.CommandFactory;
import com.sm.command.CommandType;
import com.sm.command.ICommand;
import com.sm.coordinate.Coordinates;
import com.sm.movable_object.MovableObject;
import com.sm.plan.Rectangle;

public class DirectionTest {

	private final Rectangle rectangle = new Rectangle(new Coordinates(0, 0), new Coordinates(5, 5));
	private IDirectionState direction;
	private MovableObject movableObject;

	@Before
	public void setUp() throws Exception {
		movableObject = new MovableObject();
		movableObject.setCoordinates(new Coordinates(2, 2));
		movableObject.setPlan(rectangle);
	}
	
	@Test
	public void north() throws Exception {
		
		direction = new North();
		movableObject.setDirection(direction);

		ICommand moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_FORWARD);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getCoordinates().getxCoordinate(), 2);
		Assert.assertEquals(movableObject.getCoordinates().getyCoordinate(), 1);
		
		moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_BACKWARD);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getCoordinates().getxCoordinate(), 2);
		Assert.assertEquals(movableObject.getCoordinates().getyCoordinate(), 2);
		
		moveForwardComand = CommandFactory.createCommand(CommandType.ROTATE_CLOCK_WISE);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getDirection().getClass(), new East().getClass());
		
		moveForwardComand = CommandFactory.createCommand(CommandType.ROTATE_COUNTER_CLOCK_WIZE);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getDirection().getClass(), new North().getClass());

	}
	
	
	@Test
	public void south() throws Exception {
		
		direction = new South();
		movableObject.setDirection(direction);

		ICommand moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_FORWARD);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getCoordinates().getxCoordinate(), 2);
		Assert.assertEquals(movableObject.getCoordinates().getyCoordinate(), 3);
		
		moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_BACKWARD);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getCoordinates().getxCoordinate(), 2);
		Assert.assertEquals(movableObject.getCoordinates().getyCoordinate(), 2);
		
		moveForwardComand = CommandFactory.createCommand(CommandType.ROTATE_CLOCK_WISE);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getDirection().getClass(), new West().getClass());
		
		moveForwardComand = CommandFactory.createCommand(CommandType.ROTATE_COUNTER_CLOCK_WIZE);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getDirection().getClass(), new South().getClass());

	}
	
	
	@Test
	public void east() throws Exception {
		
		direction = new East();
		movableObject.setDirection(direction);

		ICommand moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_FORWARD);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getCoordinates().getxCoordinate(), 3);
		Assert.assertEquals(movableObject.getCoordinates().getyCoordinate(), 2);
		
		moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_BACKWARD);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getCoordinates().getxCoordinate(), 2);
		Assert.assertEquals(movableObject.getCoordinates().getyCoordinate(), 2);
		
		moveForwardComand = CommandFactory.createCommand(CommandType.ROTATE_CLOCK_WISE);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getDirection().getClass(), new South().getClass());
		
		moveForwardComand = CommandFactory.createCommand(CommandType.ROTATE_COUNTER_CLOCK_WIZE);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getDirection().getClass(), new East().getClass());

	}
	
	@Test
	public void west() throws Exception {
		
		direction = new West();
		movableObject.setDirection(direction);

		ICommand moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_FORWARD);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getCoordinates().getxCoordinate(), 1);
		Assert.assertEquals(movableObject.getCoordinates().getyCoordinate(), 2);
		
		moveForwardComand = CommandFactory.createCommand(CommandType.MOVE_BACKWARD);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getCoordinates().getxCoordinate(), 2);
		Assert.assertEquals(movableObject.getCoordinates().getyCoordinate(), 2);
		
		moveForwardComand = CommandFactory.createCommand(CommandType.ROTATE_CLOCK_WISE);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getDirection().getClass(), new North().getClass());
		
		moveForwardComand = CommandFactory.createCommand(CommandType.ROTATE_COUNTER_CLOCK_WIZE);
		moveForwardComand.execute(movableObject);
		Assert.assertEquals(movableObject.getDirection().getClass(), new West().getClass());

	}
	
	
}
