package JobHunterGame;

/**
 * Main class used to run the game
 * @author Jorge Garcia
 */
public class GameRunner {

    public static void main(String[] args) {
        Builder build = new Builder();
        boolean gameOver = false;

        StoryTree mainStory = build.buildStory();

        // Check to see if the player has reached an ending, if so set gameOver variable to true.
        while(!gameOver) {
            if(mainStory.isEnding()) {
                gameOver = true;
            }
            mainStory = mainStory.makeChoice();
        }
    }
}
