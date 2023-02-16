
/**
 * MAIN MENU
 * Cyberjaya Property Rental Management
 * Puteri Ainna Ezzurin Binti Mohd Reza
 * Agent
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RentalManagementSystem extends JFrame 
{
    JPanel buttonPanel, workspace;
    JButton loginbutton, findPropertybutton;
    JButton admin,owner, agent ,tenant, search;
    
    public RentalManagementSystem()
    {
               
        setLayout(new BorderLayout());
        setTitle("User Page");
        
        //loginbutton = new JButton("Login");
        //findPropertybutton = new JButton("Search Property");
        admin=new JButton("Admin");              
        owner=new JButton("Owner");   
        agent=new JButton("Agent");             
        tenant=new JButton("Tenant");          
        search=new JButton("Search Property");   
        
        //loginbutton.addActionListener(new buttonListener());
        //findPropertybutton.addActionListener(new buttonListener());
        admin.addActionListener(new buttonListener()); 
        owner.addActionListener(new buttonListener());
        agent.addActionListener(new buttonListener());
        tenant.addActionListener(new buttonListener());
        search.addActionListener(new buttonListener());
        
        buttonPanel = new JPanel();
        workspace = new JPanel();
        
        buttonPanel.add(admin);
        buttonPanel.add(owner);
        buttonPanel.add(agent);
        buttonPanel.add(tenant);
        buttonPanel.add(search);
        buttonPanel.setLayout(new GridLayout(1,5));
        
        add(buttonPanel, BorderLayout.NORTH);
        add(workspace, BorderLayout.CENTER);
        
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1000,500));
        this.pack();
        this.setVisible(true);
    }
    
    //buttonListener class
   private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
           if(e.getSource()==admin)
                   {
                      setTitle("Owner Menu");
                      AdminMainPage adminpage = new AdminMainPage();
                    workspace.removeAll();
                    //workspace.add(agentpage);
                    workspace.repaint();
                    workspace.revalidate();
                   }
        
            if(e.getSource()==owner)
                   {
                      setTitle("Owner Menu");
                      OwnerLogin ownerpage = new OwnerLogin();
                    workspace.removeAll();
                    //workspace.add(agentpage);
                    workspace.repaint();
                    workspace.revalidate();
                   }
                   
                if(e.getSource()==agent)
                   {
                      setTitle("Agent Menu");
                      AgentLogin agentpage = new AgentLogin();
                      agentpage.setVisible(true);
               workspace.removeAll();
               //workspace.add(agentpage);
               workspace.repaint();
               workspace.revalidate();
                   }
                
                if(e.getSource()==tenant)
                   {
                      setTitle("Tenant Menu");
                      LoginTenant tenantpage = new LoginTenant();
                      tenantpage.setVisible(true);
               workspace.removeAll();
               //workspace.add(tenantpage);
               workspace.repaint();
               workspace.revalidate();
                   }
                   
                if(e.getSource()==search)
                   {
                      setTitle("Search Page");
                      SearchProp searchpage = new SearchProp();
                      //searchpage.setVisible(true);
               workspace.removeAll();
               workspace.add(searchpage);
               workspace.repaint();
               workspace.revalidate();
                   }
           
           
        
       }
   }
    
    public static void main(String args[])
    {
        new RentalManagementSystem();
        
    }

}
