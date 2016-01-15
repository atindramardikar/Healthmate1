package healthmate;



import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class report extends JFrame {
    
    database db=new database();
    ResultSet rs;
    JPanel head, foot, left, center;
    JLabel headjl, footjl;
    JLabel home;
    DefaultTableModel dtm;
    JTable jt=new JTable();
    JLabel jl1 = new JLabel("ID:");
    JLabel jl2 = new JLabel("DATE:");
    JLabel jl3 = new JLabel("SYMPTOMS:");
    JLabel jl4 = new JLabel("DIAGNOSIS:");
    JLabel jl5 = new JLabel("PRESCRIPTION:");
    JLabel jl6 = new JLabel("BP:");
    JLabel jl7 = new JLabel("BP_DIA:");
    JLabel jl8 = new JLabel("REVIEW:");
    JLabel jl9 = new JLabel("REFERENCE:");
    JButton jb1 = new JButton("NEXT >>");
    JButton jb2 = new JButton("<< PREVIOUS");
    

    JLabel id = new JLabel();
    JLabel bp1 = new JLabel();
    JLabel bp2 = new JLabel();
    JLabel date = new JLabel();
    JLabel rev = new JLabel();

    JLabel sym = new JLabel();
    JLabel diag = new JLabel();
    JLabel pres = new JLabel();
    JLabel ref = new JLabel();
    String p;
    JScrollPane pane = new JScrollPane();
    String[]data=new String[100];
    
      String p1;
    JScrollPane pane1 = new JScrollPane();
    String[]data1=new String[100];
    DefaultTableModel dtm1;
    JTable jt1=new JTable();
    
     String p2;
    JScrollPane pane2 = new JScrollPane();
    String[]data2=new String[100];
    DefaultTableModel dtm2;
    JTable jt2=new JTable();
    

    public report(final String user,final String name,final String add,final String email,final String bld,final String gen,final String phn,final String dob,final String ava,final String md) throws Exception {
        //super(p1, true);
        dtm=new DefaultTableModel();
        jt.setModel(dtm);
        dtm.addColumn("");
        
          dtm1 = new DefaultTableModel();
        jt1.setModel(dtm1);
        dtm1.addColumn("");
        
         dtm2 = new DefaultTableModel();
        jt2.setModel(dtm2);
        dtm2.addColumn("");
        
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
        
        //head.setLayout(null);
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
        pane.setBackground(new Color(255, 250, 238));
        
        jl1.setFont(new Font("SansSerif", 4, 15));
        jl1.setForeground(Color.RED);
        jl2.setFont(new Font("SansSerif", 4, 15));
        jl2.setForeground(Color.RED);
        jl3.setFont(new Font("SansSerif", 4, 15));
        jl3.setForeground(Color.RED);
        jl4.setFont(new Font("SansSerif", 4, 15));
        jl4.setForeground(Color.RED);
        jl5.setFont(new Font("SansSerif", 4, 15));
        jl5.setForeground(Color.RED);
        jl6.setFont(new Font("SansSerif", 4, 15));
        jl6.setForeground(Color.RED);
        jl7.setFont(new Font("SansSerif", 4, 15));
        jl7.setForeground(Color.RED);
        jl8.setFont(new Font("SansSerif", 4, 15));
        jl8.setForeground(Color.RED);
        jl9.setFont(new Font("SansSerif", 4, 15));
        jl9.setForeground(Color.RED);
        
        id.setFont(new Font("SansSerif", 4, 15));
        id.setForeground(Color.BLACK);
        date.setFont(new Font("SansSerif", 4, 15));
        date.setForeground(Color.BLACK);
        sym.setFont(new Font("SansSerif", 4, 15));
        sym.setForeground(Color.BLACK);
        diag.setFont(new Font("SansSerif", 4, 15));
        diag.setForeground(Color.BLACK);
        pres.setFont(new Font("SansSerif", 4, 15));
        pres.setForeground(Color.BLACK);
        bp1.setFont(new Font("SansSerif", 4, 15));
        bp1.setForeground(Color.BLACK);
        bp2.setFont(new Font("SansSerif", 4, 15));
        bp2.setForeground(Color.BLACK);
        rev.setFont(new Font("SansSerif", 4, 15));
        rev.setForeground(Color.BLACK);
        ref.setFont(new Font("SansSerif", 4, 15));
        ref.setForeground(Color.BLACK);

        jl1.setBounds(50, 50, 50, 20);
        jl2.setBounds(50, 80, 50, 20);
        jl3.setBounds(50, 110, 150, 20);
        jl4.setBounds(50, 200, 150, 20);
        jl5.setBounds(50, 290, 150, 20);
        jl6.setBounds(50, 380, 70, 20);
        jl7.setBounds(50, 410, 70, 20);
        jl8.setBounds(50, 440, 100, 20);
        jl9.setBounds(50, 470, 100, 20);

        id.setBounds(200, 50, 100, 20);
        date.setBounds(200, 80, 100, 20);
        pane2.setBounds(200, 110, 150, 80);
        pane1.setBounds(200, 200, 150, 80);
        pane.setBounds(200, 290, 200, 80);
        bp1.setBounds(200, 380, 100, 20);
        bp2.setBounds(200, 410, 100, 20);
        rev.setBounds(200, 440, 100, 20);
        ref.setBounds(200, 470, 150, 20);

        jb2.setBounds(50, 520, 120, 30);
        jb1.setBounds(210, 520, 120, 30);
        

        home = new JLabel("HOME");
        home.setFont(new Font("SansSerif", 4, 15));
        home.setForeground(Color.BLUE);
        home.setBounds(1000,10,100,25);
        center.add(home);
        home.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    Project project = new Project(user,name,add,email,bld,gen,phn,dob,ava,md);
                report.this.dispose();
                db.disconnect();
            }catch(Exception ex){
                
            }
            }
        });

        center.add(jl1);
        center.add(jl2);
        center.add(jl3);
        center.add(jl4);
        center.add(jl5);
        center.add(jl6);
        center.add(jl7);
        center.add(jl8);
        center.add(jl9);

        center.add(id);
        center.add(date);
        center.add(pane2);
        center.add(pane1);
        center.add(pane);
        center.add(bp1);
        center.add(bp2);
        center.add(rev);
        center.add(ref);

        center.add(jb1);
        center.add(jb2);
        
        center.revalidate();


        
        jb1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                for(int i=0;i<data.length;i++)  
                    data[i]="";
                n_retrive();
            }

        });

        jb2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //retrive();
                for(int i=0;i<data.length;i++)  
                    data[i]="";
                p_retrive();
            }
        });
        
        try {
            
            db.connect();
           
            rs = db.retrivefromdb(user);
            System.out.println("records taken successfully");
           
        } catch (SQLException ex) {
            System.out.println(ex);
        }      
        retrive();
            
        

        setMinimumSize(new Dimension(1200, 900));
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

    public void n_retrive() {

        try {

            // System.out.println("record taken successfully");
            if (rs.next()) {
                System.out.println("inside next loop");

                System.out.println(rs.getRow());
                fun();
                /*
                id.setText(rs.getString("id"));
                date.setText(rs.getString("Date"));
                sym.setText(rs.getString("Symptoms"));
                diag.setText(rs.getString("Diagnosis"));
                p= rs.getString("Medical_Prescription");
                
                for(int i=0;i<data.length;i++)  
                    data[i]="";
                dtm.setRowCount(0); 
                data=p.split(",");
            for(int i=0;i<data.length;i++)
                
                dtm.addRow(new Object[]{data[i],Comments/Assignment value});
            
            jt.setBackground(new Color(255, 250, 238));
           
            pane.setViewportView(jt);
                bp1.setText(rs.getString("BP_sys"));
                bp2.setText(rs.getString("BP_dia"));
                rev.setText(rs.getString("Review"));
                ref.setText(rs.getString("Reference"));*/
                

            } else {
                JOptionPane.showMessageDialog(this, "No More Next Records!");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void p_retrive() {

        try {

            //    System.out.println("record taken successfully");
            if (rs.previous()) {
                System.out.println("inside previos loop");

                System.out.println(rs.getRow());
               /* id.setText(rs.getString("id"));
                date.setText(rs.getString("Date"));
                sym.setText(rs.getString("Symptoms"));
                diag.setText(rs.getString("Diagnosis"));
                p= rs.getString("Medical_Prescription");
                for(int i=0;i<data.length;i++)  
                    data[i]="";
                dtm.setRowCount(0);
                data=p.split(",");
            for(int i=0;i<data.length;i++)
                
                dtm.addRow(new Object[]{data[i],Comments/Assignment value});
            
            jt.setBackground(new Color(255, 250, 238));
           
            pane.setViewportView(jt);
                bp1.setText(rs.getString("BP_sys"));
                bp2.setText(rs.getString("BP_dia"));
                rev.setText(rs.getString("Review"));
                ref.setText(rs.getString("Reference"));*/
                fun();

            } else {
                JOptionPane.showMessageDialog(this, "No More Previous Records!");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void retrive() {
        try {

            // System.out.println("record taken successfully");
            if (rs.last()) {
                System.out.println("Getting latest record...");
                System.out.println("inside last loop");

                System.out.println(rs.getRow());

              /*  id.setText(rs.getString("id"));
                date.setText(rs.getString("Date"));
                sym.setText(rs.getString("Symptoms"));
                diag.setText(rs.getString("Diagnosis"));
                p= rs.getString("Medical_Prescription");
                //String[]data=new String[100];
                for(int i=0;i<data.length;i++)  
                    data[i]="";
                dtm.setRowCount(0);
                data=p.split(",");
            for(int i=0;i<data.length;i++)
                
                dtm.addRow(new Object[]{data[i],Comments/Assignment value});
            
            jt.setBackground(new Color(255, 250, 238));
           
            pane.setViewportView(jt);
                bp1.setText(rs.getString("BP_sys"));
                bp2.setText(rs.getString("BP_dia"));
                rev.setText(rs.getString("Review"));
                ref.setText(rs.getString("Reference")); */
                fun();
               
            } else {
                JOptionPane.showMessageDialog(this, "Not a Single Record is Present!!");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
     public void fun()
    {
        try
        {
        id.setText(rs.getString("id"));
                date.setText(rs.getString("Date"));
               // sym.setText(rs.getString("Symptoms"));
                
                 p2=rs.getString("Symptoms");
                 for(int i=0;i<data2.length;i++)  
                    data2[i]="";
                dtm2.setRowCount(0); 
                data2=p2.split(",");
            for(int i=0;i<data2.length;i++)
                
                dtm2.addRow(new Object[]{data2[i],/*Comments/Assignment value*/});
            
            jt2.setBackground(new Color(255, 250, 238));
           
            pane2.setViewportView(jt2);
                
                //diag.setText(rs.getString("Diagnosis"));
                p1=rs.getString("Diagnosis");
                 for(int i=0;i<data1.length;i++)  
                    data1[i]="";
                dtm1.setRowCount(0); 
                data1=p1.split(",");
            for(int i=0;i<data1.length;i++)
                
                dtm1.addRow(new Object[]{data1[i],/*Comments/Assignment value*/});
            
            jt1.setBackground(new Color(255, 250, 238));
           
            pane1.setViewportView(jt1);
                
                p=rs.getString("Medical_Prescription");
                 for(int i=0;i<data.length;i++)  
                    data[i]="";
                dtm.setRowCount(0); 
                data=p.split(",");
            for(int i=0;i<data.length;i++)
                
                dtm.addRow(new Object[]{data[i],/*Comments/Assignment value*/});
            
            jt.setBackground(new Color(255, 250, 238));
           
            pane.setViewportView(jt);
                bp1.setText(rs.getString("BP_sys"));
                bp2.setText(rs.getString("BP_dia"));
                rev.setText(rs.getString("Review"));
                ref.setText(rs.getString("Reference"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    }


