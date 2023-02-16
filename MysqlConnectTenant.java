import java.sql.*;
import javax.swing.*;
import java.awt.*;


public class MysqlConnectTenant{
    //Variable
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public String username;
    
    
    //Constructor to connect Mysql
    public MysqlConnectTenant()
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
    
    
    
    
    /********************* Login Tenant ***********************/
    public void loginData(String username,String password){
        String query = "select * from tenantdata where username='"+username+"' and password='"+password+"'";
                      
        try{     
            rs = st.executeQuery(query);
            if(rs.next())
            {                                            
                    Mainpage page = new Mainpage();//Redirect to MainPage 
                    page.setSize(1000,500);
                    page.setVisible (true);
                    JOptionPane.showMessageDialog(null, " Login Succesfull.\n Welcome "+username+" !");       
            }
            else{
                JOptionPane.showMessageDialog(null,"Your username or password is incorrect. Register if you are a new Tenant.");
            }
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error" +ex);
        }
    }
 
    /********************* Register Tenant ***********************/
    public void insertData(String tusername, String tpassword, String tname, String temail, String tphone, String taddress){
        String query ="insert into tenantdata(username, password, name, email, phone, address) value ('"+tusername+"', '"+tpassword+"', '"+tname+"', '"+temail+"', '"+tphone+"', '"+taddress+"')";
        try{                  
            st.execute(query);                  
            JOptionPane.showMessageDialog(null, " Registration Succesfull.\n New Tenant:"+tusername+" !");
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
    }
    
    /********************* Find Tenant Profile ***********************/
    public String[] findFilm(String username)
    {
        String query = "select * from tenantdata where username = '"+username+"'";
        String []row = new String[7];
        
        try{
            rs = st.executeQuery(query);
            if(rs.next()){
                row[0]=rs.getString("ID");
                row[1]=rs.getString("username");
                row[2]=rs.getString("password");
                row[3]=rs.getString("name");
                row[4]=rs.getString("email");
                row[5]=rs.getString("phone");
                row[6]=rs.getString("address");
            }
            
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error"+ex);
        }
        
        return row;
    }
    
   /********************* Edit/Update Tenant Profile ***********************/
   public void updateProfile(String tusername, String tpassword, String tname, String temail, String tphone, String taddress)
     {
        String query;
               
        try{
            query = "update tenantdata set username='"+tusername+"', password='"+tpassword+"',name='"+tname+"',email='"+temail+"',phone='"+tphone+"',address='"+taddress+"' where username='"+tusername+"'";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Updated Tenant Profile");
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error Upadting Tenant Profile"+ex);
        }
        
    }
       
    public static void main(String[] args) {
        MysqlConnectTenant sqlC = new MysqlConnectTenant();
        
    }
}