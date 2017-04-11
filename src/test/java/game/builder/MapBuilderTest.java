package game.builder;

import game.model.game.GameMap;
import game.model.game.MapNodeType;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

/**
 * Created by sanver.
 */
public class MapBuilderTest {
    private MapBuilder builder;

    @Before
    public void setUp() {
        builder = new MapBuilder();
    }

    @Test
    public void shouldCreateEnemyWarriors() {
        builder.setMapName("Small");
        builder.createMapWithParameters(20, 20);
        builder.prepareMap(10);
        GameMap createdMap = builder.build();
        AtomicInteger numOfEnemies = new AtomicInteger(0);
        IntStream.range(0, createdMap.getNodeArray().length).forEach(i -> {
            IntStream.range(0, createdMap.getNodeArray()[i].length).forEach(j -> {
                if(createdMap.getNodeArray()[i][j].getType() == MapNodeType.WARRIOR_LOCATED)
                    numOfEnemies.incrementAndGet();
            });
        });

        assertTrue(numOfEnemies.intValue()>0);
    }
}
