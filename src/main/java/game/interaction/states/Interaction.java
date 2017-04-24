package game.interaction.states;

import game.interaction.process.InteractionMediator;

import java.util.Optional;

/**
 * Created by sanver.
 */
public interface Interaction<T> {
    void interact(Optional<T> data, InteractionMediator mediator);
    String getHeader();
    boolean isFinalizerInteraction();
}
