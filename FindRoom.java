/**
 * Find Room
 * Cyberjaya Property Rental Management
 * Alison Wong Cheung Yung
 */

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

//create the main class for find property number of rooms
public class FindRoom extends JFrame 
{
    //initialize connection, statement and resultres
    private Connection con;
    private Statement st;
    private ResultSet rs;
    //initialize panel, button, and textarea
    JPanel buttonPanel, workspace;
    JButton addPropertybutton, viewPropertybutton, findPropertybutton, updatePropertybutton;
    JTextArea displayArea;
    
    //constructor
    public FindRoom(int findRoom)
    {

        displayArea = new JTextArea();  //create textarea for display area
        MysqlConnectOwner sqlC = new MysqlConnectOwner();   //create instance called sqlc 
        //displayArea.setText(sqlC.viewPropOwner());  //display view properties layout
        
        JFrame frame2;//creating object of second JFrame
        JTable table;//Creating object of JTable
        DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
        
        //setting the properties of second JFrame
        frame2 = new JFrame("Find Property Type");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(1200,500);

        
        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        table.setPreferredScrollableViewportSize(new Dimension(900, 500));
        defaultTableModel.addColumn("PropertyID");
        defaultTableModel.addColumn("PropertyType");
        defaultTableModel.addColumn("Location");
        defaultTableModel.addColumn("PropertySize(sq.ft)");
        defaultTableModel.addColumn("RentRate(RM)");
        defaultTableModel.addColumn("Status");
        defaultTableModel.addColumn("NoOfRooms");
        defaultTableModel.addColumn("NoOfBathrooms");
        defaultTableModel.addColumn("Facilitites");

        
        try{
            try{
                //connects to database(MySQL) 
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalmanagement","root","");
                st=con.createStatement();
            }catch(ClassNotFoundException | SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"Error: "+ex); //show error message if there is a problem with the code
            }
            String query = "select * from property where propertyNoOfRooms ="+findRoom+""; //select properties from database 
            ResultSet rs = st.executeQuery(query);
            
            int i=0;
        
            while (rs.next()) {
            
             //Retrieving details from the database and storing it in the String variables
                String PropertyID = rs.getString("propertyID");
                String PropertyType = rs.getString("propertyType");
                String Location = rs.getString("propertyLocation");
                String PropertySize = rs.getString("propertySize");
                String RentRate = rs.getString("propertyRentRate");
                String Status = rs.getString("propertyStatus");
                String NoOfRooms = rs.getString("propertyNoOfRooms");
                String NoOfBathrooms = rs.getString("propertyNoOfBathrooms");
                String Facilitites = rs.getString("propertyFacilities");
                 
                defaultTableModel.addRow(new Object[]{PropertyID, PropertyType, Location, PropertySize, RentRate, Status, NoOfRooms, NoOfBathrooms, Facilitites});//Adding row in Table
                frame2.setVisible(true);//Setting the visibility of second Frame
                frame2.validate();
                i++;
            }   
            
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }//executing query and storing result in ResultSet
        
        frame2.add(new JScrollPane(table));
    }
 
    

}
