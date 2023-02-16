/**
 * CONNECTION
 * Cyberjaya Property Rental Management
 * Puteri Ainna Ezzurin Binti Mohd Reza
 * 1191200320
 * Agent
 */ 

import java.sql.*;
import javax.swing.*;

public class MysqlConnect{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    //constructor
    public MysqlConnect()
    {
        try{
            //connects to database(MySQL) 
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalmanagement","root","");
            st=con.createStatement();
        }catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        
    }

   /********************* Login Agent ***********************/
    public void loginData(String username,String password){
        
        //query fetch data from agent table and verify username and password
        String query = "select * from agent where agentUsername='"+username+"' and agentPassword='"+password+"'";
        
        try{
            //execute query
            rs = st.executeQuery(query);
                  
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, " Login Succesfull.\n Welcome "+username+" !");
                    HomePage page = new HomePage();  
                   
                    page.setVisible(true);  
                }else{  
                //show error message  
                JOptionPane.showMessageDialog(null, "Please enter valid username and password");
                    
            //}  
            }
        }catch(SQLException ex)
        {
             JOptionPane.showMessageDialog(null, "Error"+ex);
        }
    }
    
   /********************* Insert Property ***********************/
    public void insertData(int propertyagentid, String ptype, String plocation, String psize, double prentrate, String pstatus, int pnoofroom, int pnoofbathroom, String pfacalities){
        String query;
        try{
            //query to insert property details database
            query="insert into property(propertyAdminID, propertyAgentID, propertyOwnerID, propertyType, propertyLocation, propertySize, propertyRentRate, propertyStatus, propertyNoOfRooms, propertyNoOfBathrooms, propertyFacilities) value (0, "+propertyagentid+",0,'"+ptype+"', '"+plocation+"', '"+psize+"', "+prentrate+", '"+pstatus+"', "+pnoofroom+", "+pnoofbathroom+", '"+pfacalities+"')";
            st.executeUpdate(query);
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
    }
    
       /********************* Update Property ***********************/
   public void updateProperty(int propertyid,int propertyagentid, String ptype, String plocation, String psize, double prentrate, String pstatus, int pnoofroom, int pnoofbathroom, String pfacalities)
     {
         //query to update property data
        String query = "update property set propertyID ="+propertyid+", propertyAdminID = 0, propertyAgentID ="+propertyagentid+", propertyOwnerID = 0, propertyType='"+ptype+"', propertyLocation='"+plocation+"', propertySize='"+psize+"', propertyRentRate="+prentrate+", propertyStatus='"+pstatus+"', propertyNoOfRooms="+pnoofroom+", propertyNoOfBathrooms="+pnoofbathroom+", propertyFacilities='"+pfacalities+"' where propertyID="+propertyid;
        
        try{
        
            st.executeUpdate(query);
            
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error"+ex);
        }
        
    }
    
   
    /********************* Find Data ***********************/
    public String[] findData(int id)
    {
        String query = "select propertyID, propertyAgentID, propertyType, propertyLocation, propertySize, propertyRentRate, propertyStatus, propertyNoOfRooms, propertyNoOfBathrooms, propertyFacilities from property where propertyID ="+id;
        String []row = new String[10];
        
        try{
            rs = st.executeQuery(query);
            if(rs.next()){
                //get data and store in array
                row[0]=rs.getString("propertyID");
                row[1]=rs.getString("propertyAgentID");
                row[2]=rs.getString("propertyType");
                row[3]=rs.getString("propertyLocation");
                row[4]=rs.getString("propertySize");
                row[5]=rs.getString("propertyRentRate");
                row[6]=rs.getString("propertyStatus");
                row[7]=rs.getString("propertyNoOfRooms");
                row[8]=rs.getString("propertyNoOfBathrooms");
                row[9]=rs.getString("propertyFacilities");
            }
            
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error"+ex);
        }
        
        return row;
    }
    
    public static void main(String[] args) {
        MysqlConnect sqlC = new MysqlConnect();
        
    }
}