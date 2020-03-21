package com.sm.direction;

import com.sm.movable_object.AbstractMovableObject;

public interface IDirectionState {

	void moveForward(AbstractMovableObject movableObject);

	void moveBackward(AbstractMovableObject movableObject);

	void rotateClockwise(AbstractMovableObject movableObject);

	void rotateCounterClockwise(AbstractMovableObject movableObject);

}
