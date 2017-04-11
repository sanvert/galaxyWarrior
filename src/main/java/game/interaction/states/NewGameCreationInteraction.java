package game.interaction.states;

import game.util.GameUtil;
import game.builder.MapBuilder;
import game.interaction.process.InteractionMediator;
import game.model.game.GameMap;
import game.model.game.MapType;

import java.util.Optional;

import static game.util.GameUtil.CREATE_NEW_MAP;
import static game.util.GameUtil.INVALID_SELECTION;
import static java.util.Optional.of;

/**
 * Created by sanver.
 */
public class NewGameCreationInteraction extends ConnectedNode implements Interaction {

    @Override
    public void interact(Optional data, InteractionMediator mediator) {
        mediator.writeOutput(GameUtil.SELECT_MAP_TYPE_TEXT);
        String selectedMapType = mediator.readInput();
        int selectedMapTypeId = GameUtil.convertAndValidateSelectionInput(MapType.values().length, selectedMapType);

        if(selectedMapTypeId == Integer.MIN_VALUE) {
            mediator.writeOutput(INVALID_SELECTION);
            this.previousInteraction.ifPresent(previous -> previous.interact(Optional.empty(), mediator));
        } else {
            MapType selectedType = MapType.values()[selectedMapTypeId];
            mediator.writeOutput(GameUtil.SPECIFY_MAP_NAME_TEXT);
            String mapName = mediator.readInput();
            MapBuilder builder = new MapBuilder();
            builder.setMapName(mapName);
            builder.createMapWithParameters(selectedType.getWidth(),
                    selectedType.getHeight());
            builder.prepareMap(selectedType.getNumOfEnemyWarriors());
            GameMap map = builder.build();

            this.nextInteraction.ifPresent(next -> next.interact(of(map), mediator));
        }
    }

    @Override
    public String getHeader() {
        return CREATE_NEW_MAP;
    }
}
