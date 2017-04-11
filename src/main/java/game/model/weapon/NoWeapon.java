package game.model.weapon;

/**
 * Created by sanver.
 */
public class NoWeapon extends Weapon {
    private static NoWeapon noWeapon;

    private NoWeapon() {
        super(0, 0);
    }

    public static NoWeapon getInstance() {
        if(noWeapon == null)
            noWeapon = new NoWeapon();
        return noWeapon;
    }

    @Override
    public int fire() {
        return 0;
    }
}
