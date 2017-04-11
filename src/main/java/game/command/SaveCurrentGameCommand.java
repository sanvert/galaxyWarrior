package game.command;

import game.model.game.GameSession;
import game.repository.GameSessionRepository;

/**
 * Created by sanver.
 */
public class SaveCurrentGameCommand implements GameplayCommand {
    @Override
    public CommandResult execute(GameSession session) {
        GameSessionRepository.getInstance().save(session);
        return CommandResult.APPLIED;
    }
}
