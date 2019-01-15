package JobHunterGame;

public interface StoryTree {
    // Print the text of the given StoryNode or Ending
    String print();

    // Print text along with choices if a StoryNode, allow player to make choice
    StoryTree makeChoice();

    // Determines whether or not this is an ending
    boolean isEnding();
}
