package JobHunterGame;

import java.io.*;
import java.util.*;

/**
 * Builder is used to construct the actually story. This creates the StoryTree data structure imported
 * from a text file.
 *
 * The text file must be in the following format
 *
 * 1# Intro Text
 * 11 Choice 1
 * 12 Choice 2
 * 11# Text for Outcome of Choice 1
 * 111 Choice 1
 * 112 Choice 2
 * 12# Text for Outcome of Choice 2
 *
 * That structure is then linked together and stored in the initialNode variable.
 * @author Jorge Garcia
 */
public class Builder {
    StoryNode current;
    public StoryTree initialNode;
    ArrayList<Choice> choiceWorkList;
    ArrayList<String> storyTreeKeys;
    private final File f;
    private final Scanner fileReader;
    HashMap<String, StoryTree> stories;
    HashMap<String, Choice> choices;

    public Builder() throws FileNotFoundException {
        this.choiceWorkList = new ArrayList<Choice>();
        this.storyTreeKeys = new ArrayList<String>();
        this.f = new File("/Users/jorgegarcia/Documents/GameStories/JobHunter.txt");
        this.fileReader = new Scanner(this.f);
        this.stories = new HashMap<String, StoryTree>();
        this.choices = new HashMap<String, Choice>();
        this.genStoryTree();
    }

    /**
     * Using the Scanner object this reads through each line of the text file,
     * identifying if the line represents a StoryNode, Choice, or Ending, and then
     * puts each into a HashMap with it's corresponded identifier.
     */
    private void importStory() {
        int index;
        String line;
        
        while(fileReader.hasNextLine()) {
            line = fileReader.nextLine();
            if (line.contains("#")) {
                index = line.indexOf('#');

                current = new StoryNode(line.substring(index + 2));
                stories.put(line.substring(0, index), current);
                this.storyTreeKeys.add(line.substring(0, index));
                line = fileReader.nextLine();

                index = line.indexOf('$');
                Choice choice1 = new Choice(line.substring(index + 2));
                this.choices.put(line.substring(0, index), choice1);
                line = fileReader.nextLine();

                Choice choice2 = new Choice(line.substring(index + 2));
                choices.put(line.substring(0, index), choice2);

                this.current.option1 = choice1;
                this.current.option2 = choice2;

            } else {
                index = line.indexOf('@');
                Ending ending = new Ending(line.substring(index + 2));
                this.stories.put(line.substring(0, index), ending);
                this.storyTreeKeys.add(line.substring(0, index));
            }
        }
    }

    /**
     * Using the newly generated story tree from the text file, this goes through the Choices HashMap
     * and links choices to their outcomes.
     */
    private void genStoryTree() {
        this.importStory();;
        Iterator choicesIter = choices.entrySet().iterator();
        while(choicesIter.hasNext()) {
            Map.Entry currentEntry = (Map.Entry) choicesIter.next();
            Choice currentChoice = (Choice) currentEntry.getValue();
            String id = (String) currentEntry.getKey();

            for(String treeId : this.storyTreeKeys) {
                if(treeId.equals("1")) {
                    this.initialNode = this. stories.get("1");
                }

                if(id.equals(treeId)) {
                    currentChoice.outcome = this.stories.get(treeId);
                }
            }
        }
    }
}
