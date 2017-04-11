package game.model.game;


import game.model.character.Warrior;

import java.io.Serializable;
import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * Created by sanver.
 */
public class MapNode implements Serializable {
    private MapNodeType type;
    private Warrior warrior;

    public MapNode() {
    }

    public MapNode(MapNodeType type) {
        this.type = type;
    }

    public MapNodeType getType() {
        return type;
    }

    public void setType(MapNodeType type) {
        this.type = type;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }

    public Optional<Warrior> getWarrior() {
        return ofNullable(warrior);
    }
}
