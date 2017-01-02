package integratedkidgames;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GVKC Ritvik, IIIT- Bengaluru
 *
 * This is the base class, which is extended by other derived game classes like
 * "ColorFind", "ClassicArcade", etc.
 */
public class Game {

    /**
     * Name of the Game
     */
    protected String name;

    /**
     * This is used for finding the textfiles of instructions, highscore, etc.
     */
    protected String nameWithoutSpaces;

    /**
     * Game Score
     */
    protected int score;

    /**
     * Time period of the game in seconds
     */
    protected int timePeriodSecs;

    /**
     * Total time of the game in milliseconds
     */
    protected long totalTime;

    /**
     * Start of the time in long integer
     */
    protected long startTime;

    /**
     * Total elapsed time during game
     */
    protected long elapsedTime;

    /**
     * Time remaining to finish the game in seconds
     */
    protected int timeRemainingSecs;

    /**
     * Game running status
     */
    public boolean gameRunning;

    /**
     * The name of the text file that stores the high score
     */
    private String highScoreFileName;

    /**
     * The GUI wing class which is attached to the game
     */
    protected GameFrame gameFrame;

    /**
     * The Game Constructor
     *
     * @param name_ - name of the game
     * @param nameWithoutSpaces_ - name for file name
     * @param timePeriodSecs_ - Total time to run the game
     */
    public Game(String name_, String nameWithoutSpaces_, int timePeriodSecs_) {
        gameFrame = new GameFrame();
        name = name_;
        nameWithoutSpaces = nameWithoutSpaces_;
        timeRemainingSecs = timePeriodSecs_;
        gameFrame.setLabel("HEADING", name);
        gameFrame.setLabel("SCORE", "0");
        gameFrame.setLabel("TIME", String.valueOf(timeRemainingSecs));
        highScoreFileName = nameWithoutSpaces_ + ".txt";
        gameFrame.setLabel("HIGH-SCORE", checkHighScoreFile());
        populateInstructions();
        startTime = (new Date()).getTime();
        timePeriodSecs = timePeriodSecs_;
        totalTime = timePeriodSecs_ * 1000;
        elapsedTime = 0;
        score = 0;
        gameRunning = true;
    }

    /**
     * For incrementing score after successful step
     *
     * @param scoreInc_ - the score-incrementing value
     */
    public void incrementScore(int scoreInc_) {
        if (gameRunning) {
            score += scoreInc_;
            gameFrame.setLabel("SCORE", " " + score);
        }
    }

    /**
     * For decrementing score after wrong step
     *
     * @param scoreDec_ - the score-decrementing value
     */
    public void decrementScore(int scoreDec_) {
        if (gameRunning) {
            score -= scoreDec_;
            gameFrame.setLabel("SCORE", " " + score);
        }
    }

    /**
     *
     * @return Game-Score
     */
    public int getScore() {
        return score;
    }

    /**
     * It checks whether time is over or not
     */
    public void checkElapsedTime() {
        if (gameRunning) {
            elapsedTime = (new Date()).getTime() - startTime;
            if (elapsedTime < totalTime) {
                timeRemainingSecs = (int) ((totalTime - elapsedTime) / 1000);
                gameRunning = true;
            } else {
                timeRemainingSecs = 0;
                gameRunning = false;
                gameFrame.setLabel("MESSAGE", "Game Over!");
                int highScore = processHighScore();
                gameFrame.setLabel("HIGH-SCORE", String.valueOf(highScore));
            }
            gameFrame.setLabel("TIME", String.valueOf(timeRemainingSecs));
        }
    }

    /**
     * It processes the high score at the end of the game
     *
     * @return the value of highscore
     */
    public int processHighScore() {
        int highScore = 0;
        try {
            InputStream is = new FileInputStream(highScoreFileName);
            int size = is.available();
            String highScoreString = "";
            for (int i = 0; i < size; i++) {
                highScoreString = highScoreString + (char) is.read();
            }
            is.close();
            highScore = Integer.parseInt(highScoreString);
            if (highScore < score) {
                highScore = score;
                Writer wr = new FileWriter(highScoreFileName);
                wr.write(new Integer(highScore).toString());
                wr.close();
            }
        } catch (IOException e) {
            System.out.print("Exception");
        } finally {
            return highScore;
        }
    }

    /**
     * Sets up the highscore file in the beginning
     *
     * @return the highscore string
     */
    public final String checkHighScoreFile() {
        String highScoreString = "0";
        try {
            File f = new File(highScoreFileName);
            if (f.exists() && !f.isDirectory()) {
                InputStream is = new FileInputStream(highScoreFileName);
                int size = is.available();
                if (size > 0) {
                    highScoreString = "";
                }
                for (int i = 0; i < size; i++) {
                    highScoreString = highScoreString + (char) is.read();
                }
                is.close();
            } else {
                Writer wr = new FileWriter(highScoreFileName);
                wr.write("0");
                wr.close();
            }
        } catch (IOException e) {
            System.out.print("Exception: " + e.getMessage());
        } finally {
            return highScoreString;
        }
    }

    //For populating instructions from the instructions file
    private void populateInstructions() {
        String fileInstructionsName = nameWithoutSpaces + "Instructions.txt";
        File file = new File(fileInstructionsName);
        String instructionsHTML = "<html>"
                + "<div style='color: #204d74; overflow: scroll;'>"
                + "<h2 align='center'>Instructions</h2>"
                + "<hr></hr>"
                + "<ul style='padding-left: 0; margin-left: 10px; list-style-type: none; list-style-position: inside; padding:0!important;'>";
        if (file.exists() && !file.isDirectory()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    instructionsHTML = instructionsHTML + "<li'>" + line + "</li>";
                    instructionsHTML = instructionsHTML + "<br>";
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        instructionsHTML = instructionsHTML + "</ul></div><html>";
        gameFrame.setLabel("INSTRUCTIONS", instructionsHTML);
    }
}
