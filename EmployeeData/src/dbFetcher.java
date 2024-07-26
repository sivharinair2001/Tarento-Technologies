import java.sql.*;

public class dbFetcher extends Thread {
    private String tableName;
    private Connection connect;
    private StringBuilder data;

    public dbFetcher(String tableName, Connection connect) {
        this.connect = connect;
        this.tableName = tableName;
        this.data = new StringBuilder();
    }

    @Override
    public void run() {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from " + tableName);
            data.append("Data from ").append(tableName).append("\n");
            appendTableData(resultSet, tableName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void appendTableData(ResultSet resultSet, String tableName) throws SQLException {
        switch (tableName) {
            case "employee":
                data.append("emp_id\tname\tposition\n");
                while (resultSet.next()) {
                    data.append(resultSet.getInt("emp_id")).append("\t\t")
                            .append(resultSet.getString("name")).append("\t")
                            .append(resultSet.getString("position")).append("\n");
                }
                break;
            case "department":
                data.append("dep_id\tdept_name\n");
                while (resultSet.next()) {
                    data.append(resultSet.getInt("dep_id")).append("\t\t")
                            .append(resultSet.getString("dept_name")).append("\n");
                }
                break;
            case "project":
                data.append("project_id\tproject_name\tproject_location\n");
                while (resultSet.next()) {
                    data.append(resultSet.getInt("project_id")).append("\t\t")
                            .append(resultSet.getString("project_name")).append("\t\t\t\t")
                            .append(resultSet.getString("project_location")).append("\n");
                }
                break;
            default:
                data.append("No such table found.\n");
                break;
        }
    }

    public String getData() {
        return data.toString();
    }
}
