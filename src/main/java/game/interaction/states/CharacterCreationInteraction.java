package game.interaction.states;

import game.model.weapon.LaserGun;
import game.util.GameUtil;
import game.model.character.WarriorFactory;
import game.interaction.process.InteractionMediator;
import game.model.character.Warrior;
import game.model.character.WarriorType;
import game.repository.WarriorRepository;

import java.util.Optional;

import static game.util.CharacterUtil.*;
import static game.util.GameUtil.*;

/**
 * Created by sanver.
 */
public class CharacterCreationInteraction extends ConnectedNode implements Interaction {

    @Override
    public void interact(Optional data, InteractionMediator mediator) {
        mediator.writeOutput(SELECT_WARRIOR_TYPE_TEXT);
        String warriorType = mediator.readInput();

        int selectionIndex = GameUtil.convertAndValidateSelectionInput(WarriorType.values().length, warriorType);

        if(selectionIndex == Integer.MIN_VALUE) {
            mediator.writeOutput(INVALID_SELECTION);
        } else {
            mediator.writeOutput(SPECIFY_WARRIOR_NAME_TEXT);
            String warriorName = mediator.readInput();
            WarriorType selectedType = WarriorType.values()[selectionIndex];
            Warrior newWarrior = WarriorFactory.createNewWarrior(selectedType, warriorName);
            newWarrior.pickUpWeapon(new LaserGun(10, 100));
            WarriorRepository.getInstance().save(newWarrior);
            mediator.writeOutput(WARRIOR_IS_SAVED);
            this.nextInteraction.ifPresent(next -> next.interact(Optional.empty(), mediator));
        }
    }

    @Override
    public String getHeader() {
        return CREATE_NEW_CHARACTER_HEADER;
    }

    @Override
    public boolean isFinalizerInteraction() {
        return false;
    }

}
