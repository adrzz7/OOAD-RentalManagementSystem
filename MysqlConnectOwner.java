 /* connection class
 * Cyberjaya Property Rental Management
 * Adriana Syaffiya binti Ahmad Khadri
 * 1191200471
 * Owner
 */
import java.sql.*;
import javax.swing.*;

public class MysqlConnectOwner{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    
    //constructor
    public MysqlConnectOwner(){
        try{
            //connects to database(MySQL) 
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalmanagement","root","");
            st=con.createStatement();
        }catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: "+ex); //show error message if there is a problem with the code
        }
        
    }
    
    
    
    /********************* add property owner***********************/
    public void addPropOwner(int propAdmin, int propAgent, int propOwner, String propType, String propLocation, String propSize, double propRentRate, String propStatus, int propNoOfRoom, int propNoOfBRoom, String propFacilities){
        String query;
        try{
            //query to insert property details into rental management database
            query="insert into property(propertyID, propertyAdminID , propertyAgentID , propertyOwnerID, propertyType, propertyLocation, propertySize, propertyRentRate, propertyStatus, propertyNoOfRooms, propertyNoOfBathrooms, propertyFacilities) value (0,0,0,'"+propOwner+"', '"+propType+"','"+propLocation+"','"+propSize+"',"+propRentRate+", '"+propStatus+"',"+propNoOfRoom+", "+propNoOfBRoom+",'"+propFacilities+"')";
            st.executeUpdate(query);
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: "+ex); //show error message if there is a problem with the code
        }
    }
    
    /********************* search property by id  for update owner ***********************/
    //search by using property ID
    public String[] searchPropOwner(int propID){
        //display the property details
        //head of table
        String text = "PropertyID\tOwnerID\tpropertyType\tLocation\t\tpropertySize\tRentRate\tStatus\tNoOfRooms\tNoOfBathrooms  Facilitites\n";
        String []row = new String[12]; //string for all properties (12)
        String query = "select * from property where propertyID=" +propID; //search property by using id
        
        try{
            rs = st.executeQuery(query);
            if(rs.next()){   //get data
                row[0] = rs.getString("propertyID");
                row[1] = rs.getString("propertyAdminID");
                row[2] = rs.getString("propertyAgentID");
                row[3] = rs.getString("propertyOwnerID");
                row[4] = rs.getString("propertyType");
                row[5] = rs.getString("propertyLocation");
                row[6] = rs.getString("propertySize");
                row[7] = rs.getString("propertyRentRate");
                row[8] = rs.getString("propertyStatus");
                row[9] = rs.getString("propertyNoOfRooms");
                row[10] = rs.getString("propertyNoOfBathrooms");
                row[11] = rs.getString("propertyFacilities");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex); //show error message if there is a problem with the code
        }
        
        return row;
    }
    
    
    /********************* update property owner ***********************/
    //updatePropertyOwner
    //parameter to get data from owner update prop
    public void updatePropertyOwner(int propID, int propAdmin, int propAgent, int propOwner, String propType, String propLocation, String propSize, double propRentRate, String propStatus, int propNoOfRoom, int propNoOfBRoom, String propFacilities){
        //query to update properties in the database  
        String query="update property set propertyID="+propID+",propertyAdminID="+propAdmin+",propertyAgentID="+propAgent+",propertyOwnerID="+propOwner+",propertyType='"+propType+"',propertyLocation='"+propLocation+"',propertySize='"+propSize+"',propertyRentRate="+propRentRate+",propertyStatus='"+propStatus+"',propertyNoOfRooms="+propNoOfRoom+",propertyNoOfBathrooms="+propNoOfBRoom+",propertyFacilities='"+propFacilities+"' where propertyID="+propID;
        
        try{
            st.executeUpdate(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex); //show error message if there is a problem with the code
        }
    }
    
    
    
    public static void main(String[] args) {
        MysqlConnectOwner sqlC = new MysqlConnectOwner();
    }
}