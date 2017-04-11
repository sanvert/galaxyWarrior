package game.model.weapon;

/**
 * Created by sanver.
 */
public class LaserRifle extends Weapon {

    public LaserRifle(int impactFactor, int ammo) {
        super(impactFactor, ammo);
    }

    @Override
    public int fire() {
        this.ammo--;
        return this.ammo>=0 ? getImpactFactor() : 0;
    }
}
