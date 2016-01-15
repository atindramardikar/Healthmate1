package healthmate;

import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class FrameDemo extends JFrame {

    JButton reg, cancel, check;
    JLabel bg, na, a, dob, e, co, g, ci, p, r, pw, male, female, cpw, mand, fir, mid, last,format;
    JTextField bld, name, pin, email, contactno, user, date;
    JTextArea address;
    JPasswordField password, cpassword;
    JRadioButton m, f;
    database db=new database();
    ResultSet rs;

    @SuppressWarnings("empty-statement")
    public FrameDemo() throws Exception {
        JPanel n = new JPanel();
        final JPanel c = new JPanel();
        JPanel w = new JPanel();
        JPanel b = new JPanel();
        add(n, BorderLayout.NORTH);
        add(c, BorderLayout.CENTER);
        add(w, BorderLayout.WEST);
        add(b, BorderLayout.SOUTH);
        w.setPreferredSize(new Dimension(200, 1000));
        n.setPreferredSize(new Dimension(1000, 60));
        b.setPreferredSize(new Dimension(1000, 50));
        w.setLayout(null);
        w.setPreferredSize(new Dimension(200, 1000));
        final JLabel l2 = new JLabel(" About Us");
    final JLabel l3 = new JLabel(" List of Doctors");
    final JLabel l4 = new JLabel(" Mobile Application");
    final JLabel l5 = new JLabel(" FAQs");
    final JLabel l6 = new JLabel(" Contact Us");
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

       

        l2.addMouseListener(new MouseAdapter() {
            
            @Override
              public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");
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
        JLabel hm = new JLabel("Health Mate");
        w.setSize(new Dimension(1000, 500));

        w.setBackground(new Color(150, 0, 0));
        n.setBackground(new Color(0, 37, 74));
        c.setBackground(new Color(255, 250, 238));
        b.setBackground(new Color(38, 74, 112));
        c.setLayout(null);
        

        reg = new JButton("Register");
        cancel = new JButton("Cancel");
        check = new JButton("Check Availibility");
        na = new JLabel("* Name:");
        fir = new JLabel("First");
        mid = new JLabel("Middle");
        last = new JLabel("Last");

        g = new JLabel("* Gender:");
        dob = new JLabel("* Date of Birth:");
        format = new JLabel("(YYYY-MM-DD)");
        a = new JLabel("* Address:");


        p = new JLabel("* Pin Code:");
        co = new JLabel("* Contact No.:");
        e = new JLabel("* Email:");
        bg = new JLabel("* Blood Group:");

        r = new JLabel("* Username:");
        pw = new JLabel("* Password:");
        cpw = new JLabel("* Confirm Password:");
        mand = new JLabel("* Mandatory Fields");

        mand.setForeground(Color.RED);
        name = new JTextField();

        
        date = new JTextField();
        address = new JTextArea();
        email = new JTextField();
        contactno = new JTextField();
        bld = new JTextField();
        male = new JLabel("Male");
        m = new JRadioButton();
        female = new JLabel("Female");
        f = new JRadioButton();
        pin = new JTextField();
        user = new JTextField();
        password = new JPasswordField();
        cpassword = new JPasswordField();
        fir.setFont(new Font("Serif", Font.PLAIN, 11));
        mid.setFont(new Font("Serif", Font.PLAIN, 11));
        last.setFont(new Font("Serif", Font.PLAIN, 11));

        
        hm.setFont(new Font("SansSerif", 4, 32));
        hm.setForeground(Color.WHITE);
        JLabel footjl = new JLabel("Copyright 2013,Health Mate");

        footjl.setFont(new Font("SansSerif", 4, 11));
        footjl.setForeground(Color.WHITE);

        na.setBounds(10, 10, 130, 25);
        name.setBounds(140, 10, 300, 25);
        fir.setBounds(145, 32, 30, 20);
        //mname.setBounds(240, 10, 100, 25);
        mid.setBounds(245, 32, 40, 20);
        //lname.setBounds(340, 10, 100, 25);
        last.setBounds(345, 32, 30, 20);

        g.setBounds(10, 55, 100, 25);
        male.setBounds(145, 55, 50, 25);
        m.setBounds(175, 55, 50, 25);
        female.setBounds(225, 55, 70, 25);
        f.setBounds(270, 55, 50, 25);
        dob.setBounds(10, 85, 150, 25);
        date.setBounds(140, 85, 100, 25);
        format.setBounds(240, 85, 100, 25);
        a.setBounds(10, 115, 130, 25);
        address.setBounds(145, 115, 140, 100);
        
        mand.setBounds(10, 405, 150, 25);
        p.setBounds(300, 195, 130, 25);
        pin.setBounds(370, 195, 100, 25);
        co.setBounds(10, 225, 130, 25);
        contactno.setBounds(140, 225, 150, 25);
        e.setBounds(10, 255, 130, 25);
        email.setBounds(140, 255, 150, 25);
        bg.setBounds(10, 285, 130, 25);
        bld.setBounds(140, 285, 150, 25);
        r.setBounds(10, 315, 130, 25);
        user.setBounds(140, 315, 150, 25);
        check.setBounds(300, 315, 135, 25);
        
        pw.setBounds(10, 345, 130, 25);
        password.setBounds(140, 345, 150, 25);
        cpw.setBounds(10, 375, 130, 25);
        cpassword.setBounds(140, 375, 150, 25);
        reg.setBounds(140, 435, 110, 25);
        cancel.setBounds(10, 435, 80, 25);
        l2.setBounds(0, 0, 200, 50);
        l3.setBounds(0, 25, 200, 50);
        l4.setBounds(0, 50, 200, 50);
        l5.setBounds(0, 75, 200, 50);
        l6.setBounds(0, 100, 200, 50);
        final JLabel ch=new JLabel();
        ch.setBounds(450, 315, 150, 25);
        
        
        check.addActionListener(new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e){
            if(!"".equals(user.getText())){
            try{
              String usern=user.getText();
              db.connect();
              rs= db.stmt.executeQuery("Select name from table1 where id='"+usern+"'");
              rs.next();
              String name= rs.getString("name");               
              
               ch.setForeground(new Color(153,0,0));
               ch.setText("Username Unavailable");
               db.disconnect();
            }catch(Exception expt){
                ch.setForeground(new Color(0,102,51));
                ch.setText("Username Available");
                }
            }
            else{
            JOptionPane.showMessageDialog(null, "Username cannot be blank!!");
            
            }
        }
        });
        
        reg.addActionListener(new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e){
         if(!"".equals(user.getText())&&!"".equals(password.getText())&&!"".equals(cpassword.getText())&&!"".equals(name.getText())&&!"".equals(address.getText())&&!"".equals(email.getText())&&!"".equals(bld.getText())&&!"".equals(contactno.getText())&&!"".equals(date.getText())&&!"".equals(pin.getText())){
            try{
             String pass1;
             String gen;
            
             String p1=password.getText();//get the char array of password and convert to string represenation
             String p2=cpassword.getText();
             if(p1.equals(p2)){
                 pass1=p1;
            
             
             if(m.isSelected()){
             gen="Male";
             }
             else
                 gen="Female";
             
                db.connect();
              db.stmt.executeUpdate("Insert into table1 values('"+user.getText()+"','"+pass1+"','"+name.getText()+"','"+address.getText()+"','"+email.getText()+"','"+bld.getText()+"','"+gen+"','"+contactno.getText()+"','"+date.getText()+"','"+pin.getText()+"', '')");
              db.disconnect();
              JOptionPane.showMessageDialog(null, "You are registered to Healthmate successfully!");
         
        new Patient().setVisible(true);
        dispose();
             }
        else
             {
             JOptionPane.showMessageDialog(null, "password not same!!");
             }
        
        }catch(Exception exp){
             System.out.println(exp);    
        JOptionPane.showMessageDialog(null, "error");
        }
        }
        else
           JOptionPane.showMessageDialog(null, "Mandatory Fields cannot be Empty!!");  
        }
        });
            
        
        cancel.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
        
            new Patient().setVisible(true);
            dispose();
            }
        });

        n.add(hm);
        b.add(footjl);
        w.add(l2);
        w.add(l3);
        w.add(l4);
        w.add(l5);
        w.add(l6);
        c.add(na);
        c.add(name);
        c.add(fir);
        c.add(mid);
        c.add(last);
        c.add(g);
        c.add(male);
        c.add(m);
        c.add(female);
        c.add(f);
        c.add(dob);
        c.add(date);
        c.add(format);
        c.add(a);
        c.add(address);
        c.add(co);
        c.add(contactno);
        c.add(e);
        c.add(email);
        c.add(p);
        c.add(pin);
        c.add(bg);
        c.add(bld);
        c.add(r);
        c.add(user);
        c.add(check);
        c.add(pw);
        c.add(password);
        c.add(cpw);
        c.add(cpassword);
        c.add(mand);
        c.add(reg);
        c.add(cancel);
        c.add(ch);
        ButtonGroup group = new ButtonGroup();
        group.add(m);
        group.add(f);
        setTitle("Health Mate");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
