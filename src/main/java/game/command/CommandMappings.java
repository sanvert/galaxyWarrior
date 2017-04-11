package game.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanver.
 */
public class CommandMappings {
    public static final String ACTION_KEY_MAPPINGS_TEXT = "Gameplay commands are below:\n" +
            "w or W to move up in map\n" +
            "s or S to move down in map\n" +
            "a or A to move left in map\n" +
            "d or D to move right in map\n" +
            "save to save current game\n" +
            "exit or E to exit game without saving\n";


    private static Map<String, GameplayCommand> commandMap = new HashMap<>();

    static {
        GameplayCommand actionCommand = new ActionCommand();

        MoveUpCommand moveUp = new MoveUpCommand();
        moveUp.setNextCommand(actionCommand);

        MoveDownCommand moveDown = new MoveDownCommand();
        moveDown.setNextCommand(actionCommand);

        MoveLeftCommand moveLeft = new MoveLeftCommand();
        moveLeft.setNextCommand(actionCommand);

        MoveRightCommand moveRight = new MoveRightCommand();
        moveRight.setNextCommand(actionCommand);

        SaveCurrentGameCommand save = new SaveCurrentGameCommand();

        commandMap.put("w", moveUp);
        commandMap.put("W", moveUp);
        commandMap.put("s", moveDown);
        commandMap.put("S", moveDown);
        commandMap.put("a", moveLeft);
        commandMap.put("A", moveLeft);
        commandMap.put("d", moveRight);
        commandMap.put("D", moveRight);
        commandMap.put("save", save);
        commandMap.put("inv", new InvalidKeyCommand());
    }

    public static GameplayCommand getCommand(String w) {
        GameplayCommand command = commandMap.get(w);
        return command != null ? command : commandMap.get("inv");
    }
}
