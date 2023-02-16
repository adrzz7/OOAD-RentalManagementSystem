/**
 * Register Tenant 
 * Cyberjaya Property Rental Management
 * Alison Wong Cheung Yung
 * Tenant
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterTenant extends JFrame 
{
    //Variable
   JLabel usernameLabel, passwordLabel, nameLabel, emailLabel, phoneLabel,addressLabel;
   JTextField usernameText, passwordText, nameText, emailText, phoneText, addressText;
   JButton save, clear, close;
   JPanel dataPanel, buttonPanel;
    //RegisterTenant Function  
   public RegisterTenant()
   {
       //Center the JFrame when running
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
       
       
       
        setLayout(new BorderLayout());
        setTitle("Register Tenant");
        
        
       dataPanel = new JPanel();
       buttonPanel = new JPanel();
       
       //Declare JLabel
       usernameLabel = new JLabel("Username");
       passwordLabel = new JLabel("Password");
       nameLabel = new JLabel("Name");
       emailLabel = new JLabel("Email");
       phoneLabel = new JLabel("Phone Number");
       addressLabel = new JLabel("Address");
       //Declare TextField
       usernameText = new JTextField(10);
       passwordText = new JTextField(30);
       nameText = new JTextField(50);
       emailText = new JTextField(50);
       phoneText = new JTextField(20);
       addressText = new JTextField(100);
       
       save=new JButton("Register");
       clear=new JButton("Clear");
       
       //Add listener to the button
       save.addActionListener(new buttonListener());
       clear.addActionListener(new buttonListener());
       
       //Display layout for Label and Text
       dataPanel.setLayout(new GridLayout(6,2));
    
       dataPanel.add(usernameLabel);
       dataPanel.add(usernameText);
       
       dataPanel.add(passwordLabel);
       dataPanel.add(passwordText);
       
       dataPanel.add(nameLabel);
       dataPanel.add(nameText);
       
       dataPanel.add(emailLabel);
       dataPanel.add(emailText);
       
       dataPanel.add(phoneLabel);
       dataPanel.add(phoneText);
       
       dataPanel.add(addressLabel);
       dataPanel.add(addressText);
       
       //Display and add button to layout
       buttonPanel.setLayout(new GridLayout(1,2));
       buttonPanel.add(save);
       buttonPanel.add(clear);
       
       add(dataPanel,BorderLayout.NORTH);
       add(buttonPanel);
       
        this.dispose(); //To Close only Register JFrame
        this.setPreferredSize(new Dimension(800,300));
        this.setVisible(true);
        this.pack();
   }
   
   
   //Class buttonListener action for the button
   private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
           //Save data input by user to Database
           if(e.getSource()==save){            
               String tusername = usernameText.getText();
               String tpassword = passwordText.getText();
               String tname =  nameText.getText();               
               String temail = emailText.getText();
               String tphone = phoneText.getText();
               String taddress = addressText.getText();
               
               //Calling Subclass MysqlConnect          
               MysqlConnectTenant sqlC = new MysqlConnectTenant();
               sqlC.insertData(tusername, tpassword, tname, temail, tphone, taddress);
               
            }
            
            //Clear all the text in the TextField
            if(e.getSource()==clear){
               usernameText.setText("");
               passwordText.setText("");
               nameText.setText("");
               emailText.setText("");
               phoneText.setText("");
               addressText.setText("");              
            }
       }
   }
   
}
