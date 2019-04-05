package ru.geekbrains.Course1__Lesson.Lesson7.BattleGame;

import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.Player;
import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.units.HeroesGenerator;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Scanner;

public class MobaFrame extends JFrame {
    private static final int WND_HEIGHT = 600;
    private static final int WND_WIDTH = 800;
    private static final int INDIENT = 5;
    private static final int DEFAULT_HEROES_COUNT = 5;
    private static final int TOP_PANEL_HEIGHT = 30;
    private static final int BOTTOM_PANEL_HEIGHT = 300;
    private static final int BUTTON_HEIGHT = 25;
    JTextArea jTextMaxPlayerUnits;
    JTextArea jTextGameLog;
    JButton btnStartGame;

    public MobaFrame(){
        setTitle("BattleGame (Moba)");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        wndToSrceenCenter();
        outSettingsInterface( INDIENT, 0, WND_WIDTH - INDIENT, TOP_PANEL_HEIGHT);
        outBottomInterface(0, WND_HEIGHT - BOTTOM_PANEL_HEIGHT, WND_WIDTH, BOTTOM_PANEL_HEIGHT - INDIENT);
        Scanner in = new Scanner(System.in);

        Player[] players = {
                new Player("Green", true, HeroesGenerator.generateRandomHeroes(Player.DEFAULT_HEROES_COUNT)),
                new Player("Red", false, HeroesGenerator.generateRandomHeroes(Player.DEFAULT_HEROES_COUNT))
        };
        outCenterInterface();
        //outPlayerInterface(INDIENT, TOP_PANEL_HEIGHT, );
        setVisible(true);
    }

    private void wndToSrceenCenter(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - WND_WIDTH) / 2;
        int locationY = (screenSize.height - WND_HEIGHT) / 2;
        setBounds(locationX, locationY, WND_WIDTH, WND_HEIGHT);
    }

    private void outSettingsInterface(int x, int y, int width, int height){
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("Максимальное количество персонажей:"));
        jPanel.add(jTextMaxPlayerUnits = new JTextArea(Integer.toString(DEFAULT_HEROES_COUNT)));
        jPanel.setBackground(Color.yellow);
        add(jPanel, BorderLayout.NORTH);
    }

    private void outBottomInterface(int x, int y, int width, int height){
        final int BUTTON_WIDTH = 100;

        btnStartGame = new JButton("Старт");
        btnStartGame.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

        JPanel jPanelForButton = new JPanel();
        jPanelForButton.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanelForButton.setBackground(Color.red);
        jPanelForButton.setPreferredSize(new Dimension(width, BUTTON_HEIGHT));

        jPanelForButton.add(btnStartGame);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.setBackground(Color.green);
        jPanel.setPreferredSize(new Dimension(width, height));

        jTextGameLog = new JTextArea("Протокол игры:", 10, 1);
        JScrollPane jScroll = new JScrollPane(jTextGameLog);
        jScroll.setPreferredSize(new Dimension(WND_WIDTH, BOTTOM_PANEL_HEIGHT - BUTTON_HEIGHT - 2 * INDIENT));
        jScroll.setBorder(new EmptyBorder(INDIENT, INDIENT, INDIENT, INDIENT));
        jPanel.add(jPanelForButton, BorderLayout.NORTH);
        jPanel.add(jScroll, BorderLayout.CENTER);
        add(jPanel, BorderLayout.SOUTH);
    }

    private void outCenterInterface(){
//        final int BUTTON_WIDTH = 100;
//
        JButton btnAddPerson = new JButton("Добавить");
//        btnStartGame.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
//
//        JPanel jPanelForButton = new JPanel();
//        jPanelForButton.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
//        jPanelForButton.setBackground(Color.red);
//        jPanelForButton.setPreferredSize(new Dimension(width, BUTTON_HEIGHT));
//
//        jPanelForButton.add(btnStartGame);

        JPanel jPanel = new JPanel();
        JPanel jPanelLeft = new JPanel();
        jPanelLeft.setLayout(new BorderLayout());
        JPanel jPanelRight = new JPanel();
        jPanel.setLayout(new GridLayout(1, 2));
        jPanelRight.setBackground(Color.BLUE);

        JPanel jPanelPlayer1 = new JPanel();
        jPanelPlayer1.setLayout(new BorderLayout());
        jPanelPlayer1.setBackground(Color.green);
        jPanelPlayer1.setBorder(new EmptyBorder(INDIENT, INDIENT, INDIENT, INDIENT));
        jPanelLeft.add(jPanelPlayer1);

        //jPanelLeft.setBorder(new EmptyBorder(INDIENT, INDIENT, INDIENT, INDIENT));
        //jPanel.setPreferredSize(new Dimension(width, height));

        jTextGameLog = new JTextArea("Состав игроков:", 10, 1);
        JScrollPane jScroll = new JScrollPane(jTextGameLog);
        //jScroll.setPreferredSize(new Dimension(WND_WIDTH, BOTTOM_PANEL_HEIGHT - BUTTON_HEIGHT - 2 * INDIENT));
        jScroll.setBorder(new EmptyBorder(INDIENT, INDIENT, INDIENT, INDIENT));
        //jPanel.add(jPanelForButton, BorderLayout.NORTH);
        jPanel.add(jPanelLeft);
        jPanel.add(jPanelRight);
        add(jPanel, BorderLayout.CENTER);
    }

    private void outPlayerInterface(int x, int y, int width, int height, Player player){

    }

}
