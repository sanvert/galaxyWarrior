package game.model.character;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by sanver.
 */
public abstract class Character implements Serializable {
    private final String id;
    private String name;
    private int experience;
    private int life;

    public Character() {
        this.id = UUID.randomUUID().toString();
    }

    public Character(String name, int life, int experience) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.life = life;
        this.experience = experience;
    }

    public int getLife() {
        return life;
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public void decreaseLife(int value) {
        this.life -= value;
    }

    public void increaseExperience(int value) {
        this.experience += value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        return id.equals(character.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
