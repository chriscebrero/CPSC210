package ca.ubc.cpsc210.booleancollection.main;

import ca.ubc.cpsc210.booleancollection.model.BooleanCollection;

/**
 * An essentially useless Main class, that just prints a boring message
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("This is not a very interesting message.");
        System.out.println(4 + 5);
        System.out.println(8 * 10);

        QuestionAsker QuestionAskerObject = new QuestionAsker();
        BooleanCollection BooleanCollectionObject = new BooleanCollection();

        BooleanCollectionObject.add (QuestionAskerObject.askQuestion("Do you like dog?"));
        BooleanCollectionObject.add (QuestionAskerObject.askQuestion("Do you like cat?"));
        BooleanCollectionObject.add (QuestionAskerObject.askQuestion("Do you like girl?"));
        BooleanCollectionObject.add (QuestionAskerObject.askQuestion("Do you like boy?"));

        if (BooleanCollectionObject.areAllTrue()) {
            System.out.println("Congratulations! All your answers are yes");
        } else
            {
            System.out.println(BooleanCollectionObject.countTrue());
        }

    }
}
