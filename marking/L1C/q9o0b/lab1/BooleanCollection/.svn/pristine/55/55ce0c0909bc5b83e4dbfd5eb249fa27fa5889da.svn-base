package ca.ubc.cpsc210.booleancollection.main;

import java.util.Scanner;

/**
 * A basic question asker that asks questions and collections yes/no responses
 * using the console.
 */
public class QuestionAsker {
    private Scanner scanner;
    private int number;

    // EFFECTS: initialize the newly created question asker
    public QuestionAsker() {
        this.scanner = new Scanner(System.in);
        this.number = 0;
    }

    // EFFECTS: displays the question and waits for a yes or no answer.
    //          returns true if the answer was yes, false otherwise
    public boolean askQuestion(String question) {
        this.number++;
        while (true) {
            System.out.print(Integer.toString(this.number) + ") " +
                    question + " ");
            System.out.flush();
            String line;
            line = this.scanner.nextLine();
            line = line.trim();
            if (line.isEmpty())
                continue;
            char c = line.charAt(0);
            if (c == 'y' || c == 'Y')
                return true;
            else if (c == 'n' || c == 'N')
                return false;
        }
    }
}
