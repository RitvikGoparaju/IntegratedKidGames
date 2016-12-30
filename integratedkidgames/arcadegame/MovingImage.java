package integratedkidgames.arcadegame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class is for creating moving bugs in Classic Arcade Game class
 *
 * @author GVKC Ritvik, IIIT - Bengaluru
 */
public class MovingImage extends JLabel implements ActionListener {

    private int deltaX;
    private int deltaY;
    private int directionX;
    private int directionY;
    private boolean gameRunning;

    /**
     *The constructor
     * @param iconname path of the image file
     * @param startX Starting X position
     * @param startY Starting Y position
     * @param deltaX animating value on X-axis
     * @param deltaY animating value on Y-axis
     * @param directionX forward or backward direction for animation on X-axis
     * @param directionY forward or backward direction for animation on Y-axis
     * @param delay delay to be used for animating
     */
    public MovingImage(
            String iconname,
            int startX, int startY,
            int deltaX, int deltaY,
            int directionX, int directionY,
            int delay) {
        this.gameRunning = false;
        this.directionY = 1;
        this.directionX = 1;
        this.deltaY = 3;
        this.deltaX = 2;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.directionX = directionX;
        this.directionY = directionY;
        String path = iconname;
        setIcon(new ImageIcon(path));
        setSize(getPreferredSize());
        setLocation(startX, startY);
        new javax.swing.Timer(delay, this).start();
    }

    @Override
    public int getX() {
        int thisX = getLocation().x;
        return thisX;
    }

    @Override
    public int getY() {
        int thisY = getLocation().y;
        return thisY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameRunning) {
            Container parent = getParent();

            //  Determine next X position
            int nextX = getLocation().x + (deltaX * directionX);

            if (nextX < 0) {
                nextX = 0;
                directionX *= -1;
            }

            if (nextX + getSize().width > parent.getSize().width) {
                nextX = parent.getSize().width - getSize().width;
                directionX *= -1;
            }

            //  Determine next Y position
            int nextY = getLocation().y + (deltaY * directionY);

            if (nextY < 0) {
                nextY = 0;
                directionY *= -1;
            }

            if (nextY + getSize().height > parent.getSize().height) {
                nextY = parent.getSize().height - getSize().height;
                directionY *= -1;
            }

            //  Move the label
            setLocation(nextX, nextY);
        }
    }

    /**
     *to set the boolean value for setting bug running
     */
    public void setGameRunning() {
        gameRunning = true;
    }
}
