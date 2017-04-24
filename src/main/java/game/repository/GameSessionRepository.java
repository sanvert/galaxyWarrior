package game.repository;

import game.model.game.GameSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sanver.
 */
public final class GameSessionRepository extends FileRepository<GameSession> {
    private static GameSessionRepository gameSessionRepository;
    private static Set<GameSession> sessionSet;

    private GameSessionRepository() {
        super("game.dat");
        sessionSet = new HashSet<>();
        //To make singleton
    }

    public static GameSessionRepository getInstance() {
        if(gameSessionRepository == null) {
            gameSessionRepository = new GameSessionRepository();
        }
        return gameSessionRepository;
    }

    public void save(GameSession s) {
        this.sessionSet.add(s);
        super.saveAll(new ArrayList<>(this.sessionSet));
    }

    public void remove(GameSession s) {
        this.sessionSet.remove(s);
        super.saveAll(new ArrayList<>(this.sessionSet));
    }

    public List<GameSession> fetchAllGames() {
        return sessionSet.isEmpty() ? super.fetchAll() : new ArrayList<>(this.sessionSet);
    }
}
