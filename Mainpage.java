/**
 * Main Page Tenant
 * Cyberjaya Property Rental Management
 * Alison Wong Cheung Yung
 * Tenant
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Main page for Tenant 
public class Mainpage extends JFrame 
{
    JPanel buttonPanel, workspace;
    JButton viewPropertybtn, Searchbtn, UpdateProfilebtn,regBtn;
    //Main page function
    public Mainpage()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setLayout(new BorderLayout());
        setTitle("Main Page");
        
        //Declare button in Main page
        viewPropertybtn = new JButton("View Property");
        UpdateProfilebtn = new JButton("Update Profile");
        Searchbtn = new JButton("Search Property");
       
        viewPropertybtn.setFocusable(false);
        UpdateProfilebtn.setFocusable(false);
        Searchbtn.setFocusable(false);
        
        //Add actionListener to the button
        viewPropertybtn.addActionListener(new buttonListener());
        UpdateProfilebtn.addActionListener(new buttonListener());
        Searchbtn.addActionListener(new buttonListener());
  
        //Button panel and display panel
        buttonPanel = new JPanel();
        workspace = new JPanel();
        
        buttonPanel.add(viewPropertybtn);
        buttonPanel.add(UpdateProfilebtn);
        buttonPanel.add(Searchbtn);
        buttonPanel.setLayout(new GridLayout(1,3));
            
        add(buttonPanel, BorderLayout.NORTH);
        add(workspace, BorderLayout.CENTER);
        
        this.dispose();//Close this JFrame only
        this.setPreferredSize(new Dimension(1200,500));
        this.pack();
        this.setVisible(true);
    }
    
    //buttonListener class
   private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
        
           if(e.getSource()==viewPropertybtn)
           {
               setTitle("View Offer Property");
               ViewPropertyOff view = new ViewPropertyOff();
               workspace.removeAll();
               workspace.add(view);
               workspace.repaint();
               workspace.revalidate();
           }
           
           if(e.getSource()==UpdateProfilebtn)
           {
               setTitle("Update Profile");
               UpdateProfile updateP=new UpdateProfile();
               workspace.removeAll();
               workspace.add(updateP);
               workspace.repaint();
               workspace.revalidate();
           }     
           
           if(e.getSource()==Searchbtn)
           {
               setTitle("Search Property");
               SearchProp searchP=new SearchProp();
               workspace.removeAll();
               workspace.add(searchP);
               workspace.repaint();
               workspace.revalidate();
           }    
       }
   }
    
    public static void main(String args[])
    {
        new Mainpage();       
    }

}
