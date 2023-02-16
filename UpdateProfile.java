/**
 * Update Tenant Profile
 * Cyberjaya Property Rental Management
 * Alison Wong Cheung Yung
 * Tenant
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UpdateProfile extends JPanel
{
   //Variables
   JLabel  usernameLabel, passwordLabel, nameLabel, emailLabel, phoneLabel, addressLabel, tenantIDLabel;
   JTextField usernameText, passwordText, nameText, emailText, phoneText, addressText, tenantIDText;
   JButton clear, update, find;
   
   JPanel dataPanel, buttonPanel;
   
   //UpdateProfile Function
   public UpdateProfile()
   {
       setLayout(new BorderLayout());      
       dataPanel = new JPanel();
       buttonPanel = new JPanel();
       //Declare naming for JLabel
       tenantIDLabel = new JLabel("Tenant ID");
       usernameLabel = new JLabel("Username");
       passwordLabel = new JLabel("Password");
       nameLabel = new JLabel("Name");
       emailLabel = new JLabel("Email");
       phoneLabel = new JLabel("Phone");
       addressLabel = new JLabel("Address");
       //Declare size for Textfield
       tenantIDText = new JTextField(10);
       usernameText = new JTextField(10);
       passwordText = new JTextField(20);
       nameText = new JTextField(50);
       emailText = new JTextField(50);
       phoneText = new JTextField(20);
       addressText = new JTextField(100);
       
       find=new JButton("Find Username");
       clear=new JButton("Clear");
       update=new JButton("Update");
       
       //Add Listener to the button
       find.addActionListener(new buttonListener());
       clear.addActionListener(new buttonListener());
       update.addActionListener(new buttonListener());
       //Layout for the Label and Text
       dataPanel.setLayout(new GridLayout(7,2));
       
       //Add Text and Label to Panel      
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
       
       
       //layout for Button in JPanel
       buttonPanel.setLayout(new GridLayout(1,3));
       buttonPanel.add(find);
       buttonPanel.add(update);
       buttonPanel.add(clear);
       
       add(dataPanel,BorderLayout.NORTH);
       add(buttonPanel);
       
       this.setPreferredSize(new Dimension(800,300));
       this.setVisible(true);
       this.setFocusable(false);
   }
   
   
   
   //buttonListener class
   private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       { 
           if(e.getSource()==find){
               //Find profile details base on Tenant Username
               String username = usernameText.getText();
               
               //Calling Subclass MsqlConnect
               MysqlConnectTenant sqlC = new MysqlConnectTenant();
               String []data = sqlC.findFilm(username);
               
               //Set text in textfield after Find function
               usernameText.setText(data[1]);
               passwordText.setText(data[2]);
               nameText.setText(data[3]);
               emailText.setText(data[4]);
               phoneText.setText(data[5]);
               addressText.setText(data[6]);
            }
            
           if(e.getSource()==update){
               //Update New Tenant Profile data
               String tusername = usernameText.getText();
               String tpassword = passwordText.getText();
               String tname = nameText.getText();
               String temail = emailText.getText();
               String tphone =  phoneText.getText();
               String taddress = addressText.getText(); 
               
               //Calling Subclass MysqlConnect
               MysqlConnectTenant sqlC = new MysqlConnectTenant();
               sqlC.updateProfile(tusername, tpassword, tname, temail, tphone, taddress);
            
               
            }
            //Clear content in TextField
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
