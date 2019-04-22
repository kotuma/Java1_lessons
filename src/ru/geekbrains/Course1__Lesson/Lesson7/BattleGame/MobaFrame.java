package ru.geekbrains.Course1__Lesson.Lesson7.BattleGame;

import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.Player;
import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.PlayerCommandInterface;
import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.units.HeroesGenerator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Scanner;

public class MobaFrame extends JFrame {
    private static final int WND_HEIGHT = 600;
    private static final int WND_WIDTH = 800;
    private static final int INDIENT = 5;
    private static final int DEFAULT_HEROES_COUNT = 5;
    private static final int TOP_PANEL_HEIGHT = 30;
    private static final int BOTTOM_PANEL_HEIGHT = 300;
    private static final int BUTTON_HEIGHT = 25;
    private static int activePlayerID = 0;
    JTextArea jTextMaxPlayerUnits;
    JTextArea jTextGameLog;
    JButton btnStartGame;
//    private Player[] players = {
//            new Player("Green", true, HeroesGenerator.generateRandomHeroes(Player.DEFAULT_HEROES_COUNT)),
//            new Player("Red", false, HeroesGenerator.generateRandomHeroes(Player.DEFAULT_HEROES_COUNT))
//    };
    private PlayerCommandInterface[] players = {
        new PlayerCommandInterface("Green", true),
        new PlayerCommandInterface("Red", false)
        // new PlayerCommandInterface("Red", false, HeroesGenerator.generateRandomHeroes(Player.DEFAULT_HEROES_COUNT))
    };



    public MobaFrame(){
        setTitle("BattleGame (Moba)");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        wndToSrceenCenter();

        outSettingsInterface( INDIENT, 0, WND_WIDTH - INDIENT, TOP_PANEL_HEIGHT);
        outBottomInterface(0, WND_HEIGHT - BOTTOM_PANEL_HEIGHT, WND_WIDTH, BOTTOM_PANEL_HEIGHT - INDIENT);
        Scanner in = new Scanner(System.in);


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
        //jPanel.setBackground(Color.yellow);
        add(jPanel, BorderLayout.NORTH);
    }

    private void outBottomInterface(int x, int y, int width, int height){
        final int BUTTON_WIDTH = 200;

        btnStartGame = new JButton("Старт");
        btnStartGame.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

        JPanel jPanelForButton = new JPanel();
        jPanelForButton.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        //jPanelForButton.setBackground(Color.red);
        jPanelForButton.setPreferredSize(new Dimension(width, BUTTON_HEIGHT));

        jPanelForButton.add(btnStartGame);
        StartBtnListener startBtnListener = new StartBtnListener();
        btnStartGame.addActionListener(startBtnListener);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.setBackground(Color.green);
        jPanel.setPreferredSize(new Dimension(width, height));

        jTextGameLog = new JTextArea("Протокол игры:", 10, 1);
        JScrollPane jScroll = new JScrollPane(jTextGameLog);
        jScroll.setBorder(new EmptyBorder(INDIENT, INDIENT, INDIENT, INDIENT));
        jPanel.add(jPanelForButton, BorderLayout.NORTH);
        jPanel.add(jScroll, BorderLayout.CENTER);
        add(jPanel, BorderLayout.SOUTH);
    }

    private void outCenterInterface(){
        JPanel jCentralPanel = new JPanel();
        jCentralPanel.setLayout(new GridLayout(1, 2));

        JPanel jLeftPanel = new JPanel();
        jLeftPanel.setLayout(new BorderLayout());
        //jLeftPanel.setBackground(Color.CYAN);

        JPanel jRightPanel = new JPanel();
        jRightPanel.setLayout(new BorderLayout());
        //jRightPanel.setBackground(Color.BLUE);

        jLeftPanel.setBorder(new EmptyBorder(INDIENT, INDIENT, INDIENT, INDIENT));
        jRightPanel.setBorder(new EmptyBorder(INDIENT, INDIENT, INDIENT, INDIENT));

        jCentralPanel.add(jLeftPanel);
        jCentralPanel.add(jRightPanel);
        add(jCentralPanel, BorderLayout.CENTER);

        outPlayerInterface(jLeftPanel, players[0]);
        outPlayerInterface(jRightPanel, players[1]);
    }

    private void outPlayerInterface(JPanel jParentPanel, PlayerCommandInterface player){
        final int BUTTON_WIDTH = 170;
        final int LOCAL_GUP = 2;

        JPanel jMainPanel = new JPanel();
        jMainPanel.setLayout(new BorderLayout());
        jParentPanel.add(jMainPanel, BorderLayout.CENTER);

        JPanel jTopPanel = new JPanel();
        jTopPanel.setLayout(new GridLayout(3, 1));
        JComboBox jUnitsBox = new JComboBox();
        //jTopPanel.add(new JLabel("Игрок: " + player.getName()));

        JButton btnAddPerson = new JButton("Добавить");
        JPanel jPlayerNamePanel = new JPanel();
        jPlayerNamePanel.setLayout(new BorderLayout());
        jPlayerNamePanel.add(new JLabel("Игрок: " + player.getName()), BorderLayout.CENTER);

        JPanel jPanelForPlayerName = new JPanel();
        jPanelForPlayerName.setLayout(new FlowLayout(FlowLayout.CENTER, LOCAL_GUP, LOCAL_GUP));
        jPanelForPlayerName.add(jPlayerNamePanel);

        JPanel jPanelForUnitsBox = new JPanel();
        jPanelForUnitsBox.setLayout(new BorderLayout());
        jPanelForUnitsBox.setBorder(new EmptyBorder( LOCAL_GUP, 0, LOCAL_GUP, 1));
        jPanelForUnitsBox.add(jUnitsBox);

        JPanel jPanelForBtnAddPerson = new JPanel();
        jPanelForBtnAddPerson.setLayout(new BorderLayout());
        jPanelForBtnAddPerson.setBorder(new EmptyBorder( LOCAL_GUP, 0, LOCAL_GUP * 2, 1));
        jPanelForBtnAddPerson.add(btnAddPerson);


        jTopPanel.add(jPanelForPlayerName);
        jTopPanel.add(jPanelForUnitsBox);
        jTopPanel.add(jPanelForBtnAddPerson);

        btnAddPerson.setPreferredSize(new Dimension(jPanelForBtnAddPerson.getWidth(), BUTTON_HEIGHT));

        jMainPanel.add(jTopPanel, BorderLayout.NORTH);

        JTextArea jPlayerUnitsTextArea = new JTextArea("Состав команды игрока:", 5, 1);

        JScrollPane jScroll = new JScrollPane(jPlayerUnitsTextArea);
        jMainPanel.add(jScroll, BorderLayout.CENTER);

        // Элементы интерфейса игрока
        player.setComboBoxHeroItems(jUnitsBox);
        player.setjTextArea(jPlayerUnitsTextArea);
        player.setjButtonAddHero(btnAddPerson);
        player.setjTextMaxPlayerUnits(jTextMaxPlayerUnits);
        player.setjTextGameLog(jTextGameLog);
    }

    public int getActivePlayerID() {
        return activePlayerID;
    }

    private int ChangeActivePlayerID(int activePlayerID) {
        switch (activePlayerID) {
            case 0: {
                this.activePlayerID = 1;
                break;
            }
            case 1: {
                this.activePlayerID = 0;
                break;
            }
        }
        return this.activePlayerID;
    }

    private class StartBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            boolean finishGame = false;
            int idActive = 0;
            int idPassive = 1;

            if(players[idActive].getHeroes() == null || players[idPassive].getHeroes() == null) {
                jTextGameLog.append("\n" + "\n" + "Сначала соберите команды для игроков ..." + "\n");
                return;
            }
            jTextGameLog.append("\n" + "\n" + "Начало игры" + "\n");

            while (!finishGame) {
                idActive = MobaFrame.activePlayerID;
                idPassive  = ChangeActivePlayerID(idActive);
                jTextGameLog.append("\n" + "Атаковал игрок: " + players[idActive].getName() + ": " + Arrays.toString(players[idActive].getHeroes()));
                jTextGameLog.append("\n" + "Игрок " + players[idPassive].getName() + ": " + Arrays.toString(players[idPassive].getHeroes()));

                if (players[idActive].isWinAfterAttack(players[idPassive])) {
                    jTextGameLog.append("\n" + "\n" + "Победил игрок: " + players[idActive].getName() + " !!!");
                    finishGame = true;
                    break;
                }
            }
        }
    }




}
