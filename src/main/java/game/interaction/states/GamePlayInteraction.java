package game.interaction.states;

import game.command.CommandMappings;
import game.command.CommandResult;
import game.command.GameplayCommand;
import game.interaction.process.InteractionMediator;
import game.model.game.GameSession;
import game.repository.GameSessionRepository;
import game.repository.WarriorRepository;
import game.util.GamePlayUtil;
import game.util.GameUtil;

import java.util.Optional;

import static game.util.GameUtil.PLAY_GAME_HAVE_FUN;

/**
 * Created by sanver.
 */
public class GamePlayInteraction extends ConnectedNode implements Interaction {

    @Override
    public void interact(Optional data, InteractionMediator mediator) {
        GameSession currentGame = (GameSession) data.get();
        GameSessionRepository.getInstance().save(currentGame);
        mediator.writeOutput(CommandMappings.ACTION_KEY_MAPPINGS_TEXT);

        //Game loop
        mediator.writeOutput(GameUtil.convertGameMapToString(currentGame.getMap()));
        String userKey = mediator.readInput();
        CommandResult result = CommandResult.APPLIED;
        while (! (userKey.equals("E") || userKey.equals("exit"))
                && result != CommandResult.LOST_FIGHT) {
            GameplayCommand command = CommandMappings.getCommand(userKey);
            result = command.execute(currentGame);
            mediator.writeOutput(GameUtil.convertGameMapToString(currentGame.getMap()));
            mediator.writeOutput(GamePlayUtil.generateUserGameplayInfoText(currentGame));
            mediator.writeOutput(result.getMessage());

            if(result == CommandResult.WON_FIGHT) {
                WarriorRepository.getInstance().save(currentGame.getUserWarrior());
                mediator.writeOutput("Increased experience:" + currentGame.getUserWarrior().getExperience());
            }

            userKey = mediator.readInput();
        }

        if(result == CommandResult.LOST_FIGHT) {
            //Current game session and died character are deleted
            WarriorRepository.getInstance().remove(currentGame.getUserWarrior());
            GameSessionRepository.getInstance().remove(currentGame);
            mediator.writeOutput(result.getMessage());
        }

        this.nextInteraction.ifPresent(next -> next.interact(Optional.empty(), mediator));
    }

    @Override
    public String getHeader() {
        return PLAY_GAME_HAVE_FUN;
    }

    @Override
    public boolean isFinalizerInteraction() {
        return false;
    }
}
