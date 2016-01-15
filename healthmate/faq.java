package healthmate;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atindramardikar
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author user
 */
public class faq extends JFrame {

   
    ImageIcon image = new ImageIcon(getClass().getResource(""));
    JLabel home = new JLabel("HOME");
    JScrollPane jsp;
    JLabel cnt = new JLabel("<html>"
            + "<body>\n"
            + "<div id=\"wrapper\">\n"
            + "<div id=\"main\">\n"
            + "    <div class=\"container\"><style=color:red;>\n"
            + "            <h1>Frequently Asked Questions</style></h1>\n"
            + "            <hr />\n"
            + "\n"
            + "            <section id=\"faq-list\">\n"
            + "<style=color:red;>                \n"
            + "                <h2>Why choose Health Mate?</style></h2>\n"
            + "                <div class=\"answer\">\n"
            + "                    <p>\n"
            + "				<ol>\n"
            + "				<li>Health Mate app connects you and your doctor free of cost.  </li>\n"
            + "				<li>It organizes your treatment details.	</li>\n"
            + "				<li>It saves the waiting time.		</li>\n"
            + "				<li>It also helps maintaining the privacy for patients.</li>\n"
            + "</ol>\n"
            + "                    </p>\n"
            + "                </div>\n"
            + "            \n"
            + "     <style=color:red;>       \n"
            + "                <h2>How does one register for Health Mate?</style></h2>\n"
            + "                <div class=\"answer\">\n"
            + "                    <p>\n"
            + "					Patients register for Health Mate app by following ways-<br><br>\n"
            + "a) by visiting our website www.healthmate.org.<br><br>\n"
            + "b) via HealthMate app available on playstore.<br><br>\n"
            + "                       \n"
            + "                    </p>\n"
            + "                </div>\n"
            + "            \n"
            + "         <style=color:red;>   \n"
            + "                <h2>What if I loose my user id?</style></h2>\n"
            + "                <div class=\"answer\">\n"
            + "                    <p>\n"
            + "                       We advise you to remember your user-id, as it is the only key by which you can access your data.However if you loose the id,just drop in<br> the mail at support@healthmate.com with your full-name and phone-no that you provided at time of registration.We assure you that you  would get your id back within an hour.\n"
            + "                    </p>\n"
            + "                </div>\n"
            + "               <style=color:red;>         \n"
            + "                <h2>How to take an appointment?</style></h2>\n"
            + "                <div class=\"answer\">\n"
            + "                    <p>\n"
            + "                       Step 1 : First log into the application.<br><br>\n"
            + "Step 2: Go to Navigation pane(one that appears red on the left) and select take appointment.<br><br>\n"
            + "Step 3: Choose the doctor you want to visit and the appropiate timing that suits you.<br><br>\n"
            + "DONE!\n"
            + "\n"
            + "                    </p>\n"
            + "                </div><style=color:red;>\n"
            + "               <h2>How can I see my last visit details?</style></h2>\n"
            + "                <div class=\"answer\">\n"
            + "                    <p>\n"
            + "		Step 1: Log in to the application<br><br>\n"
            + "		Step 2: Go to Navigation pane(one that appears red on the left) and select view reports.<br><br>\n"
            + "		Step 3: You can thus navigate through details starting from last visit till first visit<br><br>\n"
            + "                    </p>\n"
            + "                </div>\n"
            + "          <style=color:red;>  \n"
            + "                <h2>What if there is an\n"
            + " emergency?</style></h2>\n"
            + "                <div class=\"answer\">\n"
            + "                    <p>\n"
            + "	As such HM 1.0 is designed keeping in mind regular check up for a patient.The software do not provide any assurances against emergency cases and rest those for doctor's concern. \n"
            + "                       \n"
            + "                   </p>\n"
            + "                </div>\n"
            + "            </section>\n"
            + "\n"
            + "        \n"
            + "    </div>\n"
            + "</div>\n"
            + "</div>\n"
            + "\n"
            + "\n"
            + "\n"
            + "</body>\n"
            + "</html>");

    public faq() {
        
        
        JPanel n = new JPanel();
        JPanel c = new JPanel();
        JPanel w = new JPanel();
        JPanel s = new JPanel();

        add(n, BorderLayout.NORTH);
        add(c, BorderLayout.CENTER);
        add(w, BorderLayout.WEST);
        add(s, BorderLayout.SOUTH);

        w.setBackground(new Color(150, 0, 0));
        n.setBackground(new Color(0, 37, 74));
        c.setBackground(new Color(255, 250, 238));
        s.setBackground(new Color(38, 74, 112));

        w.setPreferredSize(new Dimension(200, 1000));
        n.setPreferredSize(new Dimension(1000, 60));
        s.setPreferredSize(new Dimension(1000, 50));
        w.setPreferredSize(new Dimension(200, 1000));

        w.setLayout(null);
        c.setLayout(null);

        home.setFont(new Font("SansSerif", 4, 15));
        home.setForeground(Color.white);
        home.setBounds(50, 0, 100, 50);
        w.add(home);

        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Patient().setVisible(true);
                dispose();
            }
        });
        jsp = new JScrollPane(cnt);
        jsp.setBounds(0, 0, 1100, 596);
        jsp.setBackground(new Color(255, 250, 238));
        jsp.setOpaque(false);

        c.add(jsp);

        JLabel hm = new JLabel("Health Mate");
        hm.setFont(new Font("SansSerif", 4, 32));
        hm.setForeground(Color.WHITE);

        JLabel footjl = new JLabel("Copyright 2013,Health Mate");
        footjl.setFont(new Font("SansSerif", 4, 11));
        footjl.setForeground(Color.WHITE);

        n.add(hm);
        s.add(footjl);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);

    }
}
