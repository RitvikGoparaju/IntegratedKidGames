package integratedkidgames.colorfind;

import integratedkidgames.Game;
import integratedkidgames.main.Main;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * This class is for the Game "Color Find". It extends "Game" Class
 *
 * @author GVKC Ritvik, IIIT - Bengaluru
 */
public class ColorFind extends Game {

    //Margin Panels
    private final JPanel topMarginPanel;
    private final JPanel colorFindPanel;
    //The basic panel that holds color buttons
    private JPanel colorPanel;
    //The panels for Game Question
    private JPanel pLabQuestion = new JPanel();
    //Color Buttons
    private JButton b1, b2, b3, b4;
    //Label for Question
    private JLabel labQuestion;
    private String[] colours;
    private int randomNum1, randomNum2, randomNum3, randomNum4, answer;

    /**
     * Constructor. Its parameters are same as for its super class
     *
     * @param name_
     * @param nameWithoutSpaces_
     * @param timePeriodSecs_
     */
    public ColorFind(String name_, String nameWithoutSpaces_, int timePeriodSecs_) {
        super(name_, nameWithoutSpaces_, timePeriodSecs_);
        gameRunning = false;
        this.colours = new String[]{"Blue", "Green", "Yellow", "Red", "Orange", "Black"};
        this.labQuestion = new JLabel();
        this.colorPanel = new JPanel();
        this.colorFindPanel = new JPanel();
        this.topMarginPanel = new JPanel();
        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        b4 = new JButton();
        b1.setPreferredSize(new Dimension(120, 50));
        b2.setPreferredSize(new Dimension(120, 50));
        b3.setPreferredSize(new Dimension(120, 50));
        b4.setPreferredSize(new Dimension(120, 50));
        colorPanel.setSize(600, 150);
        colorPanel.add(b1);
        colorPanel.add(b2);
        colorPanel.add(b3);
        colorPanel.add(b4);
        colorFindPanel.setSize(600, 600);
        colorFindPanel.setLayout(new BoxLayout(colorFindPanel, BoxLayout.Y_AXIS));
        colorFindPanel.add(colorPanel);
        colorFindPanel.add(pLabQuestion);
        gameFrame.gamePanel.setLayout(new BoxLayout(gameFrame.gamePanel, BoxLayout.Y_AXIS));
        gameFrame.gamePanel.add(topMarginPanel);
        gameFrame.gamePanel.add(colorFindPanel);
        gameFrame.addControlPanel();
        gameFrame.frame.setVisible(true);

        //For restarting the game
        gameFrame.startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        //For exiting the game        
        gameFrame.backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameFrame.frame.dispose();
                Main main = new Main();
            }
        });

        //For allowing play of the game
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(answer, randomNum1);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(answer, randomNum2);
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(answer, randomNum3);
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(answer, randomNum4);
            }
        });
    }

    /**
     * For creating the question of asking a randomly chosen color button
     */
    public void createQuestion() {
        checkElapsedTime();
        if (gameRunning) {
            //chooses 4 random numbers out of a total of 6 (from 0 to 5) and one answer from those 4 random numbers
            Random rand = new Random();
            randomNum1 = rand.nextInt((5 - 0) + 1) + 0;
            randomNum2 = rand.nextInt((5 - 0) + 1) + 0;
            while (randomNum2 == randomNum1) {
                randomNum2 = rand.nextInt((5 - 0) + 1) + 0;
            }
            randomNum3 = rand.nextInt((5 - 0) + 1) + 0;
            while (randomNum3 == randomNum1 || randomNum3 == randomNum2) {
                randomNum3 = rand.nextInt((5 - 0) + 1) + 0;
            }
            randomNum4 = rand.nextInt((5 - 0) + 1) + 0;
            while (randomNum4 == randomNum1 || randomNum4 == randomNum2 || randomNum4 == randomNum3) {
                randomNum4 = rand.nextInt((5 - 0) + 1) + 0;
            }
            answer = rand.nextInt((5 - 0) + 1) + 0;
            while (answer != randomNum1 && answer != randomNum2 && answer != randomNum3 && answer != randomNum4) {
                answer = rand.nextInt((5 - 0) + 1) + 0;
            }
            if (super.gameRunning) {
                displayQuestion();
            }
        }
    }

    /**
     * Displaying the question along with color-buttons
     */
    public void displayQuestion() {

        setButtonColor(randomNum1, b1);
        setButtonColor(randomNum2, b2);
        setButtonColor(randomNum3, b3);
        setButtonColor(randomNum4, b4);

        String question = "<html>Click on <strong><em>";

        if (answer == 0) {
            question = question + colours[0];
            //lab.setText(colours[0]);
        } else if (answer == 1) {
            question = question + colours[1];
            //lab.setText(colours[1]);
        } else if (answer == 2) {
            question = question + colours[2];
            //lab.setText(colours[2]);
        } else if (answer == 3) {
            question = question + colours[3];
            //lab.setText(colours[3]);
        } else if (answer == 4) {
            question = question + colours[4];
            //lab.setText(colours[4]);
        } else if (answer == 5) {
            question = question + colours[5];
            //lab.setText(colours[5]);
        }

        question = question + "</em></strong>!</html>";

        labQuestion.setText(question);
        pLabQuestion.add(labQuestion);

    }

    /**
     * To start/restart the game
     */
    public void startGame() {
        gameRunning = true;
        startTime = (new Date()).getTime();
        score = 0;
        gameFrame.setLabel("SCORE", "0");
        startTime = System.currentTimeMillis();
        elapsedTime = 0L;
        totalTime = timePeriodSecs * 1000;
        gameFrame.setLabel("TIME", String.valueOf(timePeriodSecs));
        gameFrame.setLabel("MESSAGE", "Game Begun!");
        this.createQuestion();
    }

    /**
     * Checking the Answer
     *
     * @param answer_ The correct answer
     * @param randomNum_ The answer chosen by the player
     */
    public void checkAnswer(int answer_, int randomNum_) {
        if (answer_ == randomNum_) {
            super.incrementScore(100);
            createQuestion();
        } else {
            super.decrementScore(50);
            createQuestion();
        }
    }

    /**
     * Creating the appropriate colored button
     *
     * @param randomNum_ - randomly chosen color
     * @param b_ - button to be applied color to
     */
    public void setButtonColor(int randomNum_, JButton b_) {
        if (colours[randomNum_] == "Yellow") {
            b_.setBackground(Color.YELLOW);
        } else if (colours[randomNum_] == "Blue") {
            b_.setBackground(Color.BLUE);
        } else if (colours[randomNum_] == "Green") {
            b_.setBackground(Color.GREEN);
        } else if (colours[randomNum_] == "Black") {
            b_.setBackground(Color.BLACK);
        } else if (colours[randomNum_] == "Red") {
            b_.setBackground(Color.RED);
        } else if (colours[randomNum_] == "Orange") {
            b_.setBackground(Color.ORANGE);
        }
    }
}
