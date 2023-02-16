/**
 * AGENT LOGIN
 * Cyberjaya Property Rental Management
 * Puteri Ainna Ezzurin Binti Mohd Reza
 * 1191200320
 * Agent
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AgentLogin extends JFrame 
{
    private static JLabel usernamelabel, passwordlabel, success;
    private static JTextField usernametext;
    private static JPasswordField passwordtext;
    private static JButton login;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    JPanel dataPanel, buttonPanel;
    
    //constructor
    public AgentLogin()
    {

       setTitle("Find Type");
       setLayout(new BorderLayout());

       //JPanel
       dataPanel = new JPanel();
       buttonPanel = new JPanel();
       
       //JLabel
       usernamelabel = new JLabel("Username");
       passwordlabel = new JLabel("Password");  
       
       //JTextField
       usernametext = new JTextField(20);
       passwordtext = new JPasswordField(20);
       
       //JButton
       login=new JButton("Login");;
       
       //adding listener
       login.addActionListener(new buttonListener());
       
       //adding label, textfield and button into panel
       dataPanel.setLayout(new GridLayout(2,1));
       dataPanel.add(usernamelabel);
       dataPanel.add(usernametext);
       
       dataPanel.add(passwordlabel);
       dataPanel.add(passwordtext);
       
       buttonPanel.add(login);
       
       add(dataPanel,BorderLayout.NORTH);
       add(buttonPanel);
       
        this.setPreferredSize(new Dimension(300,200));
        this.pack();
        this.setVisible(true);
    }
 
    private class buttonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
       
        //if login button is clicked
        if(e.getSource()==login){
            //fetch data that user input
            String username = usernametext.getText();
            String password = passwordtext.getText();
        
            //create instance to connect to MysqlConnect class
            MysqlConnect sqlC = new MysqlConnect();
            //pass the data to loginData
            sqlC.loginData(username, password);
            }
        
    }
}

}
