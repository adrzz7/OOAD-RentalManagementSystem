
/**
 * ADD PROPERTY
 * Cyberjaya Property Rental Management
 * Puteri Ainna Ezzurin Binti Mohd Reza
 * 1191200320
 * Agent
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddProperty extends JPanel
{
    
   JLabel propertyIDLabel, propertyAgentIDLabel, propertySizeLabel, propertyTypeLabel, propertyLocationLabel,propertyRentRateLabel,propertyStatusLabel, propertyNoOfRoomsLabel, propertyNoOfBathroomLabel, propertyFacalitiesLabel  ;
   JTextField propertyIDText, propertyAgentIDText, propertySizeText, propertyTypeText, propertyLocationText, propertyRentRateText, propertyStatusText, propertyNoOfRoomsText,propertyNoOfBathroomText,  propertyFacalitiesText;
   JButton save, clear, close;
   JPanel dataPanel, buttonPanel;
   //initialize property type for JCombobox
   String[] propertyTypes = {"Bungalow", "Semi-D", "Terrace", "Flat", "Condominium", "Apartment"};
   //initialize property status for JCombobox
   String[] propertyStatus = {"Active", "Inactive"}; 
   JComboBox propTypeDrop, propStatusDrop;
   
   //constructor
   public AddProperty()
   {
       //create JPanel
       dataPanel = new JPanel();
       buttonPanel = new JPanel();
       
       //create JLabel
       propertyIDLabel = new JLabel("Property ID");
       propertyAgentIDLabel = new JLabel("Agent ID");
       propertyTypeLabel = new JLabel("Type");
       propertyLocationLabel = new JLabel("Location");
       propertySizeLabel = new JLabel("Property Size");
       propertyRentRateLabel = new JLabel("Rent Rate");
       propertyStatusLabel = new JLabel("Status");
       propertyNoOfRoomsLabel = new JLabel("No Of Rooms");
       propertyNoOfBathroomLabel = new JLabel("No Of Bathrooms");
       propertyFacalitiesLabel = new JLabel("Facalities");
       
       //create JTextField
       propertyIDText = new JTextField(10);
       propertyAgentIDText = new JTextField(10);
       propTypeDrop  = new JComboBox<>(propertyTypes);
       propertyLocationText = new JTextField(20);
       propertySizeText = new JTextField(10);
       propertyRentRateText = new JTextField(10);
       propStatusDrop= new JComboBox<>(propertyStatus);
       propertyNoOfRoomsText = new JTextField(10);
       propertyNoOfBathroomText = new JTextField(10);
       propertyFacalitiesText = new JTextField(30);
       
       //create JButton
       save=new JButton("Add Property");
       clear=new JButton("Clear");
       
       //adding listener
       save.addActionListener(new buttonListener());
       clear.addActionListener(new buttonListener());
       
       //add elements into datapanel
       dataPanel.setLayout(new GridLayout(9,2));
       
       dataPanel.add(propertyAgentIDLabel);
       dataPanel.add(propertyAgentIDText);
       
       dataPanel.add(propertyTypeLabel);
       dataPanel.add(propTypeDrop);
       
       dataPanel.add(propertyLocationLabel);
       dataPanel.add(propertyLocationText);
       
       dataPanel.add(propertySizeLabel);
       dataPanel.add(propertySizeText);
       
       dataPanel.add(propertyRentRateLabel);
       dataPanel.add(propertyRentRateText);
       
       dataPanel.add(propertyStatusLabel);
       dataPanel.add(propStatusDrop);
       
       dataPanel.add(propertyNoOfRoomsLabel);
       dataPanel.add(propertyNoOfRoomsText);
       
       dataPanel.add(propertyNoOfBathroomLabel);
       dataPanel.add(propertyNoOfBathroomText);
       
       dataPanel.add(propertyFacalitiesLabel);
       dataPanel.add(propertyFacalitiesText);
       
       //add elements into buttonpanel
       buttonPanel.setLayout(new GridLayout(1,2));
       buttonPanel.add(save);
       buttonPanel.add(clear);
       
       //add panels into frame
       add(dataPanel);
       add(buttonPanel);
       
       this.setPreferredSize(new Dimension(800,300));
       this.setVisible(true);
   }
   
   
   //buttonListener class
   private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
           //if agent clicks on save properties button
           if(e.getSource()==save){
               //fetch the data input by agent
               int agentid = Integer.parseInt(propertyAgentIDText.getText());
               String ptype = propTypeDrop.getSelectedItem().toString();
               String plocation = propertyLocationText.getText();
               String psize =  propertySizeText.getText();
               double prentrate = Integer.parseInt(propertyRentRateText.getText());
               String pstatus = propStatusDrop.getSelectedItem().toString();
               int pnoofroom = Integer.parseInt(propertyNoOfRoomsText.getText());
               int pnoofbathroom = Integer.parseInt(propertyNoOfBathroomText.getText());
               String pfacalities = propertyFacalitiesText.getText();
               
               //create instance to MysqlConnect
               MysqlConnect sqlC = new MysqlConnect();
               //pass data to the insertData method
               sqlC.insertData(agentid, ptype, plocation, psize, prentrate, pstatus, pnoofroom, pnoofbathroom, pfacalities);
            }
            
            //if agent clicks on clear button
            if(e.getSource()==clear){
                //clears all the textfields
               propertyIDText.setText("");
               propertyAgentIDText.setText("");
               propTypeDrop.setSelectedItem("");
               propertyLocationText.setText("");
               propertySizeText.setText("");
               propertyRentRateText.setText("");
               propStatusDrop.setSelectedItem("");
               propertyNoOfRoomsText.setText("");
               propertyNoOfBathroomText.setText("");
               propertyFacalitiesText.setText("");
            }
       }
   }
   
}
