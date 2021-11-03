package app;

import com.opencsv.exceptions.CsvValidationException;
import database.build.BuildDatabase;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
  public static void main(String[] args)
      throws ClassNotFoundException, SQLException, IOException, CsvValidationException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/antheneum", "root", "@k8cX%w8aF");

    BuildDatabase.exec(connection);
  }
}
