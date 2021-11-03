package structs;


import java.util.HashMap;

public class Library {
    private HashMap<Integer, Book> bookMap;
    private HashMap<Integer, String> authorMap;
    private HashMap<Integer, Genre> genreMap;

    public Library(HashMap<Integer, Book> bookMap, HashMap<Integer, String> authorMap, HashMap<Integer, Genre> genreMap) {
        this.bookMap = bookMap;
        this.authorMap = authorMap;
        this.genreMap = genreMap;
    }
}
