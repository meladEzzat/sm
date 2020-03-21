package com.sm.movable_object;

public class MovableObjectFactory {
	public static AbstractMovableObject createMovableObject(MovableObjectType type) {
		return new MovableObject();
	}
}
