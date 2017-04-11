package game.builder;

import game.factory.WarriorFactory;
import game.model.character.Warrior;
import game.model.character.WarriorType;
import game.model.game.GameMap;
import game.model.game.MapNode;
import game.model.game.MapNodeType;

import java.util.Optional;
import java.util.Random;

/**
 * Created by sanver.
 */
public class MapBuilder {
    private GameMap map;

    public MapBuilder() {
        map = new GameMap();
    }

    public void setMapName(String name) {
        this.map.setName(name);
    }

    public void createMapWithParameters(int width, int height) {
        // To create borders 2 is added.
        this.map.setNodeArray(new MapNode[height+2][width+2]);
    }

    public void prepareMap(int numOfEnemyWarriors) {
        // To create borders 2 is added.
        MapNode[][] nodeArr = this.map.getNodeArray();
        int numberOfInternalNodes =(nodeArr.length-2) * (nodeArr[0].length-2);
        //Assumed that one fifth of nodes are blocked;
        int numberOfBlockedNodes = Math.floorDiv(numberOfInternalNodes, 5);
        int remainingBlockedNodes = numberOfBlockedNodes;
        int numberOfRemainingEnemyWarriors = numOfEnemyWarriors;
        Random rand = new Random();
        for(int i = 0; i<nodeArr.length; i++) {
            for(int j = 0; j<nodeArr[i].length; j++) {
                MapNode newNode;
                if((i==0||j==0||i==nodeArr.length-1||j==nodeArr[i].length-1)) {
                    newNode = new MapNode(MapNodeType.BLOCKED);
                } else if((remainingBlockedNodes > 0 && rand.nextInt(numberOfInternalNodes) < numberOfBlockedNodes)){
                    newNode = new MapNode(MapNodeType.BLOCKED);
                    remainingBlockedNodes--;
                } else if(numberOfRemainingEnemyWarriors > 0 && rand.nextInt(numberOfInternalNodes) < numOfEnemyWarriors) {
                    newNode = new MapNode(MapNodeType.WARRIOR_LOCATED);
                    WarriorType randomType = WarriorType.values()[rand.nextInt(WarriorType.values().length)];
                    Warrior randomWarrior = WarriorFactory.createNewWarrior(randomType, randomType.getTypeName() + rand.nextInt(numberOfInternalNodes));
                    newNode.setWarrior(randomWarrior);
                    numberOfRemainingEnemyWarriors--;
                } else {
                    newNode = new MapNode(MapNodeType.FREE);
                }
                nodeArr[i][j] = newNode;
            }
        }
    }

    public GameMap build() {
        return map;
    }
}
