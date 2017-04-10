package assignment10;

import java.util.Scanner;

/**
 * A class to count the number of characters, words, and lines in files.
 */
public class FileCounter {
    private int wordCount;
    private int lineCount;
    private int characterCount;

    /**
     * Constructs a FileCounter object.
     */
    public FileCounter() {
        this.wordCount = 0;
        this.lineCount = 0;
        this.characterCount = 0;
    }

    /**
     * Processes an input source and adds its character, word, and line
     * counts to this counter.
     *
     * @param in the scanner to process
     */
    public void read(Scanner in) {
        while (in.hasNextLine()) {
            lineCount++;
            String oneLineStr = in.nextLine();
            characterCount += oneLineStr.length();
            String[] wordStr = oneLineStr.split(" ");
            wordCount += wordStr.length;
        }
    }

    /**
     * Gets the number of words in this counter.
     *
     * @return the number of words
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * Gets the number of lines in this counter.
     *
     * @return the number of lines
     */
    public int getLineCount() {
        return lineCount;
    }

    /**
     * Gets the number of characters in this counter.
     *
     * @return the number of characters
     */
    public int getCharacterCount() {
        return characterCount;
    }

}
