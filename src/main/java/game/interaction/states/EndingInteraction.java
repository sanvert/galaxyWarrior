package game.interaction.states;

import game.interaction.process.InteractionMediator;

import java.util.Optional;

import static game.util.GameUtil.EXIT;
import static game.util.GameUtil.GAME_ENDED;

/**
 * Created by sanver.
 */
public class EndingInteraction implements Interaction {

    @Override
    public void interact(Optional data, InteractionMediator mediator) {
        mediator.writeOutput(GAME_ENDED);
    }

    @Override
    public String getHeader() {
        return EXIT;
    }

}
