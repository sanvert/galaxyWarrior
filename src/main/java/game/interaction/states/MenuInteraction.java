package game.interaction.states;

import game.util.GameUtil;
import game.interaction.process.InteractionMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static game.util.GameUtil.*;

/**
 * Created by sanver.
 */
public class MenuInteraction extends ConnectedNode implements ParentNode, Interaction {

    private List<Interaction> options = new ArrayList<>();

    @Override
    public void interact(Optional data, InteractionMediator mediator) {
        mediator.writeOutput(GameUtil.generateOptionsText(GAME_MENU, options));
        String selectedOption = mediator.readInput();
        int selectedOptionId = GameUtil.convertAndValidateSelectionInput(options.size(), selectedOption);
        if(selectedOptionId == Integer.MIN_VALUE) {
            mediator.writeOutput(INVALID_SELECTION);
            this.previousInteraction.ifPresent(previous -> previous.interact(Optional.empty(), mediator));
        } else {
            this.options.get(selectedOptionId).interact(Optional.empty(), mediator);
        }

        this.nextInteraction.ifPresent(interaction -> interaction.interact(Optional.empty(), mediator));
    }

    @Override
    public String getHeader() {
        return GAME_MENU;
    }

    @Override
    public void addOption(Interaction interaction) {
        this.options.add(interaction);
    }

}
