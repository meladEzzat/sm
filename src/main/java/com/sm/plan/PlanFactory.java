package com.sm.plan;

import com.sm.coordinate.Coordinates;

public class PlanFactory {

	public static IPlan createRectangle(Coordinates topLeftCoordinates,Coordinates bottomRightCoordinates) {
		return new Rectangle(topLeftCoordinates,bottomRightCoordinates);
	}
	
}
