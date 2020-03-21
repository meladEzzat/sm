package com.sm.movable_object;

import com.sm.coordinate.Coordinates;
import com.sm.direction.IDirectionState;
import com.sm.plan.IPlan;

public abstract class AbstractMovableObject {

	private Coordinates coordinates;
	private IDirectionState direction;
	private IPlan plan;

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public IDirectionState getDirection() {
		return direction;
	}

	public void setDirection(IDirectionState direction) {
		this.direction = direction;
	}

	public IPlan getPlan() {
		return plan;
	}

	public void setPlan(IPlan plan) {
		this.plan = plan;
	}

	public abstract void moveForward();

	public abstract void moveBackward();

	public abstract void rotateClockwise();

	public abstract void rotateCounterClockwise();

	public abstract String getLocation();

}
