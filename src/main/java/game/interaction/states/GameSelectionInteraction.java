package game.interaction.states;

import game.interaction.process.InteractionMediator;
import game.model.character.Warrior;
import game.model.game.GameSession;
import game.repository.GameSessionRepository;
import game.util.GameUtil;

import java.util.List;
import java.util.Optional;

import static game.util.GameUtil.INVALID_SELECTION;
import static game.util.GameUtil.NO_SAVED_GAME;
import static game.util.GameUtil.SELECT_SAVED_GAME;
import static java.util.Optional.of;

/**
 * Created by sanver.
 */
public class GameSelectionInteraction extends ConnectedNode implements Interaction {

    @Override
    public void interact(Optional data, InteractionMediator mediator) {
        List<GameSession> gameList = GameSessionRepository.getInstance().fetchAllGames();
        if(gameList.isEmpty()) {
            mediator.writeOutput(NO_SAVED_GAME);
            return;
        }

        String options = GameUtil.generateGameSelectionText(gameList);
        mediator.writeOutput(options);
        String selection = mediator.readInput();
        int selectionId = GameUtil.convertAndValidateSelectionInput(gameList.size(), selection);
        if(selectionId == Integer.MIN_VALUE) {
            mediator.writeOutput(INVALID_SELECTION);
        } else {
            GameSession selected = gameList.get(selectionId);
            nextInteraction.ifPresent(next -> next.interact(of(selected), mediator));
        }
    }

    @Override
    public String getHeader() {
        return SELECT_SAVED_GAME;
    }

    @Override
    public boolean isFinalizerInteraction() {
        return false;
    }

}
