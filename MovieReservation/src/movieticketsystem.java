import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;



class movieticketsystem implements ActionListener{

//Global Declarations
    static JFrame f;
	static JFrame y;
	static JButton b1;
	static JButton b2;
    static String moviestring;
    
    
    static Statement stmt;
    static Connection con;
    int i = 0;
//Main function
    public static void main(String args[])
	{
        //Frame fixing 
		    JFrame checkframe= new JFrame("Movie TICKET REGISTRATION FORM");
            
        //Label
            JLabel movielabel;
            JComboBox moviedropdown;
            JButton b1,b2;

        //Option values for form
            String s1[]= { " ", "COBRA", "PONNIYIN SELVAN", "VTK","VIKRAM", "DIARY", "LEGEND"};
            
		



        //Labels for all the inputs

            movielabel = new JLabel("Movie:");
            movielabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
            movielabel.setBounds(250, 50, 100, 30);
            moviedropdown = new JComboBox(s1);
            moviedropdown.setBounds(290, 50, 130, 30);
            

	
        //Save and close button 

            b1 = new JButton("CHECK");
            b1.setBounds(150, 300, 100, 30);
            b2 = new JButton("Close");
            b2.setBounds(420, 300, 100, 30);

        //Event handling using button
        movieticketsystem obj= new movieticketsystem();
            b1.addActionListener(obj);
            b2.addActionListener(obj);
        

            b1.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                
                    moviestring = moviedropdown.getSelectedItem() + "";
                    
                       
                
                }
		    });

            
            
            
        
        // To add the components to the frames
           
        
            checkframe.add(movielabel);
            checkframe.add(moviedropdown);
            
            checkframe.add(b1);
            checkframe.add(b2);
            checkframe.setLayout(null);
            checkframe.setSize(800, 700);
            checkframe.setLocationRelativeTo(null);
            checkframe.setVisible(true);
	




	}
public void loginfunction()
{
    
    
    //Frame fixing 
    JFrame loginframe= new JFrame("Login");
    try{
        con =DriverManager.getConnection ( "jdbc:mysql://localhost:3306/railwayreservation","root","Gokul@2002");
        stmt = con.createStatement() ;
        
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
//Label
    JLabel ulabel,passlabel;
    JButton l1;
    JTextField uname,pass;

//Option values for form
    




//Labels for all the inputs

    
    ulabel = new JLabel("Username");
    ulabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
    ulabel.setBounds(50, 50, 100, 30);

    uname = new JTextField(16);
    uname.setBounds(120, 50, 100, 30);

    passlabel = new JLabel("Password");
    passlabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
    passlabel.setBounds(50, 130, 100, 30);

    pass = new JTextField(16);
    pass.setBounds(120, 130, 100, 30);
    


//Save and close button 

    l1 = new JButton("Login");
    l1.setBounds(150, 300, 100, 30);
    

//Event handling using button
movieticketsystem obj= new movieticketsystem();
    l1.addActionListener(obj);
    


    l1.addActionListener(new ActionListener() 
    {
        public void actionPerformed(ActionEvent e)
        {
        
            try{
                String uuname = uname.getText();
                String uupass = pass.getText();
                System.out.println(uuname+uupass);
                PreparedStatement pss=con.prepareStatement("SELECT * FROM user WHERE name=? and password=?;");
                    
                    pss.setString(1, uuname);
                    pss.setString(2, uupass);
                    int ii=pss.executeUpdate();

                    if(ii>0)
                    {
                        System.out.println("You are sucessfully logged in");
                    }
                    
                    con.close();
                    }
                catch(Exception s)
                {
                    System.out.println(e);
                }
        
        }
    });

// To add the components to the frames
   

    loginframe.add(ulabel);
    loginframe.add(uname);
    loginframe.add(passlabel);
    loginframe.add(pass);
    loginframe.add(l1);
    loginframe.setLayout(null);
    loginframe.setSize(800, 700);
    loginframe.setLocationRelativeTo(null);
    loginframe.setVisible(true);  

}



public void signupfunction()
{
   //Frame fixing 
   JFrame signupframe= new JFrame("Signup");
   try{
       con =DriverManager.getConnection ( "jdbc:mysql://localhost:3306/railwayreservation","root","Gokul@2002");
       stmt = con.createStatement() ;
       
   }
   catch(Exception e)
   {
       System.out.println(e);
   }
//Label
   JLabel slname,slage,slno,slemail,slpass;
   JButton sb1;
   JTextField stname,stage,stno,stemail,stpass;

//Option values for form
   




//Labels for all the inputs

   
   slname = new JLabel("Name");
   slname.setFont(new Font("Tahoma", Font.PLAIN, 15));
   slname.setBounds(50, 50, 100, 30);

   stname = new JTextField(16);
   stname.setBounds(120, 50, 100, 30);

   slage = new JLabel("Age");
   slage.setFont(new Font("Tahoma", Font.PLAIN, 15));
   slage.setBounds(50, 90, 100, 30);

   stage = new JTextField(16);
   stage.setBounds(120, 90, 100, 30);
   


   slno = new JLabel("Number");
   slno.setFont(new Font("Tahoma", Font.PLAIN, 15));
   slno.setBounds(50, 130, 100, 30);

   stno = new JTextField(16);
   stno.setBounds(120, 130, 100, 30);


   slemail = new JLabel("E-mail");
   slemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
   slemail.setBounds(50, 170, 100, 30);

   stemail = new JTextField(16);
   stemail.setBounds(120, 170, 100, 30);

   slpass = new JLabel("Password");
   slpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
   slpass.setBounds(50, 210, 100, 30);

   stpass = new JTextField(16);
   stpass.setBounds(120, 210, 100, 30);



//Save and close button 

   sb1 = new JButton("Signup");
   sb1.setBounds(150, 300, 100, 30);
   

//Event handling using button
   movieticketsystem obj= new movieticketsystem();
   sb1.addActionListener(obj);
   


   sb1.addActionListener(new ActionListener() 
   {
       public void actionPerformed(ActionEvent e)
       {
        try{
            i++;
            String ssname = stname.getText();
            String ssmail = stemail.getText();
            String sspass = stpass.getText();
            PreparedStatement ps=con.prepareStatement("INSERT INTO user(name,email,password) VALUES(?,?,?)");
                
                ps.setString(1, ssname);
                ps.setString(2, ssmail);
                ps.setString(3, sspass);
    
                }
            catch(Exception s)
            {
                System.out.println(e);
            }
       
       }
   });

// To add the components to the frames
  

   signupframe.add(slname);
   signupframe.add(stname);

   signupframe.add(slage);
   signupframe.add(stage);

   signupframe.add(slno);
   signupframe.add(stno);

   signupframe.add(slemail);
   signupframe.add(stemail);

   signupframe.add(slpass);
   signupframe.add(stpass);

   signupframe.add(sb1);

   signupframe.setLayout(null);
   signupframe.setSize(800, 700);
   signupframe.setLocationRelativeTo(null);
   signupframe.setVisible(true);
}



//Output functional frame


public void outputfunction()
{
   //Frame fixing 
   JFrame outputframe= new JFrame("Available Ticket");
   try{
       con =DriverManager.getConnection ( "jdbc:mysql://localhost:3306/railwayreservation","root","Gokul@2002");
       stmt = con.createStatement() ;
       
   }
   catch(Exception e)
   {
       System.out.println(e);
   }
//Label
   JLabel out,tname,pname;
   JButton ob1;
   

//Option values for form
   




//Labels for all the inputs

   
   out = new JLabel("Available Ticket");
   out.setBounds(290, 50, 175, 40);
        

        tname = new JLabel("Movie Name: Legend");
        tname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tname.setBounds(50, 180, 200, 20);
        
        pname = new JLabel("Price :  Rs 100 ");
        pname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pname.setBounds(50, 270, 200, 20);
        
        

        ob1 = new JButton("BookNow");   
        ob1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ob1.setBounds(250, 550, 145, 50);
        
   

//Event handling using button
movieticketsystem obj= new movieticketsystem();
   ob1.addActionListener(obj);
   


   ob1.addActionListener(new ActionListener() 
   {
       public void actionPerformed(ActionEvent e)
       {
       
              
       
       }
   });

// To add the components to the frames
  
   outputframe.add(out);
   outputframe.add(tname);
   outputframe.add(pname);
   

   outputframe.add(ob1);

   outputframe.setLayout(null);
   outputframe.setSize(800, 700);
   outputframe.setLocationRelativeTo(null);
   outputframe.setVisible(true);
}






//final function

public void finalfunction()
{
   JFrame finalframe= new JFrame("Thank You");
   JLabel ffinal,ffinal1;
   ffinal = new JLabel("Your ticket has been");
   ffinal1  = new JLabel(" successfully submitted");
   ffinal.setFont(new Font("Tahoma", Font.PLAIN, 17));
   ffinal1.setFont(new Font("Tahoma", Font.PLAIN, 17));
   ffinal.setBounds(100, 50, 175, 40);
   ffinal1.setBounds(250, 50, 175, 40);
   finalframe.add(ffinal);
   finalframe.add(ffinal1);
   finalframe.setLayout(null);
   finalframe.setSize(800, 700);
   finalframe.setLocationRelativeTo(null);
   finalframe.setVisible(true);
}














//Action Performed Frame Controller

        public void actionPerformed(ActionEvent e)
        {
            movieticketsystem l = new movieticketsystem();
            String button=e.getActionCommand();
            if(button.equals("CHECK"))
            {
                l.signupfunction();
            }
            if(button.equals("Signup"))
            {
                l.loginfunction();
            }
            if(button.equals("Login"))
            {
                l.outputfunction();
            }
            if(button.equals("BookNow"))
            {
                l.finalfunction();
            }
            if(button.equals("Close"))
            {
                
            }
            
        }





//Further functions

}
