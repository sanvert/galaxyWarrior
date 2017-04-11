package game.interaction.states;

import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * Created by sanver.
 */
public abstract class ConnectedNode {
    protected Optional<Interaction> previousInteraction;
    protected Optional<Interaction> nextInteraction;

    public ConnectedNode() {
        previousInteraction = Optional.empty();
        nextInteraction = Optional.empty();
    }

    public void setOptionalPreviousInteraction(Interaction interaction) {
        this.previousInteraction = ofNullable(interaction);
    }

    public void setOptionalNextInteraction(Interaction interaction) {
        this.nextInteraction = ofNullable(interaction);
    }
}
