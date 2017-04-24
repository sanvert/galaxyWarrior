package game.interaction.states;

import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * Created by sanver.
 */
public abstract class ConnectedNode {
    protected Optional<Interaction> nextInteraction;

    protected ConnectedNode() {
        nextInteraction = Optional.empty();
    }

    public void setOptionalNextInteraction(Interaction interaction) {
        this.nextInteraction = ofNullable(interaction);
    }
}
