package game.interaction.process;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by sanvertarmur on 09/04/2017.
 */
public class CLIInteraction implements InteractionMediator {
    private final Scanner reader;
    private final PrintStream out;

    public CLIInteraction(InputStream in, PrintStream out) {
        this.reader = new Scanner(in);
        this.out = out;
    }

    @Override
    public String readInput() {
        this.out.print(">");
        return reader.nextLine();
    }

    @Override
    public String writeOutput(String output) {
        out.println(output);
        return "";

    }
}
