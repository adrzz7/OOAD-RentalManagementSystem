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

//Class Create user account
public class CreateUserAccount extends JPanel
{
    //Declare variable for Create user account
    private static JLabel firstnamelabel, lastnamelabel,usernamelabel,passwordlabel, phonenum,Email,Roles, success;
    private static JTextField firstnametext; //FirstName
    private static JTextField lastnametext; //LastName
    private static JTextField usernametext; //Username
    private static JTextField passwordtext; //Password
    private static JTextField phonenumtext; //Phone Num
    private static JTextField emailtext; //Email
    private static JTextField rolestext; //Roles
    private static JButton CreateUserAccount; 
    private Connection con;
    private Statement st;
    private ResultSet rs;
    JPanel dataPanel, buttonPanel;
   
    
    public CreateUserAccount(){
        
       dataPanel = new JPanel();
       buttonPanel = new JPanel();
       
       //Display a label
       firstnamelabel = new JLabel("First Name");
       lastnamelabel = new JLabel("Last Name");  
       usernamelabel = new JLabel("Username");
       passwordlabel = new JLabel("Password");
       phonenum = new JLabel("Phone Number");
       Email = new JLabel ("Email");
       Roles = new JLabel ("Roles");
       
       // Allows single line editing of the text
       firstnametext = new JTextField(20);
       lastnametext = new JTextField(10);
       usernametext = new JTextField(10);
       passwordtext = new JTextField(10);
       phonenumtext = new JTextField(10);
       emailtext = new JTextField(10);
       rolestext = new JTextField(10);

       CreateUserAccount=new JButton("Create User Account");;
       
       //adding listener
       CreateUserAccount.addActionListener(new buttonListener());
       
       dataPanel.setLayout(new GridLayout(7,2));
       dataPanel.add(firstnamelabel);
       dataPanel.add(firstnametext);
       
       dataPanel.add(lastnamelabel);
       dataPanel.add(lastnametext);
       
       dataPanel.add(usernamelabel);
       dataPanel.add(usernametext);
       
       dataPanel.add(passwordlabel);
       dataPanel.add(passwordtext);
       
       dataPanel.add(phonenum);
       dataPanel.add(phonenumtext);
       
       dataPanel.add(Email);
       dataPanel.add(emailtext);
       
       dataPanel.add(Roles);
       dataPanel.add(rolestext);
    
       buttonPanel.add(CreateUserAccount);
       
       add(dataPanel);
       add(buttonPanel);
       
       this.setPreferredSize(new Dimension(1500,1000));
       this.setVisible(true);
      
    }
    
    //button listener c;ass
    private class buttonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
       
        //Action Listener for CreateUserAccount Button
        if(e.getSource()==CreateUserAccount){
            String firstname= firstnametext.getText();
            String lastname = lastnametext.getText();
            String username = usernametext.getText();
            String password = passwordtext.getText();
            String phonenum = phonenumtext.getText();
            String email = emailtext.getText();
            String roles = rolestext.getText();
            
            //Calling program SQL statement
            MysqlConnectAdmin sqlC = new MysqlConnectAdmin();
            sqlC.CreateUserAccount(firstname,lastname, username, password,phonenum, email, roles);
            }
        
    }
}

}