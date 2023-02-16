
/**
 * ADD PROPERTY
 * Cyberjaya Property Rental Management
 * MEYZA FIRZANA BINTI AHMAD SHABRI
 * Admin
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//class Addproperty
public class AddPropertyAdmin extends JPanel
{
   //Declare variable
   JLabel propertyIDLabel, propertyAdminIDLabel, propertySizeLabel, propertyTypeLabel, propertyLocationLabel,propertyRentRateLabel,propertyStatusLabel, propertyNoOfRoomsLabel, propertyNoOfBathroomLabel, propertyFacalitiesLabel  ;
   JTextField propertyIDText, propertyAdminIDText, propertySizeText, propertyTypeText, propertyLocationText, propertyRentRateText, propertyStatusText, propertyNoOfRoomsText,propertyNoOfBathroomText,  propertyFacalitiesText;
   JButton save, clear, close, delete;
   JPanel dataPanel, buttonPanel;
   
   //Declare Types and Status
   String[] propertyTypes = {"Bungalow", "Semi-D", "Terrace", "Flat", "Condominium", "Apartment"};
   String[] propertyStatus = {"Active", "Inactive"}; 
   JComboBox propTypeDrop, propStatusDrop;
   
   public AddPropertyAdmin()
   {
       dataPanel = new JPanel();
       buttonPanel = new JPanel();
       
       //Create display interface
      // propertyIDLabel = new JLabel("Property ID");
       propertyAdminIDLabel = new JLabel("Admin ID");
       propertyTypeLabel = new JLabel("Type");
       propertyLocationLabel = new JLabel("Location");
       propertySizeLabel = new JLabel("Property Size");
       propertyRentRateLabel = new JLabel("Rent Rate");
       propertyStatusLabel = new JLabel("Status");
       propertyNoOfRoomsLabel = new JLabel("No Of Rooms");
       propertyNoOfBathroomLabel = new JLabel("No Of Bathrooms");
       propertyFacalitiesLabel = new JLabel("Facalities");
       
       //Create single line editing of the text
       //propertyIDText = new JTextField(10);
       propertyAdminIDText = new JTextField(10);
       propTypeDrop  = new JComboBox<>(propertyTypes);
       propertyLocationText = new JTextField(20);
       propertySizeText = new JTextField(10);
       propertyRentRateText = new JTextField(10);
       propStatusDrop= new JComboBox<>(propertyStatus);
       propertyNoOfRoomsText = new JTextField(10);
       propertyNoOfBathroomText = new JTextField(10);
       propertyFacalitiesText = new JTextField(30);
       
       //Create JButton
       save=new JButton("Add Property");
       clear=new JButton("Clear");
       delete=new JButton("Delete");
       
       //adding listener for action
       save.addActionListener(new buttonListener());
       clear.addActionListener(new buttonListener());
       delete.addActionListener(new buttonListener());
       
       dataPanel.setLayout(new GridLayout(9,2));
       //dataPanel.add(propertyIDLabel);
       //dataPanel.add(propertyIDText);
       
       dataPanel.add(propertyAdminIDLabel);
       dataPanel.add(propertyAdminIDText);
       
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
       
       buttonPanel.setLayout(new GridLayout(1,2));
       buttonPanel.add(save);
       buttonPanel.add(clear);
       buttonPanel.add(delete);
       
       add(dataPanel);
       add(buttonPanel);
       
       //Modified line code
       this.setPreferredSize(new Dimension(800,300));
       this.setVisible(true);
   }
   
   
   //buttonListener class
   private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
            //Action Listener for save button
           if(e.getSource()==save){
               int adminid = Integer.parseInt(propertyAdminIDText.getText());
               String ptype = propTypeDrop.getSelectedItem().toString();
               String plocation = propertyLocationText.getText();
               String psize =  propertySizeText.getText();
               double prentrate = Integer.parseInt(propertyRentRateText.getText());
               String pstatus = propStatusDrop.getSelectedItem().toString();
               int pnoofroom = Integer.parseInt(propertyNoOfRoomsText.getText());
               int pnoofbathroom = Integer.parseInt(propertyNoOfBathroomText.getText());
               String pfacalities = propertyFacalitiesText.getText();
               
               MysqlConnectAdmin sqlC = new MysqlConnectAdmin();
               sqlC.insertData( adminid, ptype, plocation, psize, prentrate, pstatus, pnoofroom, pnoofbathroom, pfacalities);
            }
            
            //Action Listener for clear button
            if(e.getSource()==clear){
               propertyIDText.setText("");
               propertyAdminIDText.setText("");
               propTypeDrop.setSelectedItem("");
               propertyLocationText.setText("");
               propertySizeText.setText("");
               propertyRentRateText.setText("");
               propStatusDrop.setSelectedItem("");
               propertyNoOfRoomsText.setText("");
               propertyNoOfBathroomText.setText("");
               propertyFacalitiesText.setText("");
            }
            
            //Action Listener for delete button
             if(e.getSource()==delete){
               propertyIDText.setText("");
               propertyAdminIDText.setText("");
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
