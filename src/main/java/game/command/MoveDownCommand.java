package game.command;

import game.model.game.GameSession;
import game.model.game.MapNode;
import game.model.game.MapNodeType;
import game.model.game.Coordinates;

/**
 * Created by sanver.
 */
public class MoveDownCommand extends CommandChain implements GameplayCommand {

    @Override
    public CommandResult execute(GameSession session) {
        CommandResult result = CommandResult.APPLIED;
        Coordinates c = session.getUserWarriorCoordinates();
        if(c.getX() + 1 >= session.getMap().getNodeArray().length)
            return CommandResult.INVALID;

        MapNode nextNode = session.getMap().getNodeArray()[c.getX() + 1][c.getY()];
        if(nextNode.getType() == MapNodeType.BLOCKED)
            return CommandResult.INVALID;
        else {
            MapNode currentNode = session.getMap().getNodeArray()[c.getX()][c.getY()];
            currentNode.setType(MapNodeType.FREE);

            c.setX(c.getX() + 1);
            session.updateUserWarriorLocation();
        }

        return this.getNextCommand().isPresent() ? this.getNextCommand().get().execute(session) : result;
    }

}