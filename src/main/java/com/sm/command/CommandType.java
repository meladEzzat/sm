package com.sm.command;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {

	QUIT(0), 
	MOVE_FORWARD(1), 
	MOVE_BACKWARD(2), 
	ROTATE_CLOCK_WISE(3), 
	ROTATE_COUNTER_CLOCK_WIZE(4);

	private final Integer value;
    private static Map<Integer, CommandType> map = new HashMap<>();

	CommandType(int value) {
		this.value = value;
	}
	
    static {
        for (CommandType commandType : CommandType.values()) {
            map.put(commandType.value, commandType);
        }
    }

    public static CommandType valueOf(int value) {
    	return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
