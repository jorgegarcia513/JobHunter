package JobHunterGame;

import java.io.IOException;

/**
 * Main class used to run the game
 * @author Jorge Garcia
 */
public class GameRunner {

    public static void main(String[] args) throws IOException {
        Builder build = new Builder();
        boolean gameOver = false;

        StoryTree mainStory = build.initialNode;

        // Check to see if the player has reached an ending, if so set gameOver variable to true.
        while(!gameOver) {
            if(mainStory.isEnding()) {
                gameOver = true;
            }
            mainStory = mainStory.makeChoice();
        }
    }
}
