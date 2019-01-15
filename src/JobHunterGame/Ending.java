package JobHunterGame;

/**
 * Represents and ending in the Story
 * @author Jorge Garcia
 */
public class Ending implements StoryTree {
    String text;

    Ending(String text) {
        this.text = text;
    }

    /**
     * Print the text associated with this ending
     * @return text field
     */
    @Override
    public String print() {
        return this.text;
    }

    /**
     * Print text associate ending with this ending
     * @return text field
     */
    @Override
    public StoryTree makeChoice() {
        System.out.println(this.text);
        return this;
    }

    /**
     * Determine if this object is an Ending
     * @return true if this object is an Ending
     */
    public boolean isEnding() {
        return true;
    }
}
