package healthmate;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
//import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
//import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Editpro extends JFrame{
  database db=new database();
  ResultSet rs;
  
public Editpro(final String user,final String name,final String add,final String email,final String bld,final String gen,final String phn,final String dob,final String ava,final String md) throws Exception{      
        
       try{
  UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
}
catch(Exception exp)
{

}    
        final JFrame fr=this;
        JPanel n = new JPanel();
        final JPanel c = new JPanel();
        JPanel w = new JPanel();
        JPanel b = new JPanel();
        JLabel nm,a,e,bg,g,p,d,m,z;
        final JTextField nm1,a1,e1,bg1,g1,p1,d1,m1,z1;
        JLabel info=new JLabel("Change the Fields you want to Update..");
        JButton update=new JButton("UPDATE");
        JButton can=new JButton("CANCEL");
        nm=new JLabel("Name:");
        a=new JLabel("Address:");
        z=new JLabel("Pin Code:");
        e=new JLabel("e-mail:");
        d=new JLabel("Date of Birth(YYYY-MM-DD):");
        bg=new JLabel("Blood group:");
        g=new JLabel("Gender(M/F):");
        p=new JLabel("Contact no:");
        m=new JLabel("Major Diseases:");
        final ImageIcon image = new ImageIcon(getClass().getResource("load2.gif"));
        //JLabel img;
        final JLabel img = new JLabel();
        nm1=new JTextField(name);
        a1=new JTextField(add);
        z1=new JTextField(ava);
        e1=new JTextField(email);
        d1=new JTextField(dob);
        bg1=new JTextField(bld);
        g1=new JTextField(gen);
        p1=new JTextField(phn);
        m1=new JTextField(md);
        add(n, BorderLayout.NORTH);
        add(c, BorderLayout.CENTER);
        add(w, BorderLayout.WEST);
        add(b, BorderLayout.SOUTH);
        w.setPreferredSize(new Dimension(200, 1000));
        n.setPreferredSize(new Dimension(1000, 60));
        b.setPreferredSize(new Dimension(1000, 50));
        w.setLayout(null);
        w.setPreferredSize(new Dimension(200, 1000));
        JLabel hm = new JLabel("Health Mate");
        w.setSize(new Dimension(1000, 500));

        w.setBackground(new Color(150, 0, 0));
        n.setBackground(new Color(0, 37, 74));
        c.setBackground(new Color(255, 250, 238));
        b.setBackground(new Color(38, 74, 112));
        c.setLayout(null);
        hm.setFont(new Font("SansSerif", 4, 32));
        hm.setForeground(Color.WHITE);
        JLabel footjl = new JLabel("Copyright 2013,Health Mate");

        footjl.setFont(new Font("SansSerif", 4, 11));
        footjl.setForeground(Color.WHITE);
        info.setFont(new Font("SansSerif", 4, 15));
        info.setForeground(Color.RED);
        info.setBounds(10,10,300,40);
        nm.setBounds(10,60,200,25);
        a.setBounds(10,90,200,25);
        e.setBounds(10,120,200,25);
        d.setBounds(10,150,200,25);
        bg.setBounds(10,180,200,25);
        g.setBounds(10,210,200,25);
        p.setBounds(10,240,200,25);
        m.setBounds(10,270,200,25);
        nm1.setBounds(250,60,200,25);
        a1.setBounds(250,90,200,25);
        z.setBounds(470,90,200,25);
        z1.setBounds(550,90,200,25);
        
        e1.setBounds(250,120,200,25);
        d1.setBounds(250,150,200,25);
        bg1.setBounds(250,180,200,25);
        g1.setBounds(250,210,200,25);
        p1.setBounds(250,240,200,25);
        m1.setBounds(250,270,200,25);
        update.setBounds(250, 310, 100, 30);
        can.setBounds(10, 310, 100, 30);
        img.setBounds(100,330,200,250);;
        
        c.add(info);
        c.add(nm);
        c.add(a);
        c.add(z);
        c.add(e);
        c.add(d);
        c.add(bg);
        c.add(g);
        c.add(p);
        c.add(m);
        c.add(nm1);
        c.add(a1);
        c.add(z1);
        c.add(e1);
        c.add(d1);
        c.add(bg1);
        c.add(g1);
        c.add(p1);
        c.add(m1);
        c.add(update);
        c.add(can);
        c.add(img);
        update.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        
            img.setIcon(image);
            img.setText("Updating...");
            String name1=nm1.getText();
            String add1=a1.getText();
            String email1=e1.getText();
            String bld1=bg1.getText();
            String gen1=g1.getText();
            String phn1=p1.getText();
            String dob1=d1.getText();
            String zip1=z1.getText();
            String md1=m1.getText();
            SwingWorker worker=new Workere(img,user,name1,add1,email1,bld1,gen1,phn1,dob1,zip1,md1,fr);
            worker.execute();
            /*db.connect();
             db.stmt.executeUpdate("Update table1 set name='"+nm1.getText()+"',address='"+a1.getText()+"',email='"+e1.getText()+"',dob='"+d1.getText()+"',blood_group='"+bg1.getText()+"',phn_no='"+p1.getText()+"',major_diseases='"+m1.getText()+"',zip='"+z1.getText()+"' where id='"+user+"'");
             JOptionPane.showMessageDialog(null, "Your profile is Updated successfully!!");
             db.disconnect();
             new Project(user,nm1.getText(),a1.getText(),e1.getText(),bg1.getText(),g1.getText(),p1.getText(),d1.getText(),z1.getText(),m1.getText()).setVisible(true);
             dispose();
        }catch(Exception exp){
        JOptionPane.showMessageDialog(null, "Error in Updation!");
        }*/
        }
        });
        can.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ev){
            try {
                Project project = new Project(user,name,add,email,bld,gen,phn,dob,ava,md);
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(Editpro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        });
        n.add(hm);
        b.add(footjl);
        setTitle("Health Mate");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) throws Exception{
        
        new Editpro(null, null, null, null, null, null, null, null, null, null);
    }
}