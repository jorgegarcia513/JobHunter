package JobHunterGame;

import java.util.Scanner;

/**
 * A StoryNode comes with text, and two possible choices to be made
 * @author Jorge Garcia
 */
public class StoryNode implements StoryTree{
    String text;
    Choice option1;
    Choice option2;

    public StoryNode(String text) {
        this.text = text;
    }

    public StoryNode(String text, Choice option1, Choice option2) {
        this.text = text;
        this.option1 = option1;
        this.option2 = option2;
    }

    /**
     * Print the text of this StoryNode
     * @return text field of this StoryNode
     */
    @Override
    public String print() {
        return this.text + "\n" + "1. " + this.option1.text + "\n" + "2. " + this.option2.text;
    }

    /**
     * Print given text, along with choice text and allow player to make a choice
     * @return the next StoryNode or Ending depending on the choice made
     */
    @Override
    public StoryTree makeChoice() {
        Scanner reader = new Scanner(System.in);
        System.out.println(this.print());

        int choice = reader.nextInt();

        if(choice == 1) {
            return this.option1.outcome;
        }
        if(choice == 2) {
            return this.option2.outcome;
        } else {
            System.out.println("Invalid Input");
            return this;
        }
    }

    /**
     * Determine if this object is an Ending object
     * @return true if this object is an Ending, false otherwise
     */
    @Override
    public boolean isEnding() {
        return false;
    }
}
