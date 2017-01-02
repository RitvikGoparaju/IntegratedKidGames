package integratedkidgames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The GUI Class, which is used by the Game Class
 *
 * @author GVKC Ritvik, IIIT - Bengaluru
 */
public final class GameFrame {

    /**
     * The main frame, which holds all other components
     */
    public final JFrame frame;

    //Panels
    /**
     * This is the panel, which holds all the detailed panels
     */
    public JPanel container;

    //heading panels
    private JPanel headingTopMarginPanel;
    private JPanel headingPanel;
    private JPanel headingBottomMarginPanel;

    //Left Instructions Panel
    private JPanel instructionsPanel;

    /**
     * The central panel, which is used by the classes that extend "Game Class"
     */
    public JPanel gamePanel;

    //The control panel on the right
    private JPanel controlPanel;
    private JPanel controlButtonPanel;
    private JPanel controlDisplayPanel;
    private JPanel scoreLabelPanel;
    private JPanel scorePanel;
    private JPanel timeLabelPanel;
    private JPanel timePanel;
    private JPanel highScoreLabelPanel;
    private JPanel highScorePanel;
    private JPanel messagePanel;
    private JPanel controlBackPanel;

    //Buttons
    /**
     * This Button, to be used by game classes for starting / restarting the
     * game
     */
    public JButton startButton;

    /**
     * This Button is used to exit the program
     */
    public JButton backButton;

    //Labels
    private JLabel headingLabel;
    private JLabel labelInstructions;
    private JLabel scoreLabel;
    private JLabel actualScoreLabel;
    private JLabel timeLabel;
    private JLabel actualTimeLabel;
    private JLabel highScoreLabel;
    private JLabel highScore;
    private JLabel message;

    /**
     * The Constructor
     */
    public GameFrame() {
        //Initializing Frame
        frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        //Frame will be made visible by the individual game classes

        //Initializing all the panels
        container = new JPanel();
        container.setLayout(null);
        headingPanel = new JPanel();
        headingTopMarginPanel = new JPanel();
        headingTopMarginPanel.setSize(new Dimension(1000, 10));
        headingBottomMarginPanel = new JPanel();
        headingBottomMarginPanel.setSize(new Dimension(1000, 10));
        instructionsPanel = new JPanel();
        gamePanel = new JPanel();
        controlPanel = new JPanel();
        controlButtonPanel = new JPanel();
        controlDisplayPanel = new JPanel();
        scoreLabelPanel = new JPanel();
        scorePanel = new JPanel();
        timeLabelPanel = new JPanel();
        timePanel = new JPanel();
        highScoreLabelPanel = new JPanel();
        highScorePanel = new JPanel();
        messagePanel = new JPanel();
        controlBackPanel = new JPanel();
        controlPanel = new JPanel();

        //Initializing buttons
        startButton = new JButton("START / RESTART");
        startButton.setPreferredSize(new Dimension(200, 50));
        startButton.setBackground(new Color(32, 77, 116));
        startButton.setForeground(Color.white);

        backButton = new JButton("EXIT");
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.setBackground(new Color(32, 77, 116));
        backButton.setForeground(Color.white);

        //Initializing labels
        headingLabel = new JLabel("Heading");
        headingLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        headingLabel.setForeground(Color.white);

        labelInstructions = new JLabel();

        scoreLabel = new JLabel("Score");
        scoreLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        scoreLabel.setForeground(new Color(32, 77, 116));

        actualScoreLabel = new JLabel();
        actualScoreLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        actualScoreLabel.setForeground(new Color(32, 77, 116));

        timeLabel = new JLabel("Time Remaining (secs)");
        timeLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        timeLabel.setForeground(new Color(32, 77, 116));

        actualTimeLabel = new JLabel();
        actualTimeLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        actualTimeLabel.setForeground(new Color(32, 77, 116));

        highScoreLabel = new JLabel("High Score");
        highScoreLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        highScoreLabel.setForeground(new Color(32, 77, 116));

        highScore = new JLabel();
        highScore.setFont(new Font("Calibri", Font.PLAIN, 20));
        highScore.setForeground(new Color(32, 77, 116));

        message = new JLabel("");
        message.setFont(new Font("Calibri", Font.PLAIN, 20));
        message.setForeground(new Color(32, 77, 116));

        message.setFont(new Font("Calibri", Font.PLAIN, 20));
        message.setForeground(new Color(32, 77, 116));

        //Format the panels and labels
        panelInitialize(headingTopMarginPanel, new Color(32, 77, 116), 0, 0, 1000, 100, "null");
        panelInitialize(headingPanel, new Color(32, 77, 116), 0, 0, 1000, 100, "BoxY");
        panelInitialize(headingBottomMarginPanel, new Color(32, 77, 116), 0, 0, 1000, 100, "null");
        panelInitialize(instructionsPanel, new Color(250, 250, 250), 0, 100, 200, 600, "BoxY");
        panelInitialize(gamePanel, new Color(169, 169, 169), 200, 100, 600, 600, "null");
        panelInitialize(controlPanel, new Color(250, 250, 250), 800, 100, 200, 600, "BoxY");
        panelInitialize(controlButtonPanel, new Color(250, 250, 250), 800, 100, 200, 200, "null");
        panelInitialize(controlDisplayPanel, new Color(250, 250, 250), 800, 300, 200, 200, "BoxY");
        panelInitialize(scoreLabelPanel, new Color(250, 250, 250), 800, 300, 200, 50, "null");
        panelInitialize(scorePanel, new Color(250, 250, 250), 800, 350, 200, 50, "null");
        panelInitialize(timeLabelPanel, new Color(250, 250, 250), 800, 400, 200, 50, "null");
        panelInitialize(timePanel, new Color(250, 250, 250), 800, 450, 200, 50, "null");
        panelInitialize(highScoreLabelPanel, new Color(250, 250, 250), 800, 400, 200, 50, "null");
        panelInitialize(highScorePanel, new Color(250, 250, 250), 800, 450, 200, 50, "null");
        panelInitialize(messagePanel, new Color(250, 250, 250), 800, 450, 200, 50, "null");
        panelInitialize(controlBackPanel, new Color(250, 250, 250), 800, 500, 200, 50, "null");
        gamePanel.setLayout(null);
        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        timeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        //Adding compoenents/containers to the container(s)
        headingPanel.add(headingTopMarginPanel);
        headingPanel.add(headingLabel);
        headingPanel.add(headingBottomMarginPanel);
        instructionsPanel.add(labelInstructions);
        controlBackPanel.add(backButton);
        controlPanel.add(controlBackPanel);

        //Adding all detailed panels to the container panel
        container.add(headingPanel);
        container.add(instructionsPanel);
        container.add(gamePanel);
        container.add(controlPanel);

        //Adding the container panel to the frame
        frame.add(container);
    }

    /**
     * Formats the panel
     *
     * @param panel_ - JPanel
     * @param color_ - Color
     * @param positionX_ - X Position
     * @param positionY_ - Y Position
     * @param sizeWidth_ - Width of the panel
     * @param sizeHeight_ - Height of the panel
     * @param layout_ - Layout type
     */
    public void panelInitialize(JPanel panel_, Color color_, int positionX_, int positionY_, int sizeWidth_, int sizeHeight_, String layout_) {
        panel_.setBackground(color_);
        panel_.setLocation(positionX_, positionY_);
        panel_.setSize(new Dimension(sizeWidth_, sizeHeight_));
        switch (layout_) {
            case "BoxX":
                panel_.setLayout(new BoxLayout(panel_, BoxLayout.X_AXIS));
                break;
            case "BoxY":
                panel_.setLayout(new BoxLayout(panel_, BoxLayout.Y_AXIS));
                break;
            case "null1":
                panel_.setLayout(null);
                break;
            default:
                break;
        }
    }

    /**
     * sets the text of the chosen label
     *
     * @param whichLabel - the chosen label
     * @param text_ - text to be displayed
     */
    public void setLabel(String whichLabel, String text_) {
        JLabel label = new JLabel();
        if (whichLabel.equals("HEADING")) {
            label = headingLabel;
        } else if (whichLabel.equals("SCORE")) {
            label = actualScoreLabel;
        } else if (whichLabel.equals("TIME")) {
            label = actualTimeLabel;
        } else if (whichLabel.equals("MESSAGE")) {
            label = message;
            if (text_.equals("Game Over!")) {
                message.setForeground(Color.red);
            } else {
                message.setForeground(new Color(0, 51, 0));
            }
        } else if (whichLabel.equals("HIGH-SCORE")) {
            label = highScore;
        } else if (whichLabel.equals("INSTRUCTIONS")) {
            label = labelInstructions;
        }
        label.setText(text_);
    }

    /**
     * Adding control panel to the frame. This method is invoked by the
     * individual games before making frame visible
     */
    public void addControlPanel() {
        controlButtonPanel.add(startButton);
        scoreLabelPanel.add(scoreLabel);
        scorePanel.add(actualScoreLabel);
        timeLabelPanel.add(timeLabel);
        timePanel.add(actualTimeLabel);
        highScoreLabelPanel.add(highScoreLabel);
        highScorePanel.add(highScore);
        messagePanel.add(message);
        controlDisplayPanel.add(scoreLabelPanel);
        controlDisplayPanel.add(scorePanel);
        controlDisplayPanel.add(timeLabelPanel);
        controlDisplayPanel.add(timePanel);
        controlDisplayPanel.add(highScoreLabelPanel);
        controlDisplayPanel.add(highScorePanel);
        controlDisplayPanel.add(messagePanel);
        controlPanel.add(controlDisplayPanel);
        controlPanel.add(controlButtonPanel);

        startButton.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startButton.setBackground(Color.WHITE);
                startButton.setForeground(new Color(32, 77, 116));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                startButton.setBackground(new Color(32, 77, 116));
                startButton.setForeground(Color.white);
            }
        }
        );

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setBackground(Color.WHITE);
                backButton.setForeground(new Color(32, 77, 116));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(32, 77, 116));
                backButton.setForeground(Color.white);
            }
        });
    }

}
