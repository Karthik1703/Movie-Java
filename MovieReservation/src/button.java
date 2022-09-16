import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;



class button implements ActionListener{

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
                    JLabel movielabel1;
                
                    movielabel1 = new JLabel("Movieee:");
            movielabel1.setFont(new Font("Tahoma", Font.PLAIN, 15));
            movielabel1.setBounds(250, 190, 100, 30);
            checkframe.add(movielabel1);
                
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






//Action Performed Frame Controller

        public void actionPerformed(ActionEvent e)
        {
            movieticketsystem l = new movieticketsystem();
            String button=e.getActionCommand();
            
            if(button.equals("Close"))
            {
                System.exit(0);
            }
            
        }

}
