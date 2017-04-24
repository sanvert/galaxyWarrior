package game.model.character;

import game.model.weapon.LaserGun;
import game.model.weapon.LaserRifle;
import game.model.weapon.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sanver.
 */
public class WarriorTest {

    private LaserSniper sniper;

    @Before
    public void setUp() {
        sniper = (LaserSniper) WarriorFactory.createNewWarrior(WarriorType.LASER_SNIPER, "Sniper1");
        //Drop default weapon
        sniper.takeOutWeapon();
    }

    @Test
    public void shouldTakeOutWeaponWithHighlyImpactFirst() {
        Weapon rifle = new LaserRifle(2, 10);
        Weapon gun = new LaserGun(1, 10);
        sniper.pickUpWeapon(gun);
        sniper.pickUpWeapon(rifle);
        Weapon first = sniper.takeOutWeapon().get();
        Weapon second = sniper.takeOutWeapon().get();

        assertEquals(rifle, first);
        assertEquals(gun, second);
    }
}
