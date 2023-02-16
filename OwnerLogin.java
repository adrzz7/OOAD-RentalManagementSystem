/* Login Class for owner
 * Cyberjaya Property Rental Management
 * Adriana Syaffiya binti Ahmad Khadri
 * 1191200471
 * Owner
 */ 
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;  
import java.sql.*;
import javax.swing.*;


//create the main class for login
class OwnerLogin extends JFrame{  
    
    //constructor
    public OwnerLogin(){
        try  
        {  
            //create instance of the CreateLoginForm  
            CreateOwnerLoginForm form = new CreateOwnerLoginForm();  
            form.setSize(400,100);  //set size of the frame  
            form.setVisible(true);  //make page visible to the owner   
        }  
        catch(Exception e)  
        {     
            //handle exception   
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }
    //main() method start  
    public static void main(String arg[])  
    {  
        new OwnerLogin();
    }  
} 


//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
class CreateOwnerLoginForm extends JFrame implements ActionListener  
{  
    //initialize button, panel, label, and text field  
    JButton loginBtn;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  usernameField, pwdField; 
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
 
    //calling constructor  
    CreateOwnerLoginForm()  
    {      
        userLabel = new JLabel();           //create label for username 
        userLabel.setText("Username");      //set label value for Username  
          
        //create text field to get username from the user  
        usernameField = new JTextField(15);    //set length of the text  
   
        passLabel = new JLabel();           //create label for password 
        passLabel.setText("Password");      //set label value for Password  
          
        //create text field to get password from the user  
        pwdField = new JPasswordField(15);    //set length for the password  
          
        //create submit button  
        loginBtn = new JButton("LOGIN"); //set label to button  
           
        newPanel = new JPanel(new GridLayout(3, 1));   //create panel to put form elements  
        newPanel.add(userLabel);     //set username label to panel  
        newPanel.add(usernameField);   //set text field to panel  
        newPanel.add(passLabel);    //set password label to panel  
        newPanel.add(pwdField);   //set text field to panel  
        newPanel.add(loginBtn);           //set button to panel  
          
        //set border to panel   
        add(newPanel, BorderLayout.CENTER);  
          
        //perform action on button click   
        loginBtn.addActionListener(this);     //add action listener to button  
        setTitle("Owner Login Form");         //set title to the login form  
    }  
      
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
        
        try{
            //connect to database
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalmanagement","root","");
            st=con.createStatement();
            
            String username = usernameField.getText();        //get user entered username from the textField1  
            String pwd = pwdField.getText();        //get user entered pasword from the textField2  
            
            //search for the same username and password in the database
            String sql = "select * from owner where ownerUsername='"+username+"' and ownerPassword='"+pwd+"'";
            ResultSet rs = st.executeQuery(sql);

    
            //check whether the credentials are authentic or not  
            if (rs.next()) {  //if authentic, navigate user to a new page  
                  
                //create instance called main
                OMainPage main = new OMainPage();  
                  
                //make page visible to the user  
                main.setVisible(true);  
                
                //make login page invisible to user
                this.setVisible(false);
                
    
            }  
            else{  
                //show error message  
                System.out.println("Please enter valid username and password");  //show error message if username and password is not found
            }  
        }catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: "+ex); //show error message if there is a problem with the code
        }
        
        
    }  
}  
