package ru.geekbrains.Course1__Lesson.Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_WIDTH = 508;
    private static final int WIN_POS_X = 800;
    private static final int WIN_POS_Y = 300;

    private static Map field;
    private static StartNewGameWindow startNewGameWindow;

    public GameWindow() {
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WIN_POS_X, WIN_POS_Y, WIN_WIDTH, WIN_HEIGHT);

        startNewGameWindow = new StartNewGameWindow(this);

        field = new Map();
        add(field, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        JButton btnStartGame = new JButton("Start Game");
        JButton btnExit = new JButton("Exit");
        bottomPanel.add(btnStartGame);
        bottomPanel.add(btnExit);

        this.add(bottomPanel, BorderLayout.SOUTH);


        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
        setResizable(false);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        field.startNewGame(mode, fieldSizeX, fieldSizeY, winLen);
    }
}
