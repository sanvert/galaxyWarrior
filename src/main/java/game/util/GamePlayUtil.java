package game.util;

import game.model.character.Warrior;
import game.model.game.Coordinates;
import game.model.game.GameSession;

import java.util.Optional;

/**
 * Created by sanver.
 */
public class GamePlayUtil {
    public static String generateUserGameplayInfoText(GameSession session) {
        StringBuilder sb = new StringBuilder();
        Coordinates c = session.getUserWarriorCoordinates();
        Optional<Warrior> warrior;

        //Upper
        if(c.getX() - 1 >= 0
                && (warrior = session.getMap().getNodeArray()[c.getX() - 1][c.getY()].getWarrior()).isPresent()) {
            sb.append("Upper side a warrior is located")
                    .append("\n\t")
                    .append(warrior.get().getName())
                    .append("\n\t")
                    .append("Life:")
                    .append(warrior.get().getLife())
                    .append("\n\t");
        }

        //Lower
        if(c.getX() + 1 < session.getMap().getNodeArray().length
                && (warrior = session.getMap().getNodeArray()[c.getX() + 1][c.getY()].getWarrior()).isPresent()) {
            sb.append("Lower side a warrior is located")
                    .append("\n\t")
                    .append(warrior.get().getName())
                    .append("\n\t")
                    .append("Life:")
                    .append(warrior.get().getLife())
                    .append("\n\t");
        }

        //Left
        if(c.getY() - 1 >= 0
                && (warrior = session.getMap().getNodeArray()[c.getX()][c.getY() - 1].getWarrior()).isPresent()) {
            sb.append("Left side a warrior is located")
                    .append("\n\t")
                    .append(warrior.get().getName())
                    .append("\n\t")
                    .append("Life:")
                    .append(warrior.get().getLife())
                    .append("\n\t");
        }

        //Right
        if(c.getY() + 1 < session.getMap().getNodeArray()[c.getX()].length
                && (warrior = session.getMap().getNodeArray()[c.getX()][c.getY() + 1].getWarrior()).isPresent()) {
            sb.append("Right side a warrior is located")
                    .append("\n\t")
                    .append(warrior.get().getName())
                    .append("\n\t")
                    .append("Life:")
                    .append(warrior.get().getLife())
                    .append("\n\t");
        }

        return sb.toString();
    }

    public static int calculateEffectWithExperience(int effect, int experience) {
        effect *= experience + 100;
        return Math.floorDiv(effect, 100);
    }
}
