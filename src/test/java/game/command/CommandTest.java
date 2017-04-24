package game.command;

import game.builder.MapBuilder;
import game.model.character.WarriorFactory;
import game.model.character.Warrior;
import game.model.character.WarriorType;
import game.model.game.GameMap;
import game.model.game.GameSession;
import game.model.game.MapNodeType;
import game.model.game.Coordinates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sanver.
 */
public class CommandTest {
    private GameplayCommand moveDownCommand;
    private GameplayCommand moveUpCommand;
    private GameplayCommand moveLeftCommand;
    private GameplayCommand moveRightCommand;
    private GameSession session;

    @Before
    public void setUp() {
        session = new GameSession();
        Warrior w = WarriorFactory.createNewWarrior(WarriorType.BOMBER_ROBOT, "Robot");
        MapBuilder builder = new MapBuilder();
        builder.createMapWithParameters(4, 4);
        builder.prepareMap(1);
        GameMap map = builder.build();
        map.getNodeArray()[1][2].setType(MapNodeType.FREE);
        map.getNodeArray()[3][2].setType(MapNodeType.FREE);
        map.getNodeArray()[2][1].setType(MapNodeType.FREE);
        map.getNodeArray()[2][3].setType(MapNodeType.FREE);
        session.setMap(map);
        session.putUserWarriorIntoMap(w, new Coordinates(2, 2));

        moveDownCommand = new MoveDownCommand();
        moveUpCommand = new MoveUpCommand();
        moveLeftCommand = new MoveLeftCommand();
        moveRightCommand = new MoveRightCommand();
    }

    @Test
    public void userWarriorShouldMoveDown() {
        moveDownCommand.execute(session);
        assertEquals(3, session.getUserWarriorCoordinates().getX());
    }

    @Test
    public void userWarriorShouldMoveUp() {
        moveUpCommand.execute(session);
        assertEquals(1, session.getUserWarriorCoordinates().getX());
    }

    @Test
    public void userWarriorShouldMoveLeft() {
        moveLeftCommand.execute(session);
        assertEquals(1, session.getUserWarriorCoordinates().getY());
    }

    @Test
    public void userWarriorShouldMoveRight() {
        moveRightCommand.execute(session);
        assertEquals(3, session.getUserWarriorCoordinates().getY());
    }
}
