package game.util;

import game.model.character.Character;
import game.model.character.WarriorType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by sanver.
 */
public class CharacterUtil {

    public static final String SELECT_CHARACTER_HEADER = "Select Character";
    public static final String CREATE_NEW_CHARACTER_HEADER = "Create New Character";
    public static final String THERE_IS_NO_WARRIOR = "There is no warrior!";
    public static final String SELECT_CHARACTER = "Please select a character:";
    public static final String SPECIFY_WARRIOR_NAME_TEXT = "Please enter warrior name:";
    public static String SELECT_WARRIOR_TYPE_TEXT;

    static {
        generateWarriorTypeText();
    }

    private static void generateWarriorTypeText() {
        StringBuilder warriorTypeMenu = new StringBuilder();
        WarriorType[] typeArray = WarriorType.values();
        IntStream.range(0, typeArray.length).forEach(i -> {
            warriorTypeMenu.append("\t")
                    .append(i+1)
                    .append("-")
                    .append(typeArray[i])
                    .append("\n");
        });

        SELECT_WARRIOR_TYPE_TEXT = warriorTypeMenu.toString();
    }

    public static String generateCharacterOptionsText(List<? extends Character> characterList) {
        return IntStream.range(0, characterList.size())
                .mapToObj(i -> "\t" + (i+1) + "-" + characterList.get(i).getName())
                .collect(Collectors.joining("\n"));
    }
}
