package game.interaction.states;

import game.interaction.process.InteractionMediator;

import java.util.Optional;

/**
 * Created by sanver on 4/7/2017.
 */
public interface Interaction<T> {
    public void interact(Optional<T> data, InteractionMediator mediator);
    public String getHeader();
}