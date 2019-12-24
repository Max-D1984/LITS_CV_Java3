import java.lang.annotation.Target;
import java.sql.*;


public class Max_SQL_Driver {
    private Connection conn;
    private Statement stm;
    private ResultSet resultSet;
    private DatabaseMetaData dbmd;
    private ResultSetMetaData rsmd;
    private String urlToBase;
    private String baseName;
    private String user;
    private String password;


    public Max_SQL_Driver(String urlToBase, String baseName, String user, String password) {
        this.urlToBase = urlToBase;
        this.baseName = baseName;
        this.user = user;
        this.password = password;
    }


    public boolean connectionToBase() {
        boolean connection;
        try {
            String connectionUrl = "jdbc:jtds:sqlserver://" + urlToBase + ";databaseName=" + baseName;
            conn = DriverManager.getConnection(connectionUrl, user, password);
            dbmd = conn.getMetaData();
            stm = conn.createStatement();
            return true;
            //           System.out.println("po -- " + dbmd);
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

    }

    public void getValuesFromColumn(String tableName, String columnName) {

        try  {
            resultSet = stm.executeQuery("Select " + columnName + " From " + tableName);
            rsmd = resultSet.getMetaData();
//            System.out.println(rsmd);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(columnName));
            }

            conn.close();
        } catch (SQLException ex) {

        }

    }

}
