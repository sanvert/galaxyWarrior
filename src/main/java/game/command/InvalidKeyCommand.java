package game.command;

import game.model.game.GameSession;

/**
 * Created by sanver.
 */
public class InvalidKeyCommand implements GameplayCommand {

    @Override
    public CommandResult execute(GameSession session) {
        return CommandResult.INVALID;
    }
}
