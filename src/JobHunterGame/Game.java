package JobHunterGame;

/**
 * Main class used for running the game
 * @author Jorge Garcia
 */
public class Game {
    StoryTree mainStory;
    boolean gameOver;

    public Game(StoryTree mainStory) {
        this.gameOver = false;
        this.mainStory = mainStory;
    }

    /**
     * Runs the game, constantly checking to see if the player is at an ending
     */
    void runGame() {
        if(this.mainStory.isEnding()) {
            this.gameOver = true;
        }
        this.mainStory = this.mainStory.makeChoice();
    }
}
