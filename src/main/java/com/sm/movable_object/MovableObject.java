package com.sm.movable_object;

public class MovableObject extends AbstractMovableObject {

	public void moveForward() {
		this.getDirection().moveForward(this);
	}

	public void moveBackward() {
		this.getDirection().moveBackward(this);
	}

	public void rotateClockwise() {
		this.getDirection().rotateClockwise(this);
	}

	public void rotateCounterClockwise() {
		this.getDirection().rotateCounterClockwise(this);
	}

	@Override
	public String getLocation() {
		return getPlan().getLocation(this);
	}
}
