/* Add Properties for Owner
 * Cyberjaya Property Rental Management
 * Adriana Syaffiya binti Ahmad Khadri
 * 1191200471
 * Owner
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//create the main class for add properites
public class OwnerAddProp extends JPanel{
    //initialize button, panel, label, combo box and text field  
    JLabel title = new JLabel("Add Property");
    JLabel propIDLabel, propAdminLabel, propAgentLabel, propOwnerLabel, propTypeLabel, propLocationLabel, propSizeLabel, propStatusLabel, propRentRateLabel, propNoOfRoomLabel, propNoOfBRoomLabel, propFacilitiesLabel;  
    JTextField propIDText, propAdminText, propAgentText, propOwnerText, propTypeText, propLocationText, propSizeText, propStatusText, propRentRateText, propNoOfRoomText, propNoOfBRoomText, propFacilitiesText; 
    JComboBox propTypeDrop, propStatusDrop;
    //intialize property types
    String[] propertyTypes = {"Bungalow", "Semi-D", "Terrace", "Flat", "Condominium", "Apartment"};
    //intialize property status
    String[] propertyStatus = {"Active", "Inactive"}; 
    JButton save, clear, close;
    JPanel dataPanel, buttonPanel;
    
    //constructor
    public OwnerAddProp(){
        add(title); //add title
        dataPanel = new JPanel();   //create panel for panel's data
        buttonPanel = new JPanel(); //create panel  for buttons
        
        //create labels for properties details
        propIDLabel = new JLabel("Property ID");    
        propOwnerLabel = new JLabel("Owner ID");
        propTypeLabel = new JLabel("Property Type");
        propLocationLabel = new JLabel("Location");
        propSizeLabel = new JLabel("Property size");
        propStatusLabel = new JLabel("Status");
        propRentRateLabel = new JLabel("Rent rate");
        propNoOfRoomLabel = new JLabel("No. of rooms");
        propNoOfBRoomLabel = new JLabel("No. of Bathrooms");
        propFacilitiesLabel = new JLabel("Facilities");
        
        //create text field  and combo box for properties details
        propIDText = new JTextField(10);
        propOwnerText = new JTextField(10);
        propTypeDrop = new JComboBox<>(propertyTypes);
        propLocationText = new JTextField(20);
        propSizeText = new JTextField(20);
        propStatusDrop = new JComboBox<>(propertyStatus);
        propRentRateText = new JTextField(10);
        propNoOfRoomText = new JTextField(5);
        propNoOfBRoomText = new JTextField(5);
        propFacilitiesText = new JTextField(20);

        
        //create action buttons for adding property
        save = new JButton("Save Property");
        clear = new JButton("Clear");
        close = new JButton("Close");
        
        //listener for buttons
        save.addActionListener(new buttonListener());
        clear.addActionListener(new buttonListener());
        close.addActionListener(new buttonListener());
        
        //display all datas
        //set all to dataPanel
        dataPanel.setLayout(new GridLayout(11,2));  //grid for labels, text fields and buttons
        
        
        dataPanel.add(propOwnerLabel);
        dataPanel.add(propOwnerText);
        
        dataPanel.add(propTypeLabel);
       dataPanel.add(propTypeDrop);
        
        dataPanel.add(propLocationLabel);
        dataPanel.add(propLocationText);
        
        dataPanel.add(propSizeLabel);
        dataPanel.add(propSizeText);
                
        dataPanel.add(propRentRateLabel);
        dataPanel.add(propRentRateText);
        
        dataPanel.add(propStatusLabel);
       dataPanel.add(propStatusDrop);
        
        dataPanel.add(propNoOfRoomLabel);
        dataPanel.add(propNoOfRoomText);
        
        dataPanel.add(propNoOfBRoomLabel);
        dataPanel.add(propNoOfBRoomText);
        
        dataPanel.add(propFacilitiesLabel);
        dataPanel.add(propFacilitiesText);
        
        //display all buttons
        //set all to buttonPanel
        buttonPanel.setLayout(new GridLayout(1,3)); //grid for buttons
        buttonPanel.add(save);
        buttonPanel.add(clear);
        buttonPanel.add(close);
        add(buttonPanel, BorderLayout.SOUTH);   //position down
        
        add(dataPanel);     //display all datas
        add(buttonPanel);   //display all buttons
        
        this.setPreferredSize(new Dimension(500,500));  //set size of the frame 
        this.setVisible(true);  //make page visible to the owner 
    }
    
    //button Listener class
    //class implements ActionListener to perform an action on button click 
    private class buttonListener implements ActionListener{
        //define abstract method actionPerformed() which will be called on button click
        public void actionPerformed(ActionEvent e){
            //if owner clicks on save properties button
            if(e.getSource() == save){
                //get property details datas from text field and combo box
                int propAdmin=0;
                int propAgent=0;
                int propOwner = Integer.parseInt(propOwnerText.getText());
                String propType = propTypeDrop.getSelectedItem().toString();
                String propLocation = propLocationText.getText();
                String propSize = propSizeText.getText();
                double propRentRate = Double.parseDouble(propRentRateText.getText());
                String propStatus = propStatusDrop.getSelectedItem().toString();
                int propNoOfRoom = Integer.parseInt(propNoOfRoomText.getText());
                int propNoOfBRoom = Integer.parseInt(propNoOfBRoomText.getText());
                String propFacilities = propFacilitiesText.getText();
                
                MysqlConnectOwner sqlC = new MysqlConnectOwner();   //create instance called sqlC
                //call add property method add pass data
                sqlC.addPropOwner(propAdmin, propAgent, propOwner, propType, propLocation, propSize, propRentRate, propStatus, propNoOfRoom, propNoOfBRoom, propFacilities); //owner add property details
            }
            //if owner clicks on clear button
            if(e.getSource() == clear){
                //set all text to null/nothing
                propIDText.setText("");
                propAdminText.setText("");
                propAgentText.setText("");
                propOwnerText.setText("");
                propTypeDrop.setSelectedItem("");
                propLocationText.setText("");
                propSizeText.setText("");
                propStatusDrop.setSelectedItem("");
                propRentRateText.setText("");
                propNoOfRoomText.setText("");
                propNoOfBRoomText.setText("");
                propFacilitiesText.setText("");
            }
            //if owner clicks on close button
            if(e.getSource() == close){
                System.exit(0); //exit system
            }
        }
    }
    
 
}
