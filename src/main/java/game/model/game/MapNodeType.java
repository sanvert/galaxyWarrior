package game.model.game;

import java.io.Serializable;

/**
 * Created by sanver.
 */
public enum MapNodeType implements Serializable {
    BLOCKED('/'), FREE('.'), WARRIOR_LOCATED('W'), USER_CHAR_LOCATED('X');

    private char sign;

    private MapNodeType() {}

    private MapNodeType(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }
}
