import java.sql.*;

public class JDBC_Demo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*
        JDBC Steps:
            import packages
            load driver
            register driver
            create connection
            create statement
            execute statement
            process the data
            close connection
        */

        int sid = 102;
        String sname = "Anvir";
        int smarks = 51;

        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "12345";

        String read = "SELECT * FROM student";
        String create = "INSERT INTO student VALUES (?, ?, ?)";
        String update = "UPDATE student SET marks = 100 WHERE sid = 1";
        String delete = "DELETE FROM student WHERE sid = 5";

        // load and register driver (optional because it's already loaded in modern java)
        Class.forName("org.postgresql.Driver");

        // create connection
        Connection connection = DriverManager.getConnection(url, username, password);

        // create statement
//        Statement statement = connection.createStatement();

        PreparedStatement pst = connection.prepareStatement(create);
        pst.setInt(1, sid);
        pst.setString(2, sname);
        pst.setInt(3, smarks);

        // execute statement
//        boolean created = statement.execute(create);
//        boolean updated = statement.execute(update);
//        boolean deleted = statement.execute(delete);
//        ResultSet resultSet = statement.executeQuery(read);
        pst.execute();
        // process the data
//        while (resultSet.next()) {
//            int id = resultSet.getInt("sid");
//            String name = resultSet.getString("sname");
//            int marks = resultSet.getInt("marks");
//
//            System.out.println(id + " " + name + " " + marks);
//        }

        // close connection
        connection.close();

    }
}
