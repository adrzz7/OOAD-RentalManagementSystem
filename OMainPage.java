/* Main Class for Owner
 * Cyberjaya Property Rental Management
 * Adriana Syaffiya binti Ahmad Khadri
 * 1191200471
 * Owner
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//create class for owner's main page
public class OMainPage extends JFrame{
    //initialize button, panel, label, and text field 
    JPanel buttonPanel, workSpace;
    JButton OwnerAddPropBtn, OwnerViewBtn, OwnerUpdateBtn, OwnerSearchBtn;
    
    //constructor
    public OMainPage() 
    {
        //create buttons for add, view, update and search properties        
        OwnerAddPropBtn = new JButton("Add Properties");
        OwnerViewBtn= new JButton("View Properties");
        OwnerUpdateBtn= new JButton("Update Properties");
        OwnerSearchBtn= new JButton("Search Property");
        
        //button listeners
        OwnerAddPropBtn.addActionListener(new buttonListener());
        OwnerViewBtn.addActionListener(new buttonListener());
        OwnerUpdateBtn.addActionListener(new buttonListener());
        OwnerSearchBtn.addActionListener(new buttonListener());
        
        //panels for buttons and other elements
        buttonPanel = new JPanel();
        workSpace = new JPanel();
        
        //create panels for navigation bar
        buttonPanel.add(OwnerAddPropBtn);
        buttonPanel.add(OwnerViewBtn);
        buttonPanel.add(OwnerUpdateBtn);
        buttonPanel.add(OwnerSearchBtn);
        buttonPanel.setLayout(new GridLayout(1,4));
        
        //set border to panels
        add(buttonPanel, BorderLayout.NORTH);
        add(workSpace, BorderLayout.CENTER);
  
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200,500)); //set size of the frame
        this.pack();                                //make content to preffered size
        this.setVisible(true);                      //make page visible to the owner 
        setTitle("Owner Page");                 //set titlefor owner's page
        
        
    }
    
    //button Listener class
    //class implements ActionListener to perform an action on button click 
    private class buttonListener implements ActionListener{
        //define abstract method actionPerformed() which will be called on button click
        public void actionPerformed(ActionEvent e){     //pass action listener as a parameter
            //if owner clicks on add properties button
            if(e.getSource() == OwnerAddPropBtn){
                OwnerAddProp addP = new OwnerAddProp(); //create instance called addP
                workSpace.removeAll();  //removes all elements
                workSpace.add(addP);    //display add properties interface
                workSpace.repaint();    //update layout
                workSpace.revalidate(); //recalculate layout
            }
            //if owner clicks on view properties button
            if(e.getSource() == OwnerViewBtn){
                OwnerViewProp viewP = new OwnerViewProp();  //create instance called viewP
                workSpace.removeAll();  //removes all elements
                workSpace.add(viewP);   //display view properties interface
                workSpace.repaint();    //update layout
                workSpace.revalidate(); //recalculate layout
            }
            //if owner clicks on add properties button
            if(e.getSource() == OwnerUpdateBtn){
                OwnerUpdateProp updtP = new OwnerUpdateProp();  //create instance called updtP
                workSpace.removeAll();  //removes all elements
                workSpace.add(updtP);   //display update properties interface
                workSpace.repaint();    //update layout
                workSpace.revalidate(); //recalculate layout
            }
            //if owner clicks on add properties button
            if(e.getSource() == OwnerSearchBtn){
                SearchProp searchproperty = new SearchProp();   //create instance called searchproperty
               workSpace.removeAll();           //removes all elements
               workSpace.add(searchproperty);   //display search properties interface
               workSpace.repaint();             //update layout
               workSpace.revalidate();          //recalculate layout
            }
        }
    }
    
    //main() method start  
    public static void main(String args[])
    {
        new OMainPage();
    }
}