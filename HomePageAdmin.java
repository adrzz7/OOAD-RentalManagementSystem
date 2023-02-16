/**
 * HomePage
 * Cyberjaya Property Rental Management
 * Meyza Firzana Binti Ahmad Shabri
 * Admin
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Create HomePage 
public class HomePageAdmin extends JFrame 
{
    //Do declaration
    JPanel buttonPanel, workspace;
    JButton addPropertybutton, viewPropertybutton, findPropertybutton, updatePropertybutton, deletePropertybutton;
    
    public HomePageAdmin()
    {
        //Constructor creating new border layout
        setLayout(new BorderLayout());
        setTitle("Home Page");
        
        // Display Button Property
        addPropertybutton = new JButton("Add Property");
        viewPropertybutton = new JButton("View Property");
        findPropertybutton = new JButton("Find Property");
        updatePropertybutton = new JButton("Update Property");
        deletePropertybutton = new JButton("Delete Property");
        
        //addbutton action listener
        addPropertybutton.addActionListener(new buttonListener());
        viewPropertybutton.addActionListener(new buttonListener());
        findPropertybutton.addActionListener(new buttonListener());
        updatePropertybutton.addActionListener(new buttonListener());
        deletePropertybutton.addActionListener(new buttonListener());
        
        buttonPanel = new JPanel();
        workspace = new JPanel();
        
        //Add button Panel
        buttonPanel.add(addPropertybutton);
        buttonPanel.add(viewPropertybutton);
        buttonPanel.add(findPropertybutton);
        buttonPanel.add(updatePropertybutton);
        buttonPanel.add(deletePropertybutton);
        buttonPanel.setLayout(new GridLayout(1,2));
        
        add(buttonPanel, BorderLayout.NORTH);
        add(workspace, BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1300,500));
        this.pack();
        this.setVisible(true);
    }
    
    //buttonListener class
   private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
            //ActionListener view property
           if(e.getSource()==viewPropertybutton)
           {
               setTitle("View Property");
               ViewPropertyAdmin view = new ViewPropertyAdmin();
               workspace.removeAll();
               workspace.add(view);
               workspace.repaint();
               workspace.revalidate();
           }
           //Action Listener add property
           if(e.getSource()==addPropertybutton)
           {
               setTitle("Add Property");
               AddPropertyAdmin aproperty=new AddPropertyAdmin();
               workspace.removeAll();
               workspace.add(aproperty);
               workspace.repaint();
               workspace.revalidate();
           }
            //Action Listener Delete Property*/
           if(e.getSource()==deletePropertybutton)
           {
               setTitle("Delete Property");
               DeleteProperty2 delproperty=new DeleteProperty2();
               workspace.removeAll();
               workspace.add(delproperty);
               workspace.repaint();
               workspace.revalidate();
            }
            
            if(e.getSource()==findPropertybutton)
           {
                SearchProp searchproperty = new SearchProp();
               workspace.removeAll();
               workspace.add(searchproperty);
               workspace.repaint();
               workspace.revalidate();
           }
       }
   }
    //main function
    public static void main(String args[])
    {
        new HomePageAdmin();
        
    }

}
