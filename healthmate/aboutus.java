package healthmate;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author atindramardikar
 */
public class aboutus extends JFrame {
JLabel abt,btn;
JScrollPane jsp;
JPanel jp;
public aboutus(){
        setLayout(null);
        abt=new JLabel("<html>" +
"<body>\n" +
"<style=color:red;>"+
"<h2>About Us</style></h2>\n" +
"\n" +
"<b>\n" +
"Health Mate is a free user friendly application that integrates entire process of taking the appointments; medical check-up and treatment in one go.<br> At the heart of Health Mate is a centralized database that connects patients, doctors and medical-store owners.</b>\n" +
"<style=color:red;>"+
"<h2>Our Goal</style></h2>\n" +
"<b>\n" +
"Health Mate is developed by five engineering students with an objective of eliminating cumbersome process of taking appointments followed by long waiting<br> and carrying prescriptions. It also facilitates in record-keeping for a doctor.\n" +
"</b>\n" +
"\n" +
"<style=color:red;>"+
"<h2>The idea</style></h2>\n" +
"<b>In the present scenario, patients have to first take an appointment for their check-up either by phone or by visit to hospital in-person. In the next step, they have <br>to ensure that they carry all the necessary reports and prescriptions of previous visit. A patientís treatment is thus dependent on his /her previous reports.<br> At the same time, on a doctorís part it is an uphill task to remember patientís background; provided the prescription is not available at the time of diagnosis.<br> At a later stage, confidentiality of a patientís report is vulnerable, when prescription is presented in a medical-store. <br><br>\n" +
"Health Mate registers a patient in its database via a unique identification key .All the operations from taking appointments to purchase of medicines is by this unique key.<br> It also eliminates the need of prescription with revolutionary concept of e-reports, which a registered patient or a concerned doctor can read anywhere and at any time.<br> It also provides all users its features over the web or as a standalone set-up on the desktop.\n" +
"\n" +
"</b>\n" +
"<style=color:red;>"+
"<h2>Building Blocks</style></h2>\n" +
"<b>\n" +
"Health Mate uses following technologies in its making: <br><br>\n" +
"     ----> Java<br>\n" +
"---->PHP<br>\n" +
"---->Android<br>\n" +
"\n" +
"</b>\n" +
"\n" +
"<style=color:red;>"+
"<h2>Versions and Future Scope</style></h2>\n" +
"<b>\n" +
"Present version of Health Mate (HM 1.0, released November 2013) is targeted at a single hospital having some finite number of doctors. It also takes into<br> consideration the fact that the hospital is having its own pharmacy. HM 2.0 focuses to cover a larger domain of end users. Some striking features like <br>notifications, grouping members of same family and so on are expected to be included in the next release. \n" +
"\n" +
"</b>\n" +
"</body>\n" +
"</html>\n");
        btn=new JLabel("BACK");
        btn.setFont(new Font("SansSerif", 4, 15));
        btn.setForeground(Color.BLUE);
        btn.setBounds(1200, 10, 100, 50);
        abt.setBounds(10, 5, 1300, 700);
        btn.addMouseListener(new MouseAdapter() {
            
            @Override
              public void mouseClicked(MouseEvent e) {
                new Patient().setVisible(true);
                dispose();
    }
           
            

            @Override
    public void mouseEntered(MouseEvent e) {
        btn.setForeground(Color.BLACK);
        btn.setText("<-BACK");
    }

            @Override
    public void mouseExited(MouseEvent e) {
        btn.setText("BACK");
                btn.setForeground(Color.BLUE);
    }
            
        });
        getContentPane().setBackground(new Color(255, 250, 225));
        add(abt);
        add(btn);
        validate();
        setTitle("HealthMate");
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

}    
    public static void main(String[] args) {
        new aboutus();
    }
    
}
