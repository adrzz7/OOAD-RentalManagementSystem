/**
 * SEARCH PROPERTY
 * Cyberjaya Property Rental Management
 * Puteri Ainna Ezzurin Binti Mohd Reza
 * 1191200320
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchProp extends JPanel
{

   JLabel empty, propertyTypeLabel,propertyStatusLabel, propertyNoOfRoomsLabel, propertyPriceRangeMinLabel,propertyPriceRangeMaxLabel, propertyPriceSortLabel  ;
   JTextField propertyTypeText, propertyNoOfRoomsText,propertyPriceMaxText,  propertyPriceMinText;
   JButton viewall, findType, findStatus, findRoom, findRange, findSort;
   JPanel dataPanel, buttonPanel;
   JComboBox propTypeDrop, propStatusDrop, propPriceSortDrop;
   JLabel title = new JLabel("Search Property");
   //initialize property type for JCombobox
   String[] propertyTypes = {"Bungalow", "Semi-D", "Terrace", "Flat", "Condominium", "Apartment"};
   //initialize property status for JCombobox
   String[] propertyStatus = {"Active", "Inactive"}; 
   //initialize property price for JCombobox
   String[] pricesort = {"High To Low", "Low To High"}; 
   
   public SearchProp()
   {
       //create JPanel
       dataPanel = new JPanel();
       buttonPanel = new JPanel();
       
       //create JLabel
       propertyTypeLabel = new JLabel("Type");
       propertyStatusLabel = new JLabel("Status");
       propertyNoOfRoomsLabel = new JLabel("No Of Rooms");
       propertyPriceRangeMinLabel = new JLabel("Price Range Min");
       propertyPriceRangeMaxLabel = new JLabel("Price Range Max");
       propertyPriceSortLabel = new JLabel("Price Sorting");
       empty = new JLabel("");
    
       //create JComboBox
       propTypeDrop  = new JComboBox<>(propertyTypes);
       propStatusDrop= new JComboBox<>(propertyStatus);
       //create JTextField
       propertyNoOfRoomsText = new JTextField(10);
       propertyPriceMaxText = new JTextField(10);
       propertyPriceMinText = new JTextField(10);
       propPriceSortDrop= new JComboBox<>(pricesort);
       
       //create JButton
       findType=new JButton("Find Type");
       findStatus=new JButton("Find Status");
       findRoom=new JButton("Find Rooms");
       findRange=new JButton("Find Range");
       findSort=new JButton("Sort");
       viewall=new JButton("View All Property");
       
       //adding listener
       findType.addActionListener(new buttonListener());
       findStatus.addActionListener(new buttonListener());
       findRoom.addActionListener(new buttonListener());
       findRange.addActionListener(new buttonListener());
       findSort.addActionListener(new buttonListener());
       viewall.addActionListener(new buttonListener());
       
       //set Layout
       dataPanel.setLayout(new GridLayout(6,3));
       
       //adding elements into panel
       dataPanel.add(propertyTypeLabel);
       dataPanel.add(propTypeDrop);
       dataPanel.add(findType);
       
       
       dataPanel.add(propertyStatusLabel);
       dataPanel.add(propStatusDrop);
       dataPanel.add(findStatus);
       
       dataPanel.add(propertyNoOfRoomsLabel);
       dataPanel.add(propertyNoOfRoomsText);
       dataPanel.add(findRoom);
       
       dataPanel.add(propertyPriceSortLabel);
       dataPanel.add(propPriceSortDrop);
       dataPanel.add(findSort);
       
       dataPanel.add(propertyPriceRangeMinLabel);
       dataPanel.add(propertyPriceMinText);
       dataPanel.add(empty);
       dataPanel.add(propertyPriceRangeMaxLabel);
       dataPanel.add(propertyPriceMaxText);
       dataPanel.add(findRange);
       
       //add button into panel
       buttonPanel.setLayout(new GridLayout(1,1));
       buttonPanel.add(viewall);
       
       
       add(title,BorderLayout.NORTH); //add title
       add(dataPanel);
       add(buttonPanel);
       
       this.setPreferredSize(new Dimension(400,500));
       this.setVisible(true);
   }
   
   
   //buttonListener class
   private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
           //if user click on find property base on type
           if(e.getSource()==findType){
               //get the data input by user
               String findType = propTypeDrop.getSelectedItem().toString();
               
               MysqlConnect sqlC = new MysqlConnect();
               //pass the data to FindType class
               FindType ftype = new FindType(findType);
               
            }
            
            //if user click on find property base on status
            if(e.getSource()==findStatus){
                //get the data input by user
               String findStatus = propStatusDrop.getSelectedItem().toString();
               
               MysqlConnect sqlC = new MysqlConnect();
               //pass the data to FindStatus class
               FindStatus fstatus = new FindStatus(findStatus);
               
            }
            
            //if user click on find property base on number of room
            if(e.getSource()==findRoom){
                //get the data input by user
               int findRoom = Integer.parseInt(propertyNoOfRoomsText.getText());
               
               MysqlConnect sqlC = new MysqlConnect();
               //pass the data to FindRoom class
               FindRoom fstatus = new FindRoom(findRoom);
               
            }
            
            //if user click on find property and want to sort it according to price
            if(e.getSource()==findSort){
                //get the data input by user
               String findSort = propPriceSortDrop.getSelectedItem().toString();
               
               MysqlConnect sqlC = new MysqlConnect();
               //pass the data to Sort class
               Sort fsort = new Sort(findSort);
               
            }
            
            //if user click on find property and wanted to display property between the price range
            if(e.getSource()==findRange){
                //get the data input by user
               int pricemax = Integer.parseInt(propertyPriceMaxText.getText());
               int pricemin = Integer.parseInt(propertyPriceMinText.getText());
               
               MysqlConnect sqlC = new MysqlConnect();
               //pass the data to FindRange class
               FindRange frange = new FindRange(pricemax, pricemin);
               
            }
            
            //if user click on view all property button
            if(e.getSource()==viewall){
                MysqlConnect sqlC = new MysqlConnect();
                //create instance to ViewAll class
               ViewAll view = new ViewAll();
               
            }
            
            
       }
   }
   
}