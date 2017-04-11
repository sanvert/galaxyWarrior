package game.interaction.states;

import game.interaction.process.InteractionMediator;
import game.model.character.Warrior;
import game.model.game.Coordinates;
import game.model.game.GameMap;
import game.model.game.GameSession;
import game.repository.WarriorRepository;
import game.util.CharacterUtil;
import game.util.GameUtil;

import java.util.List;
import java.util.Optional;

import static game.util.CharacterUtil.SELECT_CHARACTER_HEADER;
import static game.util.CharacterUtil.THERE_IS_NO_WARRIOR;
import static game.util.GameUtil.INVALID_SELECTION;
import static java.util.Optional.of;

/**
 * Created by sanver.
 */
public class CharacterSelectionInteraction extends ConnectedNode implements Interaction {

    @Override
    public void interact(Optional data, InteractionMediator mediator) {
        GameMap createdGameMap = (GameMap) data.get();
        List<Warrior> warriorList = WarriorRepository.getInstance().fetchAllWarriors();
        if(warriorList.isEmpty()) {
            mediator.writeOutput(THERE_IS_NO_WARRIOR);
            previousInteraction.ifPresent(previous -> previous.interact(Optional.empty(), mediator));
            return;
        }

        String optionsText = CharacterUtil.generateCharacterOptionsText(warriorList);
        mediator.writeOutput(optionsText);
        mediator.writeOutput(CharacterUtil.SELECT_CHARACTER);
        String selection = mediator.readInput();
        int selectionId = GameUtil.convertAndValidateSelectionInput(warriorList.size(), selection);
        if(selectionId == Integer.MIN_VALUE) {
            mediator.writeOutput(INVALID_SELECTION);
            previousInteraction.ifPresent(previous -> previous.interact(Optional.empty(), mediator));
        } else {
            Warrior selected = warriorList.get(selectionId);
            Coordinates c = GameUtil.getCoordinatesToPutWarrior(createdGameMap);
            GameSession newGameSession = new GameSession();
            newGameSession.setMap(createdGameMap);
            newGameSession.putUserWarriorIntoMap(selected, c);
            nextInteraction.ifPresent(next -> next.interact(of(newGameSession), mediator));
        }
    }

    @Override
    public String getHeader() {
        return SELECT_CHARACTER_HEADER;
    }

}
