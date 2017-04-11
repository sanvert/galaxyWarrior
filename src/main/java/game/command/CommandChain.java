package game.command;

import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * Created by sanver.
 */
public abstract class CommandChain {
    private GameplayCommand next;

    public void setNextCommand(GameplayCommand command) {
        next = command;
    }

    public Optional<GameplayCommand> getNextCommand() {
        return ofNullable(next);
    }
}
