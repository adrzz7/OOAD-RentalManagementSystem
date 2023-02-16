/**
 * View Property
 * Cyberjaya Property Rental Management
 * Meyza Firzana Binti Ahmad Shabri
 * Admin
 */

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ViewPropertyAdmin extends JPanel
{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    //initialize label and text field
    JTextArea displayArea;
    JLabel title = new JLabel("View Property");
    public ViewPropertyAdmin()
    {
        displayArea = new JTextArea();  //create textarea for display area
        MysqlConnectOwner sqlC = new MysqlConnectOwner();   //create instance called sqlc 
        //displayArea.setText(sqlC.viewPropOwner());  //display view properties layout
        
        JFrame frame2;//creating object of second JFrame
        JTable table;//Creating object of JTable
        DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
        
        //setting the properties of second JFrame
        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(1200, 800);
        
        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(900, 900));
        table.setFillsViewportHeight(true);
        //frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("PropertyID");
        defaultTableModel.addColumn("PropertyType");
        defaultTableModel.addColumn("Location");
        defaultTableModel.addColumn("PropertySize (sq.ft)");
        defaultTableModel.addColumn("RentRate (RM)");
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
            String query = "select * from property"; //select properties from database 
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
        
                i++;
            }   
            
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }//executing query and storing result in ResultSet
        
        
        add(new JScrollPane(table));   //display view layout
        this.setPreferredSize(new Dimension(900,700)); //set size of the frame
        this.setVisible(true);  //make page visible to the owner
    }


}

