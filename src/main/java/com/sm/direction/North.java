package com.sm.direction;

import com.sm.movable_object.AbstractMovableObject;

public class North implements IDirectionState {

	public void moveForward(AbstractMovableObject movableObject) {
		movableObject.getCoordinates().setyCoordinate(movableObject.getCoordinates().getyCoordinate() - 1);
	}

	public void moveBackward(AbstractMovableObject movableObject) {
		movableObject.getCoordinates().setyCoordinate(movableObject.getCoordinates().getyCoordinate() + 1);
	}

	public void rotateClockwise(AbstractMovableObject movableObject) {
		movableObject.setDirection(new East());
	}

	public void rotateCounterClockwise(AbstractMovableObject movableObject) {
		movableObject.setDirection(new West());
	}
}
