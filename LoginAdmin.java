/**
 * Login Admin 
 * Cyberjaya Property Rental Management
 * Meyza Firzana Binti Ahmad Shabri
 * Admin
 */


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*; 

//Create class LoginAdmin
public class LoginAdmin extends JPanel
{    
    //Declare variable
    private static JLabel usernamelabel, passwordlabel, success;
    private static JTextField usernametext;
    private static JPasswordField passwordtext;
    private static JButton login;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    JPanel dataPanel, buttonPanel;
   
    //Login admin function
    public LoginAdmin(){
        
       dataPanel = new JPanel();
       buttonPanel = new JPanel();
       
       usernamelabel = new JLabel("Username Admin");
       passwordlabel = new JLabel("Password");  
       
       usernametext = new JTextField(20);
       passwordtext = new JPasswordField(20);
       
       login=new JButton("Login Admin");;
       
       //adding listener
       login.addActionListener(new buttonListener());
       
       dataPanel.setLayout(new GridLayout(2,1));
       dataPanel.add(usernamelabel);
       dataPanel.add(usernametext);
       
       dataPanel.add(passwordlabel);
       dataPanel.add(passwordtext);
       
       buttonPanel.add(login);
       
       add(dataPanel);
       add(buttonPanel);
       
       this.setPreferredSize(new Dimension(500,300));
       this.setVisible(true);
      
    }
    
    //add ButtonListener to all buttons
    private class buttonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
       
        //Action Listener for Log in Admin
        if(e.getSource()==login){
            String username = usernametext.getText();
            String password = passwordtext.getText();
        
            MysqlConnectAdmin sqlC = new MysqlConnectAdmin();
            sqlC.loginData(username, password);
            }
        
    }
}
    //Main function
    public static void main(String[] args){
    new LoginAdmin();
}
}