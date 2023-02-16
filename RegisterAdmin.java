/**
 * LoginAdmin 
 * Cyberjaya Property Rental Management
 * Meyza Firzana Binti Ahmad Shabri
 * Admin
 */


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*; 

//Class Register Admin
public class RegisterAdmin extends JPanel
{
    //Declare variable for Register Admin
    private static JLabel usernamelabel, passwordlabel,adminnamelabel,adminPhoneNum,adminEmail, success;
    private static JTextField usernametext;
    private static JTextField passwordtext;
    private static JTextField adminnametext;
    private static JTextField adminphonenumtext;
    private static JTextField adminemailtext;
    private static JButton Register;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    JPanel dataPanel, buttonPanel;
   
    
    public RegisterAdmin(){
        
       dataPanel = new JPanel();
       buttonPanel = new JPanel();
       
       //Display a label
       usernamelabel = new JLabel("Username");
       passwordlabel = new JLabel("Password");  
       adminnamelabel = new JLabel("Admin Name");
       adminPhoneNum = new JLabel("Admin Phone Number");
       adminEmail = new JLabel ("Email Admin");
       
       // Allows single line editing of the text
       usernametext = new JTextField(20);
       passwordtext = new JTextField(10);
       adminnametext = new JTextField(10);
       adminphonenumtext = new JTextField(10);
       adminemailtext = new JTextField(10);
       
       Register=new JButton("Register");;
       
       //adding listener
       Register.addActionListener(new buttonListener());
       
       dataPanel.setLayout(new GridLayout(5,1));
       dataPanel.add(usernamelabel);
       dataPanel.add(usernametext);
       
       dataPanel.add(passwordlabel);
       dataPanel.add(passwordtext);
       
       dataPanel.add(adminnamelabel);
       dataPanel.add(adminnametext);
       
       dataPanel.add(adminPhoneNum);
       dataPanel.add(adminphonenumtext);
       
       dataPanel.add(adminEmail);
       dataPanel.add(adminemailtext);
       
    
       buttonPanel.add(Register);
       
       add(dataPanel);
       add(buttonPanel);
       
       this.setPreferredSize(new Dimension(500,300));
       this.setVisible(true);
      
    }
    
    //button listener c;ass
    private class buttonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
       
        //Action Listener for Register Button
        if(e.getSource()==Register){
            String username = usernametext.getText();
            String password = passwordtext.getText();
            String adminname = adminnametext.getText();
            String adminphonenum = adminphonenumtext.getText();
            String adminemail = adminemailtext.getText();
        
            //Calling program SQL statement
            MysqlConnectAdmin sqlC = new MysqlConnectAdmin();
            sqlC.RegisterUser(username, password,adminname, adminphonenum, adminemail);
            }
        
    }
}

}
