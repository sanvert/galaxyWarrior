package game.model.game;

import game.model.character.Warrior;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by sanver.
 */
public class GameSession implements Serializable {
    private String id;
    private GameMap map;
    private Coordinates userWarriorCoordinates;
    private Warrior userWarrior;

    public GameSession() {
        this.id = UUID.randomUUID().toString();
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public Coordinates getUserWarriorCoordinates() {
        return userWarriorCoordinates;
    }

    public void putUserWarriorIntoMap(Warrior userWarrior, Coordinates c) {
        this.userWarriorCoordinates = c;
        this.userWarrior = userWarrior;
        this.map.getNodeArray()[c.getX()][c.getY()].setType(MapNodeType.USER_CHAR_LOCATED);
    }

    public void updateUserWarriorLocation() {
        this.map.getNodeArray()[userWarriorCoordinates.getX()][userWarriorCoordinates.getY()]
                .setType(MapNodeType.USER_CHAR_LOCATED);
    }

    public Warrior getUserWarrior() {
        return userWarrior;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameSession that = (GameSession) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
