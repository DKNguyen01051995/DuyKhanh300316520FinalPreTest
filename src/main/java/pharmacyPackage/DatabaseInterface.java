package pharmacyPackage;



import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {

    public void add(Drug drug) throws ClassNotFoundException, SQLException;
    public Drug edit(Drug drug, String drugcode) throws ClassNotFoundException, SQLException;
    public void delete(String drugcode) throws SQLException;
    public List<Drug> display() throws ClassNotFoundException, SQLException;

}
