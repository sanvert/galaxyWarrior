package game.interaction.states;

import game.interaction.process.InteractionMediator;
import game.util.GameUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static game.util.GameUtil.GAME_MENU;
import static game.util.GameUtil.INVALID_SELECTION;
import static java.util.Optional.of;

/**
 * Created by sanver.
 */
public class MenuInteraction extends ConnectedNode implements ParentNode, Interaction {

    private List<Interaction> options = new ArrayList<>();

    @Override
    public void interact(Optional data, InteractionMediator mediator) {
        Optional<Interaction> currentInteraction = Optional.empty();
        while (! currentInteraction.isPresent()
                || ! currentInteraction.get().isFinalizerInteraction()) {
            mediator.writeOutput(GameUtil.generateOptionsText(GAME_MENU, options));
            String selectedOption = mediator.readInput();
            int selectedOptionId = GameUtil.convertAndValidateSelectionInput(options.size(), selectedOption);
            if(selectedOptionId == Integer.MIN_VALUE) {
                mediator.writeOutput(INVALID_SELECTION);
            } else {
                currentInteraction = of(this.options.get(selectedOptionId));
                currentInteraction.get().interact(Optional.empty(), mediator);
            }
        }

        this.nextInteraction.ifPresent(interaction -> interaction.interact(Optional.empty(), mediator));
    }

    @Override
    public String getHeader() {
        return GAME_MENU;
    }

    @Override
    public boolean isFinalizerInteraction() {
        return false;
    }

    @Override
    public void addOption(Interaction interaction) {
        this.options.add(interaction);
    }

}
