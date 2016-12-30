package integratedkidgames.arcadegame;

import integratedkidgames.GameFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * This class is a panel, which holds arrow keys to be used in Classic Arcade
 * Game
 *
 * @author GVKC Ritvik, IIIT - Bengaluru
 */
public class ArrowKeyPanel extends JPanel {

    private ClassicArcade classicArcade;
    private GameFrame gameFrame;
    private Image player;
    private ArrayList<MovingImage> movingImages;
    private int x;
    private int y;
    private int startX;
    private int startY;
    private String[] commands = {
        "UP",
        "DOWN",
        "LEFT",
        "RIGHT"
    };

    private ActionListener panelAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = (String) ae.getActionCommand();
            x = player.getX();
            y = player.getY();
            if (classicArcade.gameRunning) {
                classicArcade.checkElapsedTime();
                if (classicArcade.gameRunning) {
                    if (command.equals(commands[0])) {
                        y -= 100;
                        if (y <= -150) {
                            classicArcade.incrementScore(10);
                        }
                    } else if (command.equals(commands[1])) {
                        y += 100;
                    } else if (command.equals(commands[2])) {
                        x -= 110;
                    } else if (command.equals(commands[3])) {
                        x += 110;
                    }
                }
            }
            if (player.checkBorderCrossed(x, y)) {
                player.resetPosition(startX, startY);
            } else if (checkCollision()) {
                player.setLocation(x, y);
            } else {
                player.resetPosition(startX, startY);
            }
        }
    };

    /**
     * The Constructor
     *
     * @param classicArcade_ the Game is an argument. This class uses it to
     * access the boy and bugs to control them
     */
    public ArrowKeyPanel(ClassicArcade classicArcade_) {
        classicArcade = classicArcade_;
        gameFrame = classicArcade_.getGameFrame();
        x = 0;
        y = 0;
        player = classicArcade_.getBoy();
        startX = classicArcade_.boyStartX;
        startY = classicArcade_.boyStartY;
        movingImages = classicArcade_.getAllBugs();
        //Registering key command actions
        for (int i = 0; i < commands.length; i++) {
            registerKeyboardAction(panelAction,
                    commands[i],
                    KeyStroke.getKeyStroke(commands[i]),
                    JComponent.WHEN_IN_FOCUSED_WINDOW);
        }
    }

    /**
     * For checking the collision of boy and bugs
     *
     * @return whether collided or not
     */
    public boolean checkCollision() {
        boolean result = true;
        for (MovingImage movingImage : movingImages) {
            if ((movingImage.getX() <= (player.getX() + 80))
                    && ((movingImage.getX() + 80) >= player.getX())
                    && (movingImage.getY() <= (player.getY() + 41))
                    && ((movingImage.getY() + 41) >= player.getY())) {
                result = false;
                classicArcade.decrementScore(5);
                break;
            }
        }
        return result;
    }
}
