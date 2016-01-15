package healthmate;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

class Patient extends JFrame {

    JPanel top = new JPanel();
    JPanel center = new JPanel();
    JPanel left = new JPanel();
    JPanel bottom = new JPanel();
    JFrame f=this;
    final JLabel l1 = new JLabel("Copyright 2013,Health Mate");
    final JLabel l2 = new JLabel(" About Us");
    JLabel l3 = new JLabel(" List of Doctors");
    JLabel l4 = new JLabel(" Mobile Application");
    JLabel l5 = new JLabel(" FAQs");
    JLabel l6 = new JLabel(" Contact Us");
    JLabel l7 = new JLabel("Username:");
    JLabel l8 = new JLabel("Password:");
    JLabel l9 = new JLabel("Log In");
    JLabel l10 = new JLabel("Forgot your Password?");
    JLabel l11 = new JLabel("Register Here");
    JLabel logo = new JLabel("Health Mate");
    JPasswordField pass = new JPasswordField();
    JTextField usr = new JTextField();
    database db=new database();
    
    ResultSet rs;
    ImageIcon image = new ImageIcon(getClass().getResource("load2.gif"));
        //JLabel img;
        JLabel img = new JLabel();
    
    public Patient() {
        
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(left, BorderLayout.WEST);
        add(bottom, BorderLayout.SOUTH);
        
        left.setPreferredSize(new Dimension(200, 1000));
        top.setPreferredSize(new Dimension(1000, 60));
        bottom.setPreferredSize(new Dimension(1000, 50));
        
        left.setLayout(null);
        center.setLayout(null);
        
        l2.setFont(new Font("SansSerif", 4, 15));
        l2.setForeground(Color.WHITE);
        l3.setFont(new Font("SansSerif", 4, 15));
        l3.setForeground(Color.WHITE);
        l4.setFont(new Font("SansSerif", 4, 15));
        l4.setForeground(Color.WHITE);
        l5.setFont(new Font("SansSerif", 4, 15));
        l5.setForeground(Color.WHITE);
        l6.setFont(new Font("SansSerif", 4, 15));
        l6.setForeground(Color.WHITE);
        l7.setFont(new Font("SansSerif", 4, 15));
        l7.setForeground(Color.BLACK);
        l8.setFont(new Font("SansSerif", 4, 15));
        l8.setForeground(Color.BLACK);
        l9.setFont(new Font("SansSerif", 4, 15));
        l9.setForeground(Color.BLACK);
        l10.setFont(new Font("SansSerif", 4, 11));
        l10.setForeground(Color.BLUE);
        l11.setFont(new Font("SansSerif", 9, 15));
        l11.setForeground(Color.BLUE);

        logo.setFont(new Font("SansSerif", 4, 32));
        logo.setForeground(Color.WHITE);
        l1.setFont(new Font("SansSerif", 4, 11));
        l1.setForeground(Color.WHITE);

        l2.setBounds(0, 0, 200, 50);
        l3.setBounds(0, 25, 200, 50);
        l4.setBounds(0, 50, 200, 50);
        l5.setBounds(0, 75, 200, 50);
        l6.setBounds(0, 100, 200, 50);
        l7.setBounds(100, 100, 80, 50);
        l8.setBounds(100, 150, 80, 50);
        l10.setBounds(180, 215, 200, 20);
        usr.setBounds(180, 110, 150, 25);
        l11.setBounds(950, 0, 100, 20);
        pass.setBounds(180, 160, 150, 25);
        l9.setBounds(180, 190, 50, 25);
        img.setBounds(200,250,200,250);
                center.add(img);
        
        l2.addMouseListener(new MouseAdapter() {
            
            @Override
              public void mouseClicked(MouseEvent e) {
                new aboutus().setVisible(true);
                dispose();
    }
           
            

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
        System.out.println("Clicked");
    }

            @Override
    public void mouseEntered(MouseEvent e) {
        l3.setForeground(Color.BLACK);
    }

            @Override
    public void mouseExited(MouseEvent e) {
        l3.setForeground(Color.WHITE);
    }
        });
        l4.addMouseListener(new MouseAdapter() {
            
            @Override
              public void mouseClicked(MouseEvent e) {
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
        new faq().setVisible(true);
        dispose();
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
        l6.addMouseListener(new MouseAdapter() {
            
            @Override
              public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null, "Amol Agrawal               +91-9422438156  amolagrawal05@gmail.com\nAshwin Bhoyar              +91-8855970971  ashwinbhy@gmail.com\nAtindra Mardikar           +91-9765972743  atindra_mardikar@yahoo.com\nDeepak Deshmukh        +91-9673883395  dddeepakdeshmukh@gmail.com\nMithilesh Wachasunder  +91-8087213921  mithilesh.wachasunder@gmail.com");
                System.out.println("Clicked");
    }

            @Override
    public void mouseEntered(MouseEvent e) {
        l6.setForeground(Color.BLACK);
    }

            @Override
    public void mouseExited(MouseEvent e) {
        l6.setForeground(Color.WHITE);
    }
        });

        l9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                img.setIcon(image);
                        img.setText("Please Wait..");
                //img = new JLabel("Please Wait..", image, JLabel.CENTER);
                String u = usr.getText();
                String p = pass.getText();
                SwingWorker worker;
                
                worker = new Workerl(img,u,p,f);
           worker.execute();
                

            }
            @Override
    public void mouseEntered(MouseEvent e) {
        l9.setForeground(Color.RED);
    }
                           @Override
    public void mouseExited(MouseEvent e) {
        l9.setForeground(Color.BLACK);
    }
        });

        l11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            new FrameDemo().setVisible(true);
                            dispose();
                        } catch (Exception ex) {
                            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    @Override
    public void mouseEntered(MouseEvent e) {
        l11.setForeground(Color.BLACK);
    }
                           @Override
    public void mouseExited(MouseEvent e) {
        l11.setForeground(Color.BLUE);
    }

            
                });

        l10.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(!"".equals(usr.getText())){
                        try{
                            db.connect();
                             rs= db.stmt.executeQuery("Select * from table1 where id='"+usr.getText()+"'");
                            rs.next();
                            String pass=rs.getString("password");
                            JOptionPane.showMessageDialog(null, "Your Password is: "+pass);
                            db.disconnect();
                            System.out.println("clicked");
                        }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "No such Username!");
                        }
                    }
                        else{
                        JOptionPane.showMessageDialog(null, "Type a Username!");
                        }
                    }
                    @Override
    public void mouseEntered(MouseEvent e) {
        l10.setForeground(Color.BLACK);
    }
                           @Override
    public void mouseExited(MouseEvent e) {
        l10.setForeground(Color.BLUE);
    }
        });
        
        pass.addKeyListener(new KeyAdapter() {
            public void KeyPressed(KeyEvent evt)
            {
                passKeyreleased(evt);
            }
});
        
        
        left.add(l2);
        left.add(l3);
        left.add(l4);
        left.add(l5);
        left.add(l6);
        
        center.add(l7);
        center.add(l8);
        center.add(usr);
        center.add(pass);
        center.add(l9);
        center.add(l10);
        center.add(l11);
        
        
        
        bottom.add(l1);
        top.add(logo);
        left.setBackground(
                new Color(150, 0, 0));
        top.setBackground(
                new Color(0, 37, 74));
        center.setBackground(
                new Color(255, 250, 238));
        bottom.setBackground(
                new Color(38, 74, 112));
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

   /* public void login() {
    
        
        
        String userName = usr.getText();
        String passWord = pass.getText();        
        if(!"".equals(userName)&&!"".equals(passWord)){
        try{
        db.connect();     
        rs= db.stmt.executeQuery("Select * from table1 where id='"+userName+"' and password='"+passWord+"'");
        rs.next();
              String name= rs.getString("name");
              String add= rs.getString("address");
              String email= rs.getString("email");
              String bld= rs.getString("blood_group");
              String gen= rs.getString("gender");
              String phn= rs.getString("phn_no");
              String dob= rs.getString("dob");
              String ava= rs.getString("zip");
              String md= rs.getString("major_diseases");
             db.disconnect();
             
       
              new Project(userName,name,add,email,bld,gen,phn,dob,ava,md).setVisible(true);
              dispose();
        
    }catch(Exception exp){
    JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");
    
        }
    }
        else{
        JOptionPane.showMessageDialog(null, "Username or Password cannot be empty!");
        }
    }*/
    private void passKeyreleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            System.out.println("enter");
            //login();
        }
    }
}
