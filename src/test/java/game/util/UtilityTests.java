package game.util;

import game.builder.MapBuilder;
import game.model.character.WarriorFactory;
import game.model.character.Warrior;
import game.model.character.WarriorType;
import game.model.game.Coordinates;
import game.model.game.GameMap;
import game.model.game.GameSession;
import game.model.game.MapNodeType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by sanver.
 */
public class UtilityTests {

    @Test
    public void shouldContainsAllCharacterNames() {
        final Warrior w1 = WarriorFactory.createNewWarrior(WarriorType.LASER_SHOOTER, "laser");
        final Warrior w2 = WarriorFactory.createNewWarrior(WarriorType.LASER_SNIPER, "sniper");
        List<Warrior> wList = new ArrayList<>();
        wList.add(w1);
        wList.add(w2);
        String optionsText = CharacterUtil.generateCharacterOptionsText(wList);

        assertTrue(optionsText.contains(w1.getName()));
        assertTrue(optionsText.contains(w2.getName()));
    }

    @Test
    public void shouldCalculateEffectWithExperience() {
        int effect = 10;
        int experience = 10;
        effect = GamePlayUtil.calculateEffectWithExperience(effect, experience);
        assertEquals(effect, 11);
    }

    @Test
    public void shouldGenerateInfoAboutEnemiesAround() {
        GameSession session = new GameSession();
        Warrior w = WarriorFactory.createNewWarrior(WarriorType.BOMBER_ROBOT, "Robot");
        Warrior enemy = WarriorFactory.createNewWarrior(WarriorType.LASER_SHOOTER, "Shotgun");
        MapBuilder builder = new MapBuilder();
        builder.createMapWithParameters(4, 4);
        builder.prepareMap(1);
        GameMap map = builder.build();
        map.getNodeArray()[1][2].setType(MapNodeType.FREE);
        map.getNodeArray()[1][2].setWarrior(enemy);
        session.setMap(map);
        session.putUserWarriorIntoMap(w, new Coordinates(2, 2));

        String informationText = GamePlayUtil.generateUserGameplayInfoText(session);
        assertTrue(informationText.contains("Shotgun"));
        assertTrue(informationText.contains("warrior"));
    }
}
