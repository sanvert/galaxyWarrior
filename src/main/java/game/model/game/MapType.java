package game.model.game;

/**
 * Created by sanver.
 */
public enum MapType {
    SMALL(15, 15, 5), LARGE(30, 30, 10);

    private int width;
    private int height;
    private int numOfEnemyWarriors;

    MapType(int width, int height, int numOfEnemyWarriors) {
        this.width = width;
        this.height = height;
        this.numOfEnemyWarriors = numOfEnemyWarriors;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getNumOfEnemyWarriors() {
        return numOfEnemyWarriors;
    }

    @Override
    public String toString() {
        return  "Map -> width=" + width +
                ", height=" + height;
    }
}
