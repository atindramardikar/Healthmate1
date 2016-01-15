package healthmate;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

/**
 *
 * @author atindramardikar
 */
public class Healthmate extends JFrame{

      JProgressBar pbar;

  static final int MY_MINIMUM = 0;

  static final int MY_MAXIMUM = 100;

  public Healthmate() throws Exception{
    setLookAndFeel();
    pbar = new JProgressBar();
    pbar.setMinimum(MY_MINIMUM);
    pbar.setMaximum(MY_MAXIMUM);
  
    JLabel load=new JLabel("Loading Resources...");
    JLabel hm=new JLabel("HEALTHMATE");
    JLabel pat=new JLabel("PATIENT PRO+");
    JLabel img=new JLabel();
    img.setIcon(new ImageIcon(getClass().getResource("Untitled.png")));
    setLayout(null);
    load.setFont(new Font("SansSerif", 4, 10));
    load.setForeground(Color.BLACK);
    load.setBounds(20, 180, 100, 20);
    hm.setFont(new Font("SansSerif", 20, 30));
    hm.setForeground(new Color(153,0,0));
    hm.setBounds(130, 70, 200, 50);
    pat.setFont(new Font("SansSerif", 15, 20));
    pat.setForeground(new Color(0,0,153));
    pat.setBounds(130, 100, 250, 50);
    img.setBounds(10, 70, 100, 100);
    pbar.setBounds(10, 200, 480, 10);
    setBounds(400, 200, 500, 300);
    add(pbar);
    add(load);
    add(hm);
    add(pat);
    add(img);

    getContentPane().setBackground(new Color(255, 250, 225));
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
      final int percent = i;
      try {
        SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
            updateBar(percent);
            }
        });
        
        java.lang.Thread.sleep(100);
      } catch (InterruptedException e) {
        
      }
    }
    java.lang.Thread.sleep(1000);
    dispose();
    new Patient().setVisible(true);
  }

  public void updateBar(int newValue) { 
      pbar.setValue(newValue);
  }
  public static void setLookAndFeel() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }


  public static void main(String args[]) throws Exception {
    new Healthmate();
    }
}