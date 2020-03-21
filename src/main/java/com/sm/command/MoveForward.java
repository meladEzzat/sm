package com.sm.command;

import com.sm.movable_object.AbstractMovableObject;

public class MoveForward implements ICommand {

	public void execute(AbstractMovableObject movableObject) {
		movableObject.moveForward();
	}

}
