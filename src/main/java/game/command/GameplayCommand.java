package game.command;

import game.model.game.GameSession;

/**
 * Created by sanver.
 */
public interface GameplayCommand {
    public CommandResult execute(GameSession session);
}
