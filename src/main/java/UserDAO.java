import java.sql.*;

public class UserDAO {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123123");
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("select * from user")

        ) {
            Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "123123");
            Statement statement1 = connection2.createStatement();
            // int userOne = statement.executeUpdate("insert into user values('John', 'Smith', 30)");
            // int userTwo = statement.executeUpdate("insert into user values('Mary', 'Brown', 30)");
            // int userThree = statement.executeUpdate("insert into user values('James', 'Bond', 30)");
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }


    }



    }




