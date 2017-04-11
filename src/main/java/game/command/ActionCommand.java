package game.command;

import game.model.character.Warrior;
import game.model.game.GameSession;
import game.model.game.MapNode;
import game.model.game.Coordinates;

/**
 * Created by sanver.
 */
public class ActionCommand implements GameplayCommand {

    @Override
    public CommandResult execute(GameSession session) {
        CommandResult result = CommandResult.APPLIED;
        Coordinates c = session.getUserWarriorCoordinates();
        MapNode currentNode = session.getMap().getNodeArray()[c.getX()][c.getY()];
        if(currentNode.getWarrior().isPresent()) {
            //Fight
            Warrior currentWarrior = session.getUserWarrior();
            Warrior opponent = currentNode.getWarrior().get();

            Warrior aggressor = opponent;
            Warrior defensive = currentWarrior;
            while(defensive.getLife() > 0) {
                //Swap roles
                Warrior temp = aggressor;
                aggressor = defensive;
                defensive = temp;

                int effect = aggressor.attack();
                defensive.decreaseLife(effect);
            }

            if(defensive == currentWarrior) {
                //Warrior died
                result = CommandResult.LOST_FIGHT;
            } else {
                //Opponent died
                currentWarrior.increaseExperience(opponent.getExperience() / 2);
                result = CommandResult.WON_FIGHT;
            }
        }
        return result;
    }
}
