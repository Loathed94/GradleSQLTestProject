/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {

    public static void main(String[] args){
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT Id, ContactName, ContactTitle FROM Customer");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.println("Customer "+resultSet.getString("Id")+ resultSet.getString("ContactName")+ resultSet.getString("ContactTitle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
*/