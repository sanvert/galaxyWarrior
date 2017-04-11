package game.model.weapon;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by sanver.
 */
public final class WeaponComparator {

    public static final Comparator<Weapon> genericWeaponComparator = (Comparator<Weapon> & Serializable) (w1, w2) ->
            w1.getAmmo() <= 0 ? 1 :
                    w2.getAmmo() <= 0 ? -1 :
                            w1.getImpactFactor() > w2.getImpactFactor() ? -1 : 1;
}

