package SQL_Drivers;

import java.sql.*;
public class Oleh_SQL_Driver {
    public static Connection connObj;
    public static String JDBC_URL =
            "jdbc:jtds:sqlserver://localhost:1433;" +
                    "databaseName=SantaBase";
    public static void getDbConnection() {
        Statement stmt ;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connObj = DriverManager.getConnection(JDBC_URL,"sa","sa");
            if(connObj != null) {
                DatabaseMetaData metaObj = connObj.getMetaData();
                System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " + metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() + ", Product Version?= " + metaObj.getDatabaseProductVersion());
            }
            stmt = connObj.createStatement();
            String sql = "select * from rules;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String c_id = rs.getString("company_id");
                String s_date = rs.getString("start_date");
                String e_date = rs.getString("end_date");
                String g_date = rs.getString("gift_date");
                int g_price = rs.getInt("gift_price");
                System.out.println(c_id + " " + s_date + " " + e_date + " " + g_date + " " + g_price);
            }
        } catch(Exception sqlException) {
            System.out.println("шо то пошло не так");
        }
    }
    public static void main(String[] args) {
        getDbConnection();
    }
}
