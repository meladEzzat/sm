package com.sm.command;

import com.sm.movable_object.AbstractMovableObject;

public interface ICommand {
	
	void execute(AbstractMovableObject movableObject);

}
