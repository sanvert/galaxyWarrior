package game.repository;

import game.model.character.Warrior;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sanver.
 */
public final class WarriorRepository extends FileRepository<Warrior> {
    private static WarriorRepository warriorRepository;
    private Set<Warrior> warriorSet = new HashSet<>();

    private WarriorRepository() {
        super("warrior.dat");
        //To make singleton
    }

    public static WarriorRepository getInstance() {
        if(warriorRepository == null) {
            warriorRepository = new WarriorRepository();
        }
        return warriorRepository;
    }

    public void save(Warrior w) {
        this.warriorSet.add(w);
        super.save(w);
    }

    public void remove(Warrior w) {
        this.warriorSet.remove(w);
        super.saveAll(new ArrayList<>(this.warriorSet));
    }
    public List<Warrior> fetchAllWarriors() {
        return warriorSet.isEmpty() ? super.fetchAll() : new ArrayList<>(this.warriorSet);
    }
}
