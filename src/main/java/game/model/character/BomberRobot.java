package game.model.character;

import game.util.GamePlayUtil;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by sanver.
 */
public class BomberRobot extends Warrior {
    public BomberRobot() {
    }

    public BomberRobot(String name, int life, int experience, Comparator c) {
        super(name, life, experience, c);
    }

    @Override
    public int attack() {
        int effect = getCurrentWeapon().isPresent()
                    ? getCurrentWeapon().get().fire() : takeOutWeapon().isPresent()
                        ? getCurrentWeapon().get().fire() : 0;
        effect = GamePlayUtil.calculateEffectWithExperience(effect, this.getExperience());
        return effect;
    }
}
