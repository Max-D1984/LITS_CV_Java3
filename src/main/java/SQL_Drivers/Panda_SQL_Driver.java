package SQL_Drivers;
import java.sql.*;
public class Panda_SQL_Driver {
    public static Connection connObj;
    public static String JDBC_URL =
            "jdbc:jtds:sqlserver://127.0.0.1:1433;" + "databaseName=Santa";
    Statement stmt = null;
    public void connectionToBase() {
        try {
            //Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connObj = DriverManager.getConnection(JDBC_URL, "sa", "sa");
            System.out.println("=" + connObj);
            DatabaseMetaData metaObj = (DatabaseMetaData) connObj.getMetaData();
//            System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " +
//                    metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() +
//                    ", Product Version?= " + metaObj.getDatabaseProductVersion());
            System.out.println(metaObj);
            stmt = connObj.createStatement();
            String sql = "select * from Presents;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String id = rs.getString("ID");
                System.out.println(id + " " + name);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("=" + connObj);
        }
    }
}