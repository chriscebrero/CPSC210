package parser;


// An example of a simple JSON parser to parse a JSON file representing a library of books

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class LibraryParser {

    /**
     * Prints library parsed from JSON data to console
     * @param jsonData  string containing JSON data
     */
	public void parseLibrary(String jsonData) throws JSONException {
        JSONArray arrivals = new JSONArray(jsonData);

        for (int index = 0; index < arrivals.length(); index++) {
            JSONObject book = arrivals.getJSONObject(index);
            parseBook(book);
        }
    }

    /**
     * Prints book parsed from JSON object to console
     * @param book  a JSON object representing a book
     */
    private void parseBook(JSONObject book) throws JSONException {
        String title = book.getString("title");
        String author = book.getString("author");

        System.out.println("Parsed a book!");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println();
    }
}
