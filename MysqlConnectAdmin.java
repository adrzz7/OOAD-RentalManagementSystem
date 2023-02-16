
/**
 * MysqlConnect 
 * Cyberjaya Property Rental Management
 * Meyza Firzana Binti Ahmad Shabri
 * Admin
 */


import java.sql.*;
import javax.swing.*;

//Create class MySQLConnect
public class MysqlConnectAdmin{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public String username;
    
    //constructor
    public MysqlConnectAdmin()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalmanagement","root","");
            st=con.createStatement();
        }catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        
    }

    //login Data
    public void loginData(String username,String password){
        String query = "select * from admin where adminUsername='"+username+"' and adminPassword='"+password+"'";
        
        try{
        
            rs = st.executeQuery(query);
                  
                if(rs.next()){
                    //setUsername(uname);
                    //getUsername();
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
      
    //insertdata
    public void insertData(int propertyadminid, String ptype, String plocation, String psize, double prentrate, String pstatus, int pnoofroom, int pnoofbathroom, String pfacalities){
        String query;
        try{
            
            query="insert into property(propertyAdminID, propertyAgentID, propertyOwnerID, propertyType, propertyLocation, propertySize, propertyRentRate, propertyStatus, propertyNoOfRooms, propertyNoOfBathrooms, propertyFacilities) value ("+propertyadminid+",0 ,0,'"+ptype+"', '"+plocation+"', '"+psize+"', "+prentrate+", '"+pstatus+"', "+pnoofroom+", "+pnoofbathroom+", '"+pfacalities+"')";
            st.executeUpdate(query);
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
    }
  
    //find data
    public String[] findFilm(int id)
    {
        String query = "select propertyID, propertyAgentID, propertyType, propertyLocation, propertySize, propertyRentRate, propertyStatus, propertyNoOfRooms, propertyNoOfBathrooms, propertyFacilities from property where propertyID ="+id;
        String []row = new String[10];
        
        try{
            rs = st.executeQuery(query);
            if(rs.next()){
                row[0]=rs.getString("propertyID");
                row[1]=rs.getString("propertyAgentID");
                row[2]=rs.getString("propertyType");System.out.println(row[2]);
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
    
    //update data
   public void updateProperty(int propertyid,int propertyagentid, String ptype, String plocation, String psize, double prentrate, String pstatus, int pnoofroom, int pnoofbathroom, String pfacalities)
     {
        String query = "update property set propertyID ="+propertyid+", propertyAdminID = 0, propertyAgentID ="+propertyagentid+", propertyOwnerID = 0, propertyType='"+ptype+"', propertyLocation='"+plocation+"', propertyLocation='"+psize+"', propertyRentRate="+prentrate+", propertyStatus='"+pstatus+"', propertyNoOfRooms="+pnoofroom+", propertyNoOfBathrooms="+pnoofbathroom+", propertyFacilities='"+pfacalities+"' where propertyID="+propertyid;
        
        try{
        
            st.executeUpdate(query);
            
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error"+ex);
        }
        
    }
    public void RegisterUser ( String username, String password, String adminname, String adminphonenum, String adminemail ){
        
    String query;
        try {
            query = "Insert into admin ( adminUsername, adminPassword, adminName, adminPhoneNum, adminEmail) value  ('"+username+"','"+password+"','"+adminname+"','"+adminphonenum+"','"+adminemail+"')";
            st.executeUpdate(query);
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
    }
        public void CreateUserAccount ( String firstname, String lastname, String username,String password, String phonenum, String email, String roles ){
        
    String query;
        try {
            query = "Insert into admin ( firstname, lastname, username, password, PhoneNum, Email, Roles) value  ('"+firstname+"','"+lastname+"','"+username+"','"+password+"','"+phonenum+"','"+email+"','"+roles+"')";
            st.executeUpdate(query);
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
    }
        public void DeleteProperty2 ( int id ){
        
    String query;
       try {
          query = "Delete FROM property WHERE propertyID = "+id;
          st.executeUpdate(query);
        }catch(SQLException ex)
       {
         JOptionPane.showMessageDialog(null,"Error: "+ex);
       }
    }
    
    public static void main(String[] args) {
        MysqlConnectAdmin sqlC = new MysqlConnectAdmin();
        
    }
}