package com.sm.plan;

import com.sm.coordinate.Coordinates;
import com.sm.movable_object.AbstractMovableObject;

public class Rectangle implements IPlan {
	private Coordinates topLeftCoordinates;
	private Coordinates bottomRightCoordinates;

	public Rectangle(Coordinates topLeftCoordinates, Coordinates bottomRightCoordinates) {
		super();
		this.topLeftCoordinates = topLeftCoordinates;
		this.bottomRightCoordinates = bottomRightCoordinates;
	}

	public Coordinates getTopLeftCoordinates() {
		return topLeftCoordinates;
	}

	public void setTopLeftCoordinates(Coordinates topLeftCoordinates) {
		this.topLeftCoordinates = topLeftCoordinates;
	}

	public Coordinates getBottomRightCoordinates() {
		return bottomRightCoordinates;
	}

	public void setBottomRightCoordinates(Coordinates bottomRightCoordinates) {
		this.bottomRightCoordinates = bottomRightCoordinates;
	}

	@Override
	public String getLocation(AbstractMovableObject movableObject) {

		if (movableObject.getCoordinates().getxCoordinate() < 0 || movableObject.getCoordinates().getyCoordinate() < 0
				|| movableObject.getCoordinates().getxCoordinate() > bottomRightCoordinates.getxCoordinate()
				|| movableObject.getCoordinates().getyCoordinate() > bottomRightCoordinates.getyCoordinate())
			return "[-1,-1]";

		return "[" + movableObject.getCoordinates().getxCoordinate() + ","
				+ movableObject.getCoordinates().getyCoordinate() + "]";

	}
}
