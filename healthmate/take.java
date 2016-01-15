package healthmate;

import static healthmate.report.setLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

public class take extends JFrame{
    database db=new database();
    ResultSet rs;
    JPanel head, foot, left, center;
    JLabel headjl, footjl;
    JLabel home,doc,shift,note;
    JButton take;
    JTextField doc1,shift1;
    String sh;
    JFrame fr=this;
    public take(final String user,final String name,final String add,final String email,final String bld,final String gen,final String phn,final String dob,final String ava,final String md) throws Exception{
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
        
        headjl = new JLabel("Health Mate");
        headjl.setFont(new Font("SansSerif", 4, 32));
        headjl.setForeground(Color.WHITE);
        JLabel footjl = new JLabel("Copyright 2013,Health Mate");

        footjl.setFont(new Font("SansSerif", 4, 11));
        footjl.setForeground(Color.WHITE);
        head.add(headjl, "Center");

        foot.add(footjl);

        head.setBackground(new Color(0, 37, 74));
        foot.setBackground(new Color(38, 74, 112));
        left.setBackground(new Color(150, 0, 0));
        center.setBackground(new Color(255, 250, 238));

        center.setLayout(null);
        home = new JLabel("HOME");
        home.setFont(new Font("SansSerif", 4, 15));
        home.setForeground(Color.BLUE);
        home.setBounds(1000,10,100,25);
        center.add(home);
        doc = new JLabel("Select Doctor:");
        note = new JLabel("NOTE: These Appointments are taken for NEXT day only..");
        
        shift = new JLabel("Select Shift:");
        final JRadioButton m=new JRadioButton();
        final JRadioButton e=new JRadioButton();
        JLabel mor = new JLabel("Morning");
        JLabel eve = new JLabel("Evening");
        final JComboBox doclist=new JComboBox();
        take=new JButton("TAKE");
        doclist.setBounds(190,100, 200, 30);
       
        doc.setFont(new Font("SansSerif", 4, 15));
        doc.setForeground(new Color(153,0,0));
        note.setFont(new Font("SansSerif", 4, 15));
        note.setForeground(new Color(153,0,0));
        shift.setFont(new Font("SansSerif", 4, 15));
        shift.setForeground(new Color(153,0,0));
        mor.setFont(new Font("SansSerif", 4, 14));
        eve.setFont(new Font("SansSerif", 4, 14));
       final ImageIcon image = new ImageIcon(getClass().getResource("load2.gif"));
        //final JLabel img = new JLabel("", image, JLabel.CENTER);
        final JLabel img = new JLabel();
        //img.setIcon(image);
        img.setBounds(200,250,200,250);
               
        doc.setBounds(50,100, 130, 25);
        note.setBounds(50,50, 430, 30);
        shift.setBounds(50,150, 100, 25);
        mor.setBounds(190,150, 70, 25);
        m.setBounds(270,150, 50, 25);
        eve.setBounds(330,150, 70, 25);
        e.setBounds(410,150, 50, 25);
        take.setBounds(250, 220, 100, 30);
        home.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    Project project = new Project(user,name,add,email,bld,gen,phn,dob,ava,md);
                    dispose();
                }catch(Exception ex){  
            }
            }});
        try{
        db.connect();
        rs= db.stmt.executeQuery("Select * from table4");
              while(rs.next()){
                 String name1=rs.getString("name");
               
                  doclist.addItem(name1); 
              }    
        db.disconnect();
        }catch(Exception ex){}
        
        take.addActionListener(new ActionListener(){
        
            @Override
        public void actionPerformed(ActionEvent ev){
           img.setIcon(image);
           img.setText("Please Wait..");
           if(m.isSelected()){
         sh="m";
        } else if(e.isSelected())
            sh="e";
        else 
            sh="n";
            Calendar cal = Calendar.getInstance();
                     cal.add(Calendar.DATE, 1);
                     SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                     String formatted = format1.format(cal.getTime());
           String dname = (String)doclist.getSelectedItem();
           SwingWorker worker=new Worker(img,user,name,add,email,bld,gen,phn,dob,ava,md,dname,sh,fr);
           worker.execute();
           /* try{
                //db.connect();
            
        rs=db.stmt.executeQuery("Select * from table4 where name='"+dname+"'");
              rs.next();
                 final String id=rs.getString("dr_id");
                 String mst=rs.getString("mor_start");
                 String est=rs.getString("eve_start");
                 int mmax=rs.getInt("mor_max");
                 int emax=rs.getInt("eve_max");
                 int mava=rs.getInt("mor_ava");
                 int eava=rs.getInt("eve_ava");
              
                 if(m.isSelected()){
                     if(mava>0){
                     String a=morning(mst,mmax,mava);
                     int mor =mava-1;
                     db.stmt.executeUpdate("Update table4 set mor_ava="+mor+" where name='"+dname+"'");
                     try{
                     rs= db.stmt.executeQuery("Select * from table3 where id='"+user+"' and dr_id='"+id+"' and date='"+formatted+"'");
                     rs.next();
                     int s=rs.getInt("status");
                     JOptionPane.showMessageDialog(null, "You already have an Appointment for this doctor!");    
                     
                     }catch(Exception ex){
                     db.stmt.executeUpdate("insert into table3 values(NULL,'"+user+"','"+id+"','"+formatted+"','"+a+"',0)");
                     JOptionPane.showMessageDialog(null, "Your Appointment is taken in morning shift for "+a);
                     Project project = new Project(user,name,add,email,bld,gen,phn,dob,ava,md);
                     dispose();
                     }
                     }
                     else{
                     JOptionPane.showMessageDialog(null, "No Appointments are available for this Shift");
                     }
                 }
                 else if(e.isSelected()){
                     if(eava>0){
                     String a=evening(est,emax,eava);
                     int mor =eava-1;
                     db.stmt.executeUpdate("Update table4 set eve_ava="+mor+" where name='"+dname+"'");
                     try{
                     rs= db.stmt.executeQuery("Select * from table3 where id='"+user+"' and dr_id='"+id+"'");
                     rs.next();
                     int s=rs.getInt("status");
                     JOptionPane.showMessageDialog(null, "You already have an Appointment for this doctor!");    
                     
                     }catch(Exception ex){
                     db.stmt.executeUpdate("insert into table3 values(NULL,'"+user+"','"+id+"','"+formatted+"','"+a+"',0)");
                     //db.stmt.executeUpdate("Update table4 set eve_ava=eava-1");
                     JOptionPane.showMessageDialog(null, "Your Appointment is taken in Evening shift for "+a);
                     Project project = new Project(user,name,add,email,bld,gen,phn,dob,ava,md);
                     }
                     }
                     else{
                     JOptionPane.showMessageDialog(null, "No Appointments are available for this Shift");
                     }
                     }
                 else{
                 JOptionPane.showMessageDialog(null, "Please select a Shift!");
                 
                 }
                 db.disconnect();
            }catch(Exception ex){
                System.out.println("m here"+ex);
        }*/
        }
        });
        center.add(note);
        center.add(doc);
        center.add(doclist);
        center.add(shift);
        center.add(mor);
        center.add(m);
        center.add(eve);
        center.add(e);
        center.add(take);
        center.add(img);
        
        ButtonGroup group = new ButtonGroup();
        group.add(m);
        group.add(e);

        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    
}
  /*  public String morning(String mst,int mmax,int mava) throws Exception{
    //int app=(mmax-mava)*15+mst;
        String myTime = mst;
 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
 Date d = df.parse(myTime); 
 Calendar cal = Calendar.getInstance();
 cal.setTime(d);
 cal.add(Calendar.MINUTE, (mmax-mava)*15);
 String newTime = df.format(cal.getTime());
    
    return newTime;
    }
    public String evening(String est,int emax,int eava) throws Exception{
    String myTime = est;
 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
 Date d = df.parse(myTime); 
 Calendar cal = Calendar.getInstance();
 cal.setTime(d);
 cal.add(Calendar.MINUTE, (emax-eava)*15);
 String newTime = df.format(cal.getTime());
    //JOptionPane.showMessageDialog(null, "Your Appointment is taken in morning shift for "+newTime);
    return newTime;
    }*/
}