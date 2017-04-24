package game.model.character;

import game.model.character.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by sanver.
 */
public class WarriorFactoryTest {

    @Test
    public void shouldCreateBomberRobot() {
        Warrior w = WarriorFactory.createNewWarrior(WarriorType.BOMBER_ROBOT, "Bomber");
        assertTrue(w instanceof BomberRobot);
    }

    @Test
    public void shouldCreateLaserSniper() {
        Warrior w = WarriorFactory.createNewWarrior(WarriorType.LASER_SNIPER, "Sniper");
        assertTrue(w instanceof LaserSniper);
    }

    @Test
    public void shouldCreateLaserShooter() {
        Warrior w = WarriorFactory.createNewWarrior(WarriorType.LASER_SHOOTER, "Shooter");
        assertTrue(w instanceof LaserShooter);
    }
}
