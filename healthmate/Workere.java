/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthmate;

import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author atindramardikar
 */
public class Workere extends SwingWorker<Void, ImageIcon>{
    database db = new database();
    ResultSet rs;
    JFrame fd;
    JLabel img;
    String u,n,a,e,b,g,p,d,z,m;
    public Workere(final JLabel label,final String user,final String name,final String add,final String email,final String bld,final String gen,final String phn,final String dob,final String ava,final String md,JFrame fr){
    super();
    this.u=user;
    this.n=name;
    this.a=add;
    this.e=email;
    this.b=bld;
    this.g=gen;
    this.p=phn;
    this.d=dob;
    this.z=ava;
    this.m=md;
    this.fd=fr;
    this.img=label;
    }
    @Override
    protected void done() {
        img.setIcon(null);
        img.setText(null);
        
        

    }
    @Override
    protected Void doInBackground() throws Exception {
      try{
        db.connect();
             db.stmt.executeUpdate("Update table1 set name='"+n+"',address='"+a+"',email='"+e+"',dob='"+d+"',blood_group='"+b+"',phn_no='"+p+"',major_diseases='"+m+"',zip='"+z+"' where id='"+u+"'");
             JOptionPane.showMessageDialog(null, "Your profile is Updated successfully!!");
             db.disconnect();
             new Project(u,n,a,e,b,g,p,d,z,m).setVisible(true);
             fd.dispose();
        }catch(Exception exp){
        JOptionPane.showMessageDialog(null, "Error in Updation!");
        }
        return null;
    }
    
}
