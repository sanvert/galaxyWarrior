package game.model.weapon;

/**
 * Created by sanver.
 */
public class Bomb extends Weapon {

    public Bomb(int impact) {
        super(impact,1);
    }

    @Override
    public int fire() {
        if(this.ammo>0) {
            this.ammo = 0;
            return getImpactFactor();
        }
        return 0;
    }
}
