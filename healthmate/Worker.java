/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthmate;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author atindramardikar
 */
class Worker extends SwingWorker<Void, ImageIcon> {
database db=new database();
    ResultSet rs;
   
        JLabel img = new JLabel();
        String user,name,add,email,bld,gen,phn,dob,ava,md,dname,sh;
        JFrame fd;
        
    
    public Worker(JLabel label,final String u,final String n,final String a,final String e,final String b,final String g,final String p,final String d,final String av,final String m,String dn,String s,JFrame fr){
         super();
         this.img=label;
         this.user=u;
         this.name=n;
         this.add=a;
         this.email=e;
         this.bld=b;
         this.gen=g;
         this.phn=p;
         this.dob=d;
         this.ava=av;
         this.md=m;
         this.dname=dn;
         this.sh=s;
         this.fd=fr;
    }

   

   //Executed on the Event Dispatch Thread after the doInBackground method is finished
   @Override
   protected void done(){
      img.setIcon(null);
      img.setText(null);
      
      
   }

    @Override
    protected Void doInBackground() throws Exception {
        
         //To change body of generated methods, choose Tools | Templates.
                    
            Calendar cal = Calendar.getInstance();
                     cal.add(Calendar.DATE, 1);
                     SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                     String formatted = format1.format(cal.getTime());
           
            try{
                db.connect();
            
        rs=db.stmt.executeQuery("Select * from table4 where name='"+dname+"'");
              rs.next();
                 final String id=rs.getString("dr_id");
                 String mst=rs.getString("mor_start");
                 String est=rs.getString("eve_start");
                 int mmax=rs.getInt("mor_max");
                 int emax=rs.getInt("eve_max");
                 int mava=rs.getInt("mor_ava");
                 int eava=rs.getInt("eve_ava");
              
                 if("m".equals(sh)){
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
                     fd.dispose();
                     }
                     }
                     else{
                     JOptionPane.showMessageDialog(null, "No Appointments are available for this Shift");
                     }
                 }
                 else if("e".equals(sh)){
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
                     fd.dispose();
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
        }
    return null;
    }
   public String morning(String mst,int mmax,int mava) throws Exception{
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
    }
 
 }
