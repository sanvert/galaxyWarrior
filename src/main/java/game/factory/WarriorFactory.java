package game.factory;

import game.model.character.*;
import game.model.weapon.Bomb;
import game.model.weapon.WeaponComparator;
import game.model.weapon.LaserGun;
import game.model.weapon.LaserRifle;

import static game.model.character.WarriorType.*;

/**
 * Created by sanver.
 */
public class WarriorFactory {
    public static Warrior createNewWarrior(WarriorType type, String name) {
        Warrior warrior = null;
        switch(type) {
            case LASER_SHOOTER:
                name = name + " the " + LASER_SHOOTER.getTypeName();
                LaserShooter shooter = new LaserShooter(name, type.getInitialLife(), type.getInitialExperience(),
                        WeaponComparator.genericWeaponComparator);
                shooter.pickUpWeapon(new LaserGun(2, 15));
                warrior = shooter;
                break;
            case LASER_SNIPER:
                name = name + " the " + LASER_SNIPER.getTypeName();
                LaserSniper sniper = new LaserSniper(name, type.getInitialLife(), type.getInitialExperience(),
                        WeaponComparator.genericWeaponComparator);
                sniper.pickUpWeapon(new LaserRifle(3, 10));
                warrior = sniper;
                break;
            case BOMBER_ROBOT:
                name = name + " the " + BOMBER_ROBOT.getTypeName();
                BomberRobot robot = new BomberRobot(name, type.getInitialLife(), type.getInitialExperience()
                        , WeaponComparator.genericWeaponComparator);
                robot.pickUpWeapon(new Bomb(15));
                warrior = robot;
                break;
        }
        return warrior;
    }
}
