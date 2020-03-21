package com.sm.command;

import com.sm.movable_object.AbstractMovableObject;

public class MoveBackward implements ICommand {

	public void execute(AbstractMovableObject movableObject) {
		movableObject.moveBackward();
	}

}
