import java.sql.*;

public class DataBaseConnection {

    public static void main(String args[]) throws SQLException {

        //jdbc:sqlserver://host:Port/databaseName
        String connectionUrl =
                "jdbc:sqlserver://10.0.1.145:1433;"
                        + "database=ritascoolnet_live;"
                        + "user=RitasAdmin;"
                        + "password=3vpLRchup$34;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select  Top 5 * from tblLoyaltyApp");

        while(rs.next()){

            System.out.println(rs.getString("Username"));


        }





    }


}
