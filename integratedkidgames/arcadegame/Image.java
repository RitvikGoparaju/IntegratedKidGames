package integratedkidgames.arcadegame;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *The Image class, which is used to create "Boy" image in Classic Arcade Game
 * @author GVKC Ritvik, IIIT - Bengaluru
 */
public class Image extends JLabel {

    /**
     *Constructor
     * @param iconname the filename of the icon
     * @param startX X value of the starting position
     * @param startY Y value of the starting position
     */
    public Image(String iconname, int startX, int startY) {
        String path = iconname;
        setIcon(new ImageIcon(path));
        setSize(getPreferredSize());
        setLocation(startX, startY);
    }

    public int getX() {
        int thisX = getLocation().x;
        return thisX;
    }

    public int getY() {
        int thisY = getLocation().y;
        return thisY;
    }

    /**
     *For checking whether the image crossed borders
     * @param x_ X position
     * @param y_ Y Position
     * @return crossed or not
     */
    public boolean checkBorderCrossed(int x_, int y_) {
        boolean result;
        int parentWidth = this.getParent().getSize().width;
        int parentHeight = this.getParent().getSize().height;
        int currentPositionX = x_ + getSize().width;
        int currentPositionY = y_ + getSize().height;

        result = ((currentPositionX < 0) || (currentPositionX > parentWidth) || (currentPositionY < 0) || (currentPositionY > parentHeight));
        return result;
    }

    /**
     *Resetting original position of the image
     * @param x_
     * @param y_
     */
    public void resetPosition(int x_, int y_) {
        this.setLocation(x_, y_);
    }
}
