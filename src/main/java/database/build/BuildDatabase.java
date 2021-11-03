package database.build;

import static structs.BookTag.*;

import com.opencsv.exceptions.CsvValidationException;
import database.build.tables.ToTables;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import structs.Book;

public class BuildDatabase {
  public static void exec(Connection connection)
      throws IOException, CsvValidationException, SQLException {
    String pathFromContentRoot = "src/main/java/database/build/data/";
    Book[] aliens = CSVData.parse(Aliens, pathFromContentRoot + "sf_aliens.csv");

    /*
    CSVData.parse(AlternateHistory, pathFromContentRoot + "sf_alternate_history.csv");
    CSVData.parse(AlternateUniverse, pathFromContentRoot + "sf_alternate_universe.csv");
    CSVData.parse(Apocalyptic, pathFromContentRoot + "sf_apocalyptic.csv");
    CSVData.parse(Cyberpunk, pathFromContentRoot + "sf_cyberpunk.csv");
    CSVData.parse(Dystopia, pathFromContentRoot + "sf_dystopia.csv");
    CSVData.parse(Hard, pathFromContentRoot + "sf_hard.csv");
    CSVData.parse(Military, pathFromContentRoot + "sf_military.csv");
    CSVData.parse(Robots, pathFromContentRoot + "sf_robots.csv");
    CSVData.parse(SpaceOpera, pathFromContentRoot + "sf_space_opera.csv");
    CSVData.parse(Steampunk, pathFromContentRoot + "sf_steampunk.csv");
    CSVData.parse(TimeTravel, pathFromContentRoot + "sf_time_travel.csv");
     */

    for (Book book : aliens) {
      ToTables.exec(connection, book);
    }
  }
}
