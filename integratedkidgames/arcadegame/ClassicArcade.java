package integratedkidgames.arcadegame;

import integratedkidgames.Game;
import integratedkidgames.GameFrame;
import integratedkidgames.main.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.*;

/**
 * This is a game, which is a Java-Swing clone of the Classic Arcade Game
 *
 * @author GVKC Ritvik, IIIT - Bengaluru
 */
public class ClassicArcade extends Game {

    private final JPanel classicArcadePanel;
    private final ArrowKeyPanel arrowKeyPanel;
    private ArrayList<MovingImage> movingImages;

    /**
     * The X-value of the starting position of the "Boy" image
     */
    public final int boyStartX = 210;

    /**
     * The Y-value of the starting position of the "Boy" image
     */
    public final int boyStartY = 400;
    private final Image boy = new Image("images\\char-boy.png", boyStartX, boyStartY);
    private final Image background = new Image("images\\background.png", 0, 0);

    /**
     * The Constructor. It uses same parameters as its super class
     *
     * @param name_
     * @param nameWithoutSpaces_
     * @param timePeriodSecs_
     */
    public ClassicArcade(String name_, String nameWithoutSpaces_, int timePeriodSecs_) {
        super(name_, nameWithoutSpaces_, timePeriodSecs_);
        gameRunning = false;
        this.movingImages = new ArrayList<>();
        this.classicArcadePanel = new JPanel();
        classicArcadePanel.setSize(531, 582);
        classicArcadePanel.setLayout(null);
        for (int i = 0; i < 3; i++) {
            MovingImage bug = createMovingBug(20, i);
            movingImages.add(bug);
            classicArcadePanel.add(movingImages.get(i));
        }
        classicArcadePanel.add(boy);
        classicArcadePanel.add(background);
        //For attaching arrow keys
        arrowKeyPanel = new ArrowKeyPanel(this);
        classicArcadePanel.add(arrowKeyPanel);
        //Attaching this game panel to that of the super class' game panel
        gameFrame.gamePanel.add(classicArcadePanel);
        gameFrame.addControlPanel();
        gameFrame.frame.setVisible(true);
        
        //For starting/restarting the game
        gameFrame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameRunning = true;
                startTime = (new Date()).getTime();
                score = 0;
                gameFrame.setLabel("SCORE", "0");
                startTime = System.currentTimeMillis();
                elapsedTime = 0L;
                totalTime = timePeriodSecs * 1000;
                gameFrame.setLabel("TIME", String.valueOf(timePeriodSecs));
                boy.resetPosition(210, 400);
                movingImages.get(0).setGameRunning();
                movingImages.get(1).setGameRunning();
                movingImages.get(2).setGameRunning();
            }
        });
        
        //For exiting the game
        gameFrame.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.frame.dispose();
                Main main = new Main();
            }
        });
    }
    
    //Creating the moving bug
    private MovingImage createMovingBug(int startY_, int cntr) {
        int startY = startY_ + (cntr * 90);
        int deltaX = getRandom(10, 1);
        int delay = getRandom(200, 60);
        MovingImage bug = new MovingImage("images\\enemy-bug.png", 0, startY, deltaX, 0, 1, 1, delay);
        return bug;
    }
    
    //Getting random number for setting the speed of the moving bug
    private int getRandom(int max, int min) {
        Random rn = new Random();
        int range = max - min + 1;
        int randomNum = rn.nextInt(range) + min;
        if (randomNum < 0) {
            randomNum *= -1;
        }
        return randomNum;
    }

    /**
     *
     * @return GameFrame to be used by arrowkey panel
     */
    public GameFrame getGameFrame() {
        return gameFrame;
    }

    /**
     *
     * @return bugs for arrowkey panel
     */
    public ArrayList<MovingImage> getAllBugs() {
        return movingImages;
    }

    /**
     *
     * @return boy for arrowkey panel
     */
    public Image getBoy() {
        return boy;
    }
}
