package database.build;

import static database.build.DataClean.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import structs.Book;
import structs.BookTag;
import structs.GenreTag;

public class CSVData {
  public static Book[] parse(BookTag bookTag, String pathFromContentRoot)
      throws IOException, CsvValidationException {
    ArrayList<Book> booksList = new ArrayList<>();
    Book book;
    Reader reader = new BufferedReader(new FileReader(pathFromContentRoot));
    CSVReader csvReader = new CSVReader(reader);
    csvReader.readNext();

    String[] nextLine;
    while ((nextLine = csvReader.readNext()) != null) {
      String title = cleanString(nextLine[0]);
      String author = cleanString(nextLine[2]);
      String editionLanguage = cleanString(nextLine[3]);
      float ratingScore = cleanFloat(nextLine[4]);
      int ratingVotes = cleanInt(nextLine[5]);
      int reviewCount = cleanInt(nextLine[6]);
      String description = cleanString(nextLine[7]);
      Calendar yearPublished = cleanCalendar(nextLine[8]);
      GenreTag[] genreTags = cleanGenreTags(nextLine[9]);
      URL goodReadsLink = cleanURL(nextLine[10]);

      book =
          new Book(
              title,
              author,
              editionLanguage,
              description,
              ratingScore,
              ratingVotes,
              reviewCount,
              yearPublished,
              genreTags,
              goodReadsLink,
              bookTag);

      booksList.add(book);
    }

    Book[] booksArr = new Book[booksList.size()];
    for (int i = 0; i < booksList.size(); i++) {
      booksArr[i] = booksList.get(i);
    }

    return booksArr;
  }
}
