package game;

import game.builder.MenuBuilder;
import game.interaction.process.InteractionMediator;
import game.interaction.states.MenuInteraction;
import game.repository.GameSessionRepository;
import game.repository.WarriorRepository;

import java.util.Optional;

/**
 * Created by sanver.
 */
public class Bootstrapper {
    private final MenuInteraction menuInteraction;

    public Bootstrapper() {
        //Load all warrior list
        WarriorRepository.getInstance().fetchAllWarriors();
        //Load all game sessions
        GameSessionRepository.getInstance().fetchAllGames();
        //Create game menu
        this.menuInteraction = prepareMenu();
    }

    public MenuInteraction prepareMenu() {
        MenuBuilder builder = new MenuBuilder();
        builder.addCharacterCreationSubInteraction();
        builder.addNewGameCreationSubInteraction();
        builder.addSavedGameSelectionAndPlaySubInteraction();
        builder.addExitSubInteraction();
        return builder.build();
    }

    public void startUserInteraction(InteractionMediator mediator) {
        this.menuInteraction.interact(Optional.empty(), mediator);
    }
}
