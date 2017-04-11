package game.command;

/**
 * Created by sanver.
 */
public enum CommandResult {
    INVALID("Invalid"),
    APPLIED("Successful"),
    WON_FIGHT("Congratulations! You won the fight"),
    LOST_FIGHT("You have lost. Game ended!");

    private String message;

    CommandResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
