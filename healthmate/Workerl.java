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
class Workerl extends SwingWorker<Void, ImageIcon> {

    database db = new database();
    ResultSet rs;
    JLabel img = new JLabel();
    String userName, passWord;
    JFrame fd;

    public Workerl(JLabel label, String u, String p,JFrame f) {
        super();
        this.img = label;
        this.userName = u;
        this.passWord = p;
        this.fd=f;

    }

    //Executed on the Event Dispatch Thread after the doInBackground method is finished
    @Override
    protected void done() {
        img.setIcon(null);
        img.setText(null);
        
        

    }

    @Override
    protected Void doInBackground() throws Exception {
        login();
        return null;
    }

    public void login() {


        if (!"".equals(userName) && !"".equals(passWord)) {
            try {
                db.connect();
                rs = db.stmt.executeQuery("Select * from table1 where id='" + userName + "' and password='" + passWord + "'");
                rs.next();
                String name = rs.getString("name");
                String add = rs.getString("address");
                String email = rs.getString("email");
                String bld = rs.getString("blood_group");
                String gen = rs.getString("gender");
                String phn = rs.getString("phn_no");
                String dob = rs.getString("dob");
                String ava = rs.getString("zip");
                String md = rs.getString("major_diseases");
                db.disconnect();
                new Project(userName, name, add, email, bld, gen, phn, dob, ava, md).setVisible(true);
                fd.dispose();
                //Patient().ABORT;

            } catch (Exception exp) {
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Username or Password cannot be empty!");
        }
    }
}
