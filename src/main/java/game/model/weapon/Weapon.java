package game.model.weapon;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by sanver.
 */
public abstract class Weapon implements Serializable {
    private final String id;
    private int impactFactor;
    protected int ammo;

    public Weapon() {
        this.id = UUID.randomUUID().toString();
    }

    public Weapon(int impactFactor, int ammo) {
        this.id = UUID.randomUUID().toString();
        this.impactFactor = impactFactor;
        this.ammo = ammo;
    }

    public int getImpactFactor() {
        return impactFactor;
    }

    public int getAmmo() {
        return ammo;
    }

    public abstract int fire();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weapon weapon = (Weapon) o;

        return id.equals(weapon.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
