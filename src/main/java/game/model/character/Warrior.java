package game.model.character;

import game.model.weapon.Weapon;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Optional;
import java.util.TreeSet;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

/**
 * Created by sanver.
 */
public abstract class Warrior extends Character implements Serializable {
    private TreeSet<Weapon> weapons;
    private Weapon currentWeapon;

    public Warrior() {
    }

    public Warrior(String name, int life, int experience, Comparator c) {
        super(name, life, experience);
        weapons = new TreeSet<>(c);
    }

    public Optional<Weapon> getCurrentWeapon() {
        return ofNullable(currentWeapon);
    }

    public final void pickUpWeapon(Weapon w) {
        this.weapons.add(w);
    }

    public final Optional<Weapon> takeOutWeapon() {
        ofNullable(this.weapons.pollFirst()).ifPresent(weapon -> this.currentWeapon = weapon);
        return ofNullable(this.currentWeapon);
    }

    public abstract int attack();
}
