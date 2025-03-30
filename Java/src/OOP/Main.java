package OOP;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "1234";
        try(Connection con = DriverManager.getConnection(url, username, password);) {
            // load driver
            Class.forName("org.postgresql.Driver");


            // create connection
//            System.out.println(con.isValid(4));
//
//             test select sql
//            String selectSql = "SELECT * FROM employee;";
//            Statement stm = con.createStatement();
//            ResultSet result = stm.executeQuery(selectSql);
//            while (result.next()){
//                System.out.println("ID : " + result.getInt("id"));
//                System.out.println("Name : " + result.getString(2));
//                System.out.println("Age : " + result.getInt("age"));
//                System.out.println("-".repeat(20));
//            }

            // test insert into database
//            String insertQuery = """
//                    INSERT INTO employee VALUES (40, 'Liza', 25),
//                                          (41, 'Many', 21);
//                    """;
//
//            Statement stm = con.createStatement();
//            int rowAffected = stm.executeUpdate(insertQuery);
//            System.out.println("Row affected is " + rowAffected);

            // test delete data from database
//            String deleteSql = "DELETE FROM employee WHERE id = 40;";
//            Statement stm = con.createStatement();
//            stm.executeUpdate(deleteSql);

            // test prepare statement with select
//            String selectSql = "SELECT * FROM employee WHERE id = ? or id = ?;";
//            PreparedStatement pstm = con.prepareStatement(selectSql);
//            pstm.setInt(1, 10);
//            pstm.setInt(2, 20);
//            ResultSet rs = pstm.executeQuery();
//            while (rs.next()){
//                System.out.println("ID : " + rs.getInt(1));
//                System.out.println("Name : " + rs.getString(2));
//                System.out.println("Age : " + rs.getInt("age"));
//                System.out.println("-".repeat(20));
//            }

            // test prepare statement with insert
//            String insertSql = """
//                    INSERT INTO employee VALUES (?, ?, ?);
//                    """;
//            PreparedStatement pstm = con.prepareStatement(insertSql);
//            pstm.setInt(1, 60);
//            pstm.setString(2, "Pisey");
//            pstm.setInt(3, 20);
//            pstm.executeUpdate();


            // test Callable
//            String call = "CALL insert_employee(?, ?, ?);";
//            CallableStatement cstm = con.prepareCall(call);
//            cstm.setInt(1, 90);
//            cstm.setString(2, "Makara");
//            cstm.setInt(3, 22);
//            cstm.executeUpdate();

            // test callable with function
            String call_function = "select delete_employee(10);";
            CallableStatement cstm = con.prepareCall(call_function);
            cstm.execute();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


