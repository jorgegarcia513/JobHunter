package JobHunterGame;

/**
 * Represents a choice. A Choice has text and a possible outcome
 * @author Jorge Garcia
 */
public class Choice {
    String text;
    StoryTree outcome;

    public Choice(String text) {
        this.text = text;
    }

    public Choice(String text, StoryTree outcome) {
        this.text = text;
        this.outcome = outcome;
    }
}
