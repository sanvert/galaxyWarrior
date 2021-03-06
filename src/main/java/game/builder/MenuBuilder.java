package game.builder;

import game.interaction.states.*;

/**
 * Created by sanver.
 */
public class MenuBuilder {
    private MenuInteraction interaction;

    public MenuBuilder() {
        this.interaction = new MenuInteraction();
    }

    public void addCharacterCreationSubInteraction() {
        CharacterCreationInteraction characterCreation = new CharacterCreationInteraction();
        this.interaction.addOption(characterCreation);
        characterCreation.setOptionalNextInteraction(this.interaction);
    }

    public void addExitSubInteraction() {
        EndingInteraction endingInteraction = new EndingInteraction();
        this.interaction.addOption(endingInteraction);
    }

    public void addNewGameCreationSubInteraction() {
        GamePlayInteraction gamePlayInteraction = new GamePlayInteraction();
        gamePlayInteraction.setOptionalNextInteraction(this.interaction);

        CharacterSelectionInteraction characterSelectionInteraction = new CharacterSelectionInteraction();
        characterSelectionInteraction.setOptionalNextInteraction(gamePlayInteraction);

        NewGameCreationInteraction newGameCreationInteraction = new NewGameCreationInteraction();
        newGameCreationInteraction.setOptionalNextInteraction(characterSelectionInteraction);

        this.interaction.addOption(newGameCreationInteraction);
    }

    public void addSavedGameSelectionAndPlaySubInteraction() {
        GamePlayInteraction gamePlayInteraction = new GamePlayInteraction();
        gamePlayInteraction.setOptionalNextInteraction(this.interaction);

        GameSelectionInteraction selectionInteraction = new GameSelectionInteraction();
        selectionInteraction.setOptionalNextInteraction(gamePlayInteraction);

        this.interaction.addOption(selectionInteraction);
    }


    public MenuInteraction build() {
        MenuInteraction result = interaction;
        interaction = new MenuInteraction();
        return result;
    }
}
