
/**
 * HOME PAGE
 * Cyberjaya Property Rental Management
 * Puteri Ainna Ezzurin Binti Mohd Reza
 * 1191200320
 * Agent
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame 
{
    JPanel buttonPanel, workspace;
    JButton addPropertybutton, viewPropertybutton, findPropertybutton, updatePropertybutton;
    
    //constructor
    public HomePage()
    {

        setLayout(new BorderLayout());
        setTitle("Home Page");
        
        //create JButton
        addPropertybutton = new JButton("Add Property");
        viewPropertybutton = new JButton("View Property");
        findPropertybutton = new JButton("Find Property");
        updatePropertybutton = new JButton("Update Property");
        
        //add actionListener to the JButton
        addPropertybutton.addActionListener(new buttonListener());
        viewPropertybutton.addActionListener(new buttonListener());
        findPropertybutton.addActionListener(new buttonListener());
        updatePropertybutton.addActionListener(new buttonListener());
        
        //create JPanel
        buttonPanel = new JPanel();
        workspace = new JPanel();
        
        //add the buttons into the panel
        buttonPanel.add(addPropertybutton);
        buttonPanel.add(viewPropertybutton);
        buttonPanel.add(findPropertybutton);
        buttonPanel.add(updatePropertybutton);
        buttonPanel.setLayout(new GridLayout(1,4));
        
        //arrange the JPanels
        add(buttonPanel, BorderLayout.NORTH);
        add(workspace, BorderLayout.CENTER);
        
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200,500));
        this.pack();
        this.setVisible(true);
    }
    
    //buttonListener class
   private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
            //if agent clicks on view properties button
           if(e.getSource()==viewPropertybutton)
           {
               setTitle("View Property");
               ViewProperty view = new ViewProperty(); //create instance
               //viewframe vf = new viewframe();
               workspace.removeAll(); //remove all old element in workspace panel
               workspace.add(view); //display the new panel
               workspace.repaint(); //update layout for the new panel
               workspace.revalidate(); //recalculate layout
           }
           
           //if agent clicks on add properties button
           if(e.getSource()==addPropertybutton)
           {
               setTitle("Add Property");
               AddProperty aproperty=new AddProperty(); //create instance
               workspace.removeAll(); //remove all old element in workspace panel
               workspace.add(aproperty); //display the new panel
               workspace.repaint(); //update layout for the new panel
               workspace.revalidate(); //recalculate layout
           }
           
           //if agent clicks on find properties button
           if(e.getSource()==findPropertybutton)
           {
               SearchProp searchproperty = new SearchProp();  //create instance
               workspace.removeAll(); //remove all old element in workspace panel
               workspace.add(searchproperty); //display the new panel
               workspace.repaint(); //update layout for the new panel
               workspace.revalidate(); //recalculate layout
           }
           
           //if agent clicks on update properties button
           if(e.getSource()==updatePropertybutton){
               UpdatePropertyAgent updateproperty=new UpdatePropertyAgent();  //create instance
               workspace.removeAll(); //remove all old element in workspace panel            
               workspace.add(updateproperty); //display the new panel
               workspace.repaint(); //update layout for the new panel
               workspace.revalidate(); //recalculate layout
           }
           
        
       }
   }
    
    public static void main(String args[])
    {
        new HomePage();
        
    }

}
