/**
 * AdminMainPage
 * Cyberjaya Property Rental Management
 * Meyza Firzana Binti Ahmad Shabri
 * Admin
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Create class AdminMainPage
public class AdminMainPage extends JFrame 
{
    //Declare JPanel
    JPanel buttonPanel, workspace;
    JButton loginbutton, findPropertybutton, Registerbutton, CreateUserAccountbutton;
    
    public AdminMainPage()
    {
        //BorderLayout Constructor      
        setLayout(new BorderLayout());
        setTitle("Admin Main Page");
        
        //Create button
        loginbutton = new JButton("Login");
        findPropertybutton = new JButton("Search Property");
        Registerbutton = new JButton("Register Button");
        CreateUserAccountbutton = new JButton("Create User Account");
        
        //Add Button Listener
        loginbutton.addActionListener(new buttonListener());
        findPropertybutton.addActionListener(new buttonListener());
        Registerbutton.addActionListener(new buttonListener());
        CreateUserAccountbutton.addActionListener(new buttonListener());
        
        //Specifies layout
        buttonPanel = new JPanel();
        workspace = new JPanel();
        
        //Crate button panel and set layout
        buttonPanel.add(loginbutton);
        buttonPanel.add(CreateUserAccountbutton);
        buttonPanel.add(Registerbutton);
        buttonPanel.add(findPropertybutton);
        buttonPanel.setLayout(new GridLayout(1,4));
        
        add(buttonPanel, BorderLayout.NORTH);
        add(workspace, BorderLayout.CENTER);
        
        //Application to exit the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1500,700));
        this.pack();
        this.setVisible(true);
    }
    
    //buttonListener class
   private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
            //Login Button
           if(e.getSource()==loginbutton)
           {
               setTitle("Login");
              LoginAdmin login = new LoginAdmin();
               workspace.removeAll();
               workspace.add(login);
               workspace.repaint();
               workspace.revalidate();
           }
            
           //Register button
           if(e.getSource()==Registerbutton)
           {
               setTitle("Register");
              RegisterAdmin Register = new RegisterAdmin();
               workspace.removeAll();
               workspace.add(Register);
               workspace.repaint();
               workspace.revalidate();
           }
           
           //Find property Button
           if(e.getSource()==findPropertybutton)
           {
                SearchProp searchproperty = new SearchProp();
               workspace.removeAll();
               workspace.add(searchproperty);
               workspace.repaint();
               workspace.revalidate();
           }
           
            //Create User Account button
           if(e.getSource()==CreateUserAccountbutton)
           {
               setTitle("Create User Account");
              CreateUserAccount UserAccount = new CreateUserAccount();
               workspace.removeAll();
               workspace.add(UserAccount);
               workspace.repaint();
               workspace.revalidate();
           }
        
       }
   }
    // Main function
    public static void main(String args[])
    {
        new AdminMainPage();
        
    }

}
