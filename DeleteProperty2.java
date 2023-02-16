
/**
 * DELETE PROPERTY
 * Cyberjaya Property Rental Management
 * Meyza Firzana Binti Ahmad Shabri
 * Admin
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//class Delete Property
public class DeleteProperty2 extends JPanel
{
    //Declare variable
   JLabel propertyIDLabel, propertyAdminIDLabel, propertySizeLabel, propertyTypeLabel, propertyLocationLabel,propertyRentRateLabel,propertyStatusLabel, propertyNoOfRoomsLabel, propertyNoOfBathroomLabel, propertyFacalitiesLabel  ;
   JTextField propertyIDText, propertyAdminIDText, propertySizeText, propertyTypeText, propertyLocationText, propertyRentRateText, propertyStatusText, propertyNoOfRoomsText,propertyNoOfBathroomText,  propertyFacalitiesText;
   JButton save, clear, close,find, delete;
   JPanel dataPanel, buttonPanel;
   
   //Declare Types and Status for Delete Property
   String[] propertyTypes = {"Bungalow", "Semi-D", "Terrace", "Flat", "Condominium", "Apartment"};
   String[] propertyStatus = {"Active", "Inactive"}; 
   JComboBox propTypeDrop, propStatusDrop;
   
   public DeleteProperty2()
   {
       dataPanel = new JPanel();
       buttonPanel = new JPanel();
       
       //Create Display Interface
       propertyIDLabel = new JLabel("Property ID");
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
       propertyIDText = new JTextField(10);
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
       find=new JButton("Find Property");
       delete=new JButton("Delete Property");
       clear=new JButton("Clear");
      // delete=new JButton("Delete Property");
       
       //adding button listener function
       find.addActionListener(new buttonListener());
       delete.addActionListener(new buttonListener());
       clear.addActionListener(new buttonListener());
       
       
       dataPanel.setLayout(new GridLayout(10,2));
       dataPanel.add(propertyIDLabel);
       dataPanel.add(propertyIDText);
       
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
       
       buttonPanel.setLayout(new GridLayout(1,3));
       buttonPanel.add(find);
       buttonPanel.add(delete);
       buttonPanel.add(clear);
      // buttonPanel.add(delete);
       
       add(dataPanel);
       add(buttonPanel);
       
       this.setPreferredSize(new Dimension(800,300));
       this.setVisible(true);
   }
   
   
   //buttonListener class
   private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
           if(e.getSource()==find){
               int id = Integer.parseInt(propertyIDText.getText());
               
               MysqlConnectAdmin sqlC = new MysqlConnectAdmin();
               String []data = sqlC.findFilm(id);
               
               propertyIDText.setText(data[0]);
               propertyAdminIDText.setText(data[1]);
               propTypeDrop.setSelectedItem(data[2]);
               propertyLocationText.setText(data[3]);
               propertySizeText.setText(data[4]);
               propertyRentRateText.setText(data[5]);
               propStatusDrop.setSelectedItem(data[6]);
               propertyNoOfRoomsText.setText(data[7]);
               propertyNoOfBathroomText.setText(data[8]);
               propertyFacalitiesText.setText(data[9]);
            }
           //Action Listener for save button
           if(e.getSource()==save){
               int propertyid = Integer.parseInt(propertyIDText.getText());
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
                int id = Integer.parseInt(propertyIDText.getText());
                MysqlConnectAdmin sqlC = new MysqlConnectAdmin();
                sqlC.DeleteProperty2(id); 
            } 
       }
   }
   
}
