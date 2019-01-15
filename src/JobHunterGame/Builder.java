package JobHunterGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Builder is used to construct the actually story. This creates the StoryTree data structure
 * @author Jorge Garcia
 */
public class Builder {
    StoryNode current;
    boolean finished;
    ArrayList<Choice> choiceWorkList;
    ArrayList<StoryNode> storyWorkList;
    int index;

    public Builder() {
        this.finished = false;
        this.choiceWorkList = new ArrayList<Choice>();
        this.storyWorkList = new ArrayList<StoryNode>();
        this.index = 0;
    }

    /**
     * Main method run to build a story.
     * Uses an ArrayList as a stack to process all possible choices and outcomes.
     * @return StoryTree
     */
    public StoryTree buildStory() throws IOException {
        FileWriter write = new FileWriter("/Users/jorgegarcia/Documents/GameStories/JobHunter.txt" , true);
        PrintWriter printLine = new PrintWriter( write );
        String text;

        Scanner reader = new Scanner(System.in);
        System.out.println("Select your intro text");
        text = reader.next();
        current = new StoryNode(text);
        printLine.println("#0" + text);

        System.out.println("First choice text: ");
        text = reader.next();
        Choice choice1 = new Choice(text);
        printLine.println("#1" + text);
        choiceWorkList.add(choice1);

        System.out.println("Second choice text: ");
        text = reader.next();
        Choice choice2 = new Choice(text);
        printLine.printf("#2" + text);
        printLine.close();

        current.option1 = choice1;
        current.option2 = choice2;

        choiceWorkList.add(choice2);
        storyWorkList.add(current);

        // Run this over and over again until every possible branch of the story has an ending
        while(choiceWorkList.size() > 0) {
            Choice currentChoice = choiceWorkList.get(choiceWorkList.size() - 1);
            choiceWorkList.remove(currentChoice);

            System.out.println("Current Choice: " + currentChoice.text);
            System.out.println("Is this an ending? (Y or N)");
            String ending = reader.next();

            if(ending.toLowerCase().equals("y")) {
                System.out.println("Select ending text for \"" + currentChoice.text +"\"");
                currentChoice.outcome = new Ending(reader.next());
            }
            else {
                System.out.println("Outcome text for \"" + currentChoice.text +"\": ");
                current = new StoryNode(reader.next());
                currentChoice.outcome = current;

                System.out.println("First choice text: ");
                String firstChoiceText = reader.next();
                choice1 = new Choice(firstChoiceText);
                choiceWorkList.add(choice1);

                System.out.println("Second choice text: ");
                String secChoiceText = reader.next();
                choice1 = new Choice(secChoiceText);
                choiceWorkList.add(choice2);

                current.option1 = choice1;
                current.option2 = choice2;
            }
        }
        return this.current;
    }
}
