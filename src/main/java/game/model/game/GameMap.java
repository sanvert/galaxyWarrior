package game.model.game;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by sanver.
 */
public class GameMap implements Serializable {
    private String id;
    private String name;
    private MapNode[][] nodeArray;

    public GameMap() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNodeArray(MapNode[][] nodeArray) {
        this.nodeArray = nodeArray;
    }

    public MapNode[][] getNodeArray() {
        return nodeArray;
    }

}
