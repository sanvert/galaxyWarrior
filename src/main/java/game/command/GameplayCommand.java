package game.command;

import game.model.game.GameSession;

/**
 * Created by sanver.
 */
public interface GameplayCommand {
    CommandResult execute(GameSession session);
}
