package healthmate;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Project extends JFrame {
    database db=new database();
    ResultSet rs;
    JPanel head, foot, left, center;
    JLabel headjl, footjl,centerjl;

    public Project(final String user,final String name,final String add,final String email,final String bld,final String gen,final String phn,final String dob,final String ava,final String md) throws Exception{
        setLayout(new BorderLayout());
        setLookAndFeel();
        setTitle("HEALTH MATE");

        head = new JPanel();
        foot = new JPanel();
        left = new JPanel();
        center = new JPanel();

        left.setPreferredSize(new Dimension(200, 1000));
        head.setPreferredSize(new Dimension(1000, 60));
        foot.setPreferredSize(new Dimension(1000, 50));

        add(head, "North");
        add(foot, "South");
        add(left, "West");
        add(center, "Center");
        left.setLayout(null);
        center.setLayout(null);
        final JLabel l1= new JLabel("Edit Profile");
        final JLabel l2= new JLabel("Take an Appointment");
        final JLabel l3= new JLabel("View Reports");
        
        final JLabel l4= new JLabel("Major Problems");
        final JLabel l5= new JLabel("Next Visit");
        final JLabel lout=new JLabel("LOG OUT");
        final ImageIcon image = new ImageIcon(getClass().getResource("load2.gif"));
        //final JLabel img = new JLabel("", image, JLabel.CENTER);
        final JLabel img = new JLabel();
        img.setBounds(20, 130,50, 50);
        l1.setBounds(0, 0, 200, 50);
        l2.setBounds(0, 25, 200, 50);
        l3.setBounds(0, 50, 200, 50);
        l4.setBounds(0, 75, 200, 50);
        l5.setBounds(0, 100, 200, 50);
        
        l1.setFont(new Font("SansSerif", 4, 15));
        l1.setForeground(Color.WHITE);
        l2.setFont(new Font("SansSerif", 4, 15));
        l2.setForeground(Color.WHITE);
        l3.setFont(new Font("SansSerif", 4, 15));
        l3.setForeground(Color.WHITE);
        l4.setFont(new Font("SansSerif", 4, 15));
        l4.setForeground(Color.WHITE);
        l5.setFont(new Font("SansSerif", 4, 15));
        l5.setForeground(Color.WHITE);
        
        lout.setFont(new Font("SansSerif", 4, 15));
        lout.setForeground(Color.BLUE);
        lout.setBounds(1000,10,100,25);
        left.add(l1);
        left.add(l2);
        left.add(l3);
        left.add(l4);
        left.add(l5);
        left.add(img);
        
       
        center.add(lout);
        l1.addMouseListener(new MouseAdapter() {
            
            @Override
              public void mouseClicked(MouseEvent e) {
                try {
                    
                    new Editpro(user,name,add,email,bld,gen,phn,dob,ava,md);
                    dispose();
                } catch (Exception ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Clicked");
    }

            @Override
    public void mouseEntered(MouseEvent e) {
       
                l1.setForeground(Color.BLACK);
    }

            @Override
    public void mouseExited(MouseEvent e) {
        
                l1.setForeground(Color.WHITE);
    }
        });
        l2.addMouseListener(new MouseAdapter() {
            
            @Override
              public void mouseClicked(MouseEvent e) {
               try{ 
                   
                   new take(user,name,add,email,bld,gen,phn,dob,ava,md);
                   dispose();
                System.out.println("Clicked");
    }catch(Exception ex){
        
    }}

            @Override
    public void mouseEntered(MouseEvent e) {
        
                l2.setForeground(Color.BLACK);
    }

            @Override
    public void mouseExited(MouseEvent e) {
       
                l2.setForeground(Color.WHITE);
    }
        });
        l3.addMouseListener(new MouseAdapter() {
            
            @Override
              public void mouseClicked(MouseEvent e) {
                try{
                 
                new report(user,name,add,email,bld,gen,phn,dob,ava,md);
                Project.this.dispose();
                System.out.println("Clicked");
    }catch(Exception ex){
        
    }}

            @Override
    public void mouseEntered(MouseEvent e) {
        
                l3.setForeground(Color.BLACK);
    }

            @Override
    public void mouseExited(MouseEvent e) {
                try{
                
                l3.setForeground(Color.WHITE);
    }catch(Exception ex){
        
    }}
        });
        l4.addMouseListener(new MouseAdapter() {
            
            @Override
              public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Your Major Diseases are: \n"+md);
                System.out.println("Clicked");
    }

            @Override
    public void mouseEntered(MouseEvent e) {
        
                l4.setForeground(Color.BLACK);
    }

            @Override
    public void mouseExited(MouseEvent e) {
        
                l4.setForeground(Color.WHITE);
    }
        });
        l5.addMouseListener(new MouseAdapter() {
            
            @Override
              public void mouseClicked(MouseEvent e) {
                try {
            
            db.connect();
            rs = db.retrivefromdb(user);
            if(rs.last()){
            String rev=rs.getString("review");
            JOptionPane.showMessageDialog(null, "Your Next Visit is on: "+rev);
            }
            else
            {JOptionPane.showMessageDialog(null, "Not a Single Record");
            }
            System.out.println("records taken successfully");
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Visit");
            System.out.println(ex);
        }
        
        System.out.println("Clicked");
    }

            @Override
    public void mouseEntered(MouseEvent e) {
        
                l5.setForeground(Color.BLACK);
    }

            @Override
    public void mouseExited(MouseEvent e) {
        
                l5.setForeground(Color.WHITE);
    }
        });
        
lout.addMouseListener(new MouseAdapter() {
            
            @Override
              public void mouseClicked(MouseEvent e) {
                
                new Patient().setVisible(true);
                dispose();
                System.out.println("Clicked");
    }

            @Override
    public void mouseEntered(MouseEvent e) {
        lout.setForeground(Color.BLACK);
    }

            @Override
    public void mouseExited(MouseEvent e) {
        lout.setForeground(Color.BLUE);
    }
        });        
        

       
        String name1=name.toUpperCase();
        JLabel centerjl = new JLabel("HELLO, "+name1+"\n" +"WELCOME BACK..");
        centerjl.setHorizontalAlignment(SwingConstants.LEFT);
        centerjl.setBackground(new Color(150, 0, 0));
        centerjl.setForeground(Color.RED);
        centerjl.setFont(new Font("SansSerif", 4, 20));
        centerjl.setBounds(50, 10, 1000, 50);
        center.add(centerjl);
        
        
        
        //head.setLayout(new BorderLayout());
        headjl = new JLabel("Health Mate");
        //headjl.setHorizontalAlignment(SwingConstants.CENTER);
        headjl.setFont(new Font("SansSerif", 4, 32));
        headjl.setForeground(Color.WHITE);
        head.add(headjl);


        footjl = new JLabel("Copyright 2013,Health Mate");
        footjl.setFont(new Font("SansSerif", 4, 11));
        footjl.setForeground(Color.WHITE);
        foot.add(footjl);

        head.setBackground(new Color(0, 37, 74));
        foot.setBackground(new Color(38, 74, 112));
        left.setBackground(new Color(150, 0, 0));
        center.setBackground(new Color(255, 250, 238));

        setMinimumSize(new Dimension(500, 500));
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void setLookAndFeel() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }
}