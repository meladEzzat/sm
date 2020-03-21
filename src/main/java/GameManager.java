import java.util.List;

import com.sm.command.ICommand;
import com.sm.coordinate.Coordinates;
import com.sm.direction.North;
import com.sm.input.IInput;
import com.sm.input.InputProtocolFactory;
import com.sm.input.InputProtocolType;
import com.sm.input.exception.HeaderNotCorrectException;
import com.sm.input.exception.InputProtocoleNotFoundException;
import com.sm.input.exception.PositionOutOfPoundException;
import com.sm.movable_object.AbstractMovableObject;
import com.sm.movable_object.MovableObjectFactory;
import com.sm.movable_object.MovableObjectType;
import com.sm.plan.IPlan;
import com.sm.plan.PlanFactory;

public class GameManager {
	public static void main(String[] args) throws InputProtocoleNotFoundException, HeaderNotCorrectException, PositionOutOfPoundException {

		IInput input = InputProtocolFactory.createInputProtocol(InputProtocolType.CONSOLE);

		List<Integer> header = input.readHeader();
		List<ICommand> commands = input.readCommand();
		Coordinates coordinates=new Coordinates(header.get(2), header.get(3));
		IPlan plan=PlanFactory.createRectangle(new Coordinates(0,0), new Coordinates(header.get(0)-1,header.get(1)-1));
		
		AbstractMovableObject movableObject=MovableObjectFactory
				.createMovableObject(MovableObjectType.DEFAULT);
		
	
		movableObject.setCoordinates(coordinates);
		movableObject.setDirection(new North());
		movableObject.setPlan(plan);

		for (ICommand iCommand : commands) {
			iCommand.execute(movableObject);
		}
		
		System.out.println(movableObject.getLocation());	
	}
}
