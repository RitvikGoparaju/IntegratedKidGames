package integratedkidgames.main;

import integratedkidgames.Game;
import integratedkidgames.colorfind.ColorFind;
import integratedkidgames.arcadegame.ClassicArcade;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javafx.application.Platform.exit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the Main class that initiates the portal. It extends Game class only
 * for the sake of GUI Frame
 *
 *
 * @author GVKC Ritvik, IIIT - Bengaluru
 */
public class Main extends Game {

    // Panels
    private JPanel p;
    private JPanel container;
    private JPanel pHeading;
    private JPanel pLab;
    //Buttons
    private JButton b1;
    private JButton b2;
    //Labels
    private JLabel labHeading;
    private JLabel lab;

    /**
     *
     */
    public Main() {
        super("Games Portal for Kids", "Games4Kids", 0);
        container = new JPanel();
        p = new JPanel();
        pHeading = new JPanel();
        pLab = new JPanel();
        b1 = new JButton("Color Find");
        b2 = new JButton("Classic Arcade");
        labHeading = new JLabel();
        lab = new JLabel();
        container.setSize(600, 600);
        p.setSize(600, 200);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        lab.setText("Click on a game to play!");
        lab.setFont(new Font("Serif", Font.PLAIN, 14));
        pHeading.add(labHeading);
        pLab.add(lab);
        container.add(pHeading);
        container.add(p);
        container.add(pLab);
        b1.setPreferredSize(new Dimension(150, 100));
        b1.setBackground(new Color(32, 77, 116));
        b1.setForeground(Color.white);
        b2.setPreferredSize(new Dimension(150, 100));
        b2.setBackground(new Color(32, 77, 116));
        b2.setForeground(Color.white);
        p.add(b1);
        p.add(b2);
        gameFrame.gamePanel.add(container);
        gameFrame.frame.setVisible(true);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ColorFind cF = new ColorFind("Color Find", "ColorFind", 10);
                gameFrame.frame.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClassicArcade classicArcade = new ClassicArcade("Classic Arcade", "ClassicArcade", 10);
                gameFrame.frame.dispose();
            }
        });

        gameFrame.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.frame.dispose();
                System.exit(0);
            }
        });
    }

    /**
     * The portal starting main method
     *
     * @param args
     */
    public static void main(String args[]) {
        Main main = new Main();
    }
}
