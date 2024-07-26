
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        databaseConnection connect = new databaseConnection();
        Connection conn = connect.connectToDb("empdatabase", "postgres", "root");

        // List to store fetchers
        List<dbFetcher> fetchers = new ArrayList<>();
        String[] tableTobeFetched = {"employee", "department", "project"};

        for (String table : tableTobeFetched) {
            dbFetcher fetcher = new dbFetcher(table, conn);
            fetchers.add(fetcher);
            fetcher.start();
        }

        for (dbFetcher fetcher : fetchers) {
            try {
                fetcher.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (dbFetcher fetcher : fetchers) {
            System.out.println(fetcher.getData());
        }
    }
}
