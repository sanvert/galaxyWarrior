package game.model.character;

/**
 * Created by sanver.
 */
public enum WarriorType {
    BOMBER_ROBOT("Bomber Robot", 75, 5),
    LASER_SHOOTER("Laser Shooter", 125, 2),
    LASER_SNIPER("Laser Sniper", 100, 4);

    String typeName;
    int initialLife;
    int initialExperience;

    WarriorType(String typeName, int initialLife, int initialExperience) {
        this.typeName = typeName;
        this.initialLife = initialLife;
        this.initialExperience = initialExperience;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getInitialLife() {
        return initialLife;
    }

    public int getInitialExperience() {
        return initialExperience;
    }

    @Override
    public String toString() {
        return  typeName + " ->" +
                " initialLife=" + initialLife +
                ", initialExperience=" + initialExperience;
    }
}
