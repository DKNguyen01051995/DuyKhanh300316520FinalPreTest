package pharmacyPackage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Lab6. Step 12. Create a DatabaseService class that will implement the interface
public class DatabaseService implements DatabaseInterface{

    Connection con;

    public DatabaseService(Connection con) {this.con = con;}

    @Override
    public void add(Drug drug) throws ClassNotFoundException, SQLException {
        String quer1 = "INSERT INTO drug VALUES(?, ?, ?)"; // 3 symbol "?" here will be replaced by 3 attribute of drug table
        PreparedStatement query = con.prepareStatement(quer1);

        query.setString(1, drug.getDrugcode());
        query.setString(2, drug.getDrugname());
        query.setString(3, drug.getDrugdesc());

        query.executeUpdate();
    }

    @Override
    public Drug edit(Drug drug, String olddrugcode) throws ClassNotFoundException, SQLException {
        PreparedStatement query;
        query = con.prepareStatement("Update drug set drugcode=?, drugname=?, drugdesc=? where drugcode = ?");
        query.setString(1, drug.getDrugcode());
        query.setString(2, drug.getDrugname());
        query.setString(3, drug.getDrugdesc());
        query.setString(4, olddrugcode); //use the old Drugcode to set on the SQL query above. it is called old but it is not old, just the way to distinct between the drug get from ModelMap and the column name in the Drug Table


        query.executeUpdate();

        return drug;
    }

    @Override
    public void delete(String drugcode) throws SQLException {
        String quer1 = "Delete from drug where drugcode = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, drugcode);
        query.executeUpdate();
    }

//    Adding the Search method
    public Drug search(String drugcode) throws SQLException, ClassNotFoundException{
        String quer1 = "SELECT * FROM drug WHERE drugcode= ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, drugcode);

        ResultSet rs= query.executeQuery();

        if(!rs.first()){
            System.out.print("Record not existing");
            return null;
        }

        Drug obj1=null;

        obj1 = new Drug(rs.getString("drugcode"), rs.getString("drugname"), rs.getString("drugdesc"));

        return obj1;

    }

    @Override
    public List<Drug> display() throws ClassNotFoundException, SQLException {
        //create an array list that will contain the data recovered
        List<Drug> DrugList = new ArrayList<Drug>();

        String quer1 = "Select * from drug";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();

        Drug obj1;

        //display records if there is data

        while (rs.next()) {
            obj1 = new Drug(rs.getString("drugcode"), rs.getString("drugname"), rs.getString("drugdesc"));

            DrugList.add(obj1);
        }

        return DrugList;
    }


//  Create another display method named display2 for the drug table
    public List<Manufacture> display2(String drugcode) throws ClassNotFoundException, SQLException {
        //create an array list that will contain the data recovered
        List<Manufacture> ManufactureList = new ArrayList<Manufacture>();

        String quer1 = "Select manucode, manuname from manufacture where drugcode=?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, drugcode);
        ResultSet rs = query.executeQuery();

        Manufacture obj2;

        //display records if there is data;

        while (rs.next()) {

            obj2 = new Manufacture(rs.getString("manucode"),rs.getString("manuname"));

            ManufactureList.add(obj2);
        }

        return ManufactureList;
    }

}
