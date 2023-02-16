/**
 * Login Tenant
 * Cyberjaya Property Rental Management
 * Alison Wong Cheung Yung
 * Tenant
 */

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*; 

public class LoginTenant extends JFrame 
{
    //Variable
    JLabel usernamelabel, passwordlabel, success;
    JTextField usernametext;
    JPasswordField passwordtext;
    JButton logBtn, regBtn;
    Connection con;
    Statement st;
    ResultSet rs;
    //Login Tenant Function
    public LoginTenant(){
        
        //Center the JFrame when running
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        JPanel panel = new JPanel();
        setTitle("Login Tenant");
        setSize(350,200);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(panel);
        
        panel.setLayout(null);
        //Declare JLabel username
        usernamelabel = new JLabel("Username");
        usernamelabel.setBounds(10,20,80,25);
        panel.add(usernamelabel);
        //Declare JTextField username
        usernametext = new JTextField(20);
        usernametext.setBounds(100,20,165,25);
        panel.add(usernametext);
        
        //Declare JLabel password
        passwordlabel = new JLabel("Password");
        passwordlabel.setBounds(10,50,80,25);
        panel.add(passwordlabel);
        //Declare JTextField username
        passwordtext = new JPasswordField(20);
        passwordtext.setBounds(100,50,165,25);
        panel.add(passwordtext);
        
        //Create Log in Button and add to layout
        logBtn = new JButton("Login");
        logBtn.setBounds(10,80,80,25);
        logBtn.addActionListener(new buttonListener());
        panel.add(logBtn);
        logBtn.setFocusable(false);
        
        //Create Register Button and add to layout
        regBtn = new JButton("Register");
        regBtn.setBounds(100,80,90,25);
        regBtn.addActionListener(new buttonListener());
        regBtn.setFocusable(false);
        panel.add(regBtn);
    
        
        setVisible(true);
    }
    
    
    //Add ButtonListener to all buttons
    public class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        //Register Tenant    
        if(e.getSource()==regBtn)
           {           
               RegisterTenant regtenant=new RegisterTenant();  
           }  
           
        //Log in Tenant   
        if(e.getSource()==logBtn){
            String username = usernametext.getText();
            String password = passwordtext.getText();
            
            //Calling Subclass MysqlConnect
            MysqlConnectTenant sqlC = new MysqlConnectTenant();
            sqlC.loginData(username, password);
            }
        
        }
    }
    //Main function
    public static void main(String[] args){
        new LoginTenant();
    }
}
