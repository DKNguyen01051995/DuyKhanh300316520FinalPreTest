package pharmacyPackage;

import org.springframework.stereotype.Service;

import java.sql.DriverManager;
import java.sql.SQLException;

//this java class act as a connection between your webapp and the real Database you create on PHPMyadmin
@Service
public class Connection123 {

    public java.sql.Connection connect() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");

        java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/pharmacy", "root", "");

        return con1;
    }
}
