
/**
 * UPDATE PROPERTY
 * Cyberjaya Property Rental Management
 * Puteri Ainna Ezzurin Binti Mohd Reza
 * 1191200320
 * Agent
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdatePropertyAgent extends JPanel
{

  JLabel propertyIDLabel, propertyAgentIDLabel, propertySizeLabel, propertyTypeLabel, propertyLocationLabel,propertyRentRateLabel,propertyStatusLabel, propertyNoOfRoomsLabel, propertyNoOfBathroomLabel, propertyFacalitiesLabel  ;
   JTextField propertyIDText, propertyAgentIDText, propertySizeText, propertyTypeText, propertyLocationText, propertyRentRateText, propertyStatusText, propertyNoOfRoomsText,propertyNoOfBathroomText,  propertyFacalitiesText;
   JButton find, clear, update;
   //initialize property status for JCombobox
   String[] propertyTypes = {"Bungalow", "Semi-D", "Terrace", "Flat", "Condominium", "Apartment"};
   //initialize property type for JCombobox
   String[] propertyStatus = {"Active", "Inactive"}; 
   JComboBox propTypeDrop, propStatusDrop;
   JPanel dataPanel, buttonPanel;
   
   public UpdatePropertyAgent()
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
       find=new JButton("Find Property");
       clear=new JButton("Clear");
       update=new JButton("Update");
       
       //adding listener
       find.addActionListener(new buttonListener());
       clear.addActionListener(new buttonListener());
       update.addActionListener(new buttonListener());
       
       //add elements into datapanel
       dataPanel.setLayout(new GridLayout(10,2));
       dataPanel.add(propertyIDLabel);
       dataPanel.add(propertyIDText);
       
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
       buttonPanel.setLayout(new GridLayout(1,3));
       buttonPanel.add(find);
       buttonPanel.add(update);
       buttonPanel.add(clear);
       
       //add panels into frame
       add(dataPanel);
       add(buttonPanel);
       
       this.setPreferredSize(new Dimension(1000,300));
       this.setVisible(true);
   }
   
   
   //buttonListener class
   private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
           //if agent clicks on find properties button
           if(e.getSource()==find){
               //fetch the id that the user keyed in
               int id = Integer.parseInt(propertyIDText.getText());
               
               //create instance to MysqlConnect
               MysqlConnect sqlC = new MysqlConnect();
               //pass id to the findData method and store the returned data into an array
               String []data = sqlC.findData(id);
               
               //set the textfield to display the data in the array
               propertyIDText.setText(data[0]);
               propertyAgentIDText.setText(data[1]);
               propTypeDrop.setSelectedItem(data[2]);
               propertyLocationText.setText(data[3]);
               propertySizeText.setText(data[4]);
               propertyRentRateText.setText(data[5]);
               propStatusDrop.setSelectedItem(data[6]);
               propertyNoOfRoomsText.setText(data[7]);
               propertyNoOfBathroomText.setText(data[8]);
               propertyFacalitiesText.setText(data[9]);
            }
            
            //if agent clicks on update properties button
           if(e.getSource()==update){
               
               //fetch the data input
               int propertyid = Integer.parseInt(propertyIDText.getText());
               int agentid = Integer.parseInt(propertyAgentIDText.getText());
               String ptype = propTypeDrop.getSelectedItem().toString();
               String plocation = propertyLocationText.getText();
               String psize =  propertySizeText.getText();
               double prentrate = Double.parseDouble(propertyRentRateText.getText());
               String pstatus = propStatusDrop.getSelectedItem().toString();
               int pnoofroom = Integer.parseInt(propertyNoOfRoomsText.getText());
               int pnoofbathroom = Integer.parseInt(propertyNoOfBathroomText.getText());
               String pfacalities = propertyFacalitiesText.getText();
               
               //create instance to MysqlConnect
               MysqlConnect sqlC = new MysqlConnect();
               //pass data to the updateProperty method
               sqlC.updateProperty(propertyid, agentid, ptype, plocation, psize, prentrate, pstatus, pnoofroom, pnoofbathroom, pfacalities);
            
               
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
