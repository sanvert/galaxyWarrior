package game.builder;

import game.interaction.process.InteractionMediator;
import game.interaction.states.MenuInteraction;
import game.util.CharacterUtil;
import game.util.GameUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by sanver.
 */
public class MenuBuilderTest {
    private MenuBuilder builder;
    private InteractionMediator mediator;

    @Before
    public void setUp() {
        builder = new MenuBuilder();
        mediator = spy(InteractionMediator.class);
    }

    @Test
    public void menuShouldObtainEndingInteraction() {
        builder.addExitSubInteraction();
        MenuInteraction interaction = builder.build();
        doReturn("1").when(mediator).readInput();
        interaction.interact(Optional.empty(), mediator);
        ArgumentCaptor<String> outputCaptor = ArgumentCaptor.forClass(String.class);
        verify(mediator, times(2)).writeOutput(outputCaptor.capture());

        assertEquals(outputCaptor.getAllValues().get(1), GameUtil.GAME_ENDED);
    }

    @Test
    public void menuShouldObtainCharacterCreationInteraction() {
        builder.addCharacterCreationSubInteraction();
        builder.addExitSubInteraction();
        MenuInteraction interaction = builder.build();
        doReturn("1").doReturn("2").when(mediator).readInput();
        interaction.interact(Optional.empty(), mediator);
        ArgumentCaptor<String> outputCaptor = ArgumentCaptor.forClass(String.class);

        verify(mediator, times(8)).writeOutput(outputCaptor.capture());

        assertEquals(outputCaptor.getAllValues().get(1), CharacterUtil.SELECT_WARRIOR_TYPE_TEXT);
    }

}
