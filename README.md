# JobHunter

Text-based choose your own adventure game revolving around someone looking for a job.

# How it works

# Changelog
* ## Version 0.2.1
* Current method for reading a story from a text file and creating our data structure isn't good enough.
* Bugs so far:
  * Every path must have an ending or else we get a NullPointedException
  * Choices cannot lead to the same story node or else it messed up the order of stories
* Improvements to be made:
  * New way of formatting the text file and reading data

* ## Version 0.2
* Came up with a new format for reading from a text file.
  * Each line represents either a StoryNode, a Choice, or an Ending.
  * Each line has a number, followed by a symbol, followed by text.
    * \# = StoryNode, $ = Choice, @ = Ending
  * The number before a choice, corresponds to the outcome of that choice. ie. Choice 1 has the number 112, the outcome (or StoryNode) for that choice will have the number 112 before it aswell.
  * The intro to the story must have a 1# in front of it
  * The only order this needs to follow is that a StoryNode (#) needs to be followed by two choices.
* The StoryNode's, Choice's, and Ending's are then put into HashMaps corresponding with their numbers at the beginning of their line
* genStory() method links all the Choice's to their outcomes
* Game class now pulls the story it needs to run the game from the one genStory creates

* ## Version 0.1.1
* Builder class now exports the story that the user generates to a text file

* ## Version 0.1
* Created data stucture to represent a story.
* StoryTree interface can be one of a StoryNode or Ending
* StoryNode's have text, and two Choice's
* Choice's have text along with a StoryNode called "outcome"

* Introduced Builder class to make generating stories easier.
* Currently, prompts user for their intro text and the text for their first two choices. Then, the user is prompted to enter the text for the outcome of choice 1, followed by the choices for that outcome.
