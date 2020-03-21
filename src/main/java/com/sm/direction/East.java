package com.sm.direction;

import com.sm.movable_object.AbstractMovableObject;

public class East implements IDirectionState {

	public void moveForward(AbstractMovableObject movableObject) {
		movableObject.getCoordinates().setxCoordinate(movableObject.getCoordinates().getxCoordinate() + 1);
	}

	public void moveBackward(AbstractMovableObject movableObject) {
		movableObject.getCoordinates().setxCoordinate(movableObject.getCoordinates().getxCoordinate() - 1);
	}

	public void rotateClockwise(AbstractMovableObject movableObject) {
		movableObject.setDirection(new South());
	}

	public void rotateCounterClockwise(AbstractMovableObject movableObject) {
		movableObject.setDirection(new North());
	}

}
