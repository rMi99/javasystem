package Utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Dewwa
 */
public class DatabaseConnection {

    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement pst = null;

    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:JKCSSDB.db");
            System.out.println("Database Connected..!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conn;
    }

}
