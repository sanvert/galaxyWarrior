package game.util;

import game.interaction.states.Interaction;
import game.model.game.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by sanver.
 */
public class GameUtil {

    public static final String EXIT = "Exit Game";
    public static final String GAME_ENDED = "Game Ended.";
    public static final String GAME_MENU = "Game Menu";
    public static final String INVALID_SELECTION = "Invalid selection";
    public static final String NO_SAVED_GAME = "No saved game exists.";
    public static final String CREATE_NEW_MAP = "Create New Map";
    public static final String SELECT_SAVED_GAME = "Select Saved Game";
    public static final String PLAY_GAME_HAVE_FUN = "Play Game - Have fun";
    public static final String WARRIOR_IS_SAVED = "Warrior is saved";
    public static final String SPECIFY_MAP_NAME_TEXT = "Please enter map name:";
    public static String SELECT_MAP_TYPE_TEXT;

    static {
        generateMapTypeText();
    }


    private static void generateMapTypeText() {
        StringBuilder mapTypeMenu = new StringBuilder();
        MapType[] typeArray = MapType.values();
        IntStream.range(0, typeArray.length).forEach(i -> {
            mapTypeMenu.append("\t")
                    .append(i+1)
                    .append("-")
                    .append(typeArray[i])
                    .append("\n");
        });

        SELECT_MAP_TYPE_TEXT = mapTypeMenu.toString();
    }

    public static String generateOptionsText(String header, List<Interaction> interactionList) {
        String subMenu = IntStream.range(0, interactionList.size())
                .mapToObj(i -> (i + 1) + "-" + interactionList.get(i).getHeader())
                .collect(Collectors.joining("\n\t"));
        return header + "\n\t" + subMenu;
    }

    public static int convertAndValidateSelectionInput(int bound, String number) {
        try {
            int converted = Integer.valueOf(number) - 1;
            return converted < bound && converted >= 0 ? converted : Integer.MIN_VALUE;
        } catch (NumberFormatException e) {
            return Integer.MIN_VALUE;
        }
    }

    public static String convertGameMapToString(GameMap map) {
        StringBuilder sb = new StringBuilder();
        MapNode[][] mapNodeArray = map.getNodeArray();
        for(int i=0; i<mapNodeArray.length; i++) {
            for(int j=0; j<mapNodeArray[i].length; j++) {
                sb.append(mapNodeArray[i][j].getType().getSign()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String generateGameSelectionText(List<GameSession> gameSessionList) {
        return IntStream.range(0, gameSessionList.size())
                .mapToObj(i -> "\t" + (i+1) + "-" + gameSessionList.get(i).getMap().getName())
                .collect(Collectors.joining("\n"));
    }

    public static Coordinates getCoordinatesToPutWarrior(GameMap map) {
        MapNode[][] mapArray = map.getNodeArray();
        for(int i = 1; i < mapArray.length-1; i++) {
            int freeNodeCntAround = 0;
            for(int j = 1; j < mapArray[i].length-1; j++) {
                freeNodeCntAround = mapArray[i-1][j].getType() == MapNodeType.FREE ?
                        freeNodeCntAround + 1 : freeNodeCntAround;
                freeNodeCntAround = mapArray[i+1][j].getType() == MapNodeType.FREE ?
                        freeNodeCntAround + 1 : freeNodeCntAround;
                freeNodeCntAround = mapArray[i][j-1].getType() == MapNodeType.FREE ?
                        freeNodeCntAround + 1 : freeNodeCntAround;
                freeNodeCntAround = mapArray[i][j+1].getType() == MapNodeType.FREE ?
                        freeNodeCntAround + 1 : freeNodeCntAround;

                if(freeNodeCntAround > 2)
                    return new Coordinates(i, j);
            }
        }
        Random rand = new Random();
        int x = rand.nextInt(mapArray.length - 2) + 1;
        int y = rand.nextInt(mapArray[x].length - 2) + 1;
        return new Coordinates(x, y);
    }
}
