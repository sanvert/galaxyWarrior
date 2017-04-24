package game;

import game.interaction.process.CLIInteraction;
import game.interaction.process.InteractionMediator;

import java.io.IOException;

/**
 * Galaxy Warriors
 *
 */
public class App
{

    public static void main( String[] args ) {
        InteractionMediator mediator = new CLIInteraction(System.in, System.out);
        mediator.writeOutput("Welcome to the Galaxy Warriors Game!" );

        Bootstrapper bootstrapper = new Bootstrapper();
        bootstrapper.startUserInteraction(mediator);

    }
}
