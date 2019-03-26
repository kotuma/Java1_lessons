package ru.geekbrains.Course1__Lesson.Lesson7.BattleGame;

import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.Player;

import javax.swing.*;
import java.awt.*;

public class MobaFrame extends JFrame {
    private static final int WND_HEIGHT = 600;
    private static final int WND_WITH = 800;
    private static final int INDIENT = 2;
    private static final int DEFAULT_HEROES_COUNT = 5;
    private static final int TOP_PANEL_HEIGHT = 30;
    private static final int BOTTOM_PANEL_HEIGHT = 200;
    JTextArea jTextMaxPlayerUnits;
    JButton btnStartGame;

    public MobaFrame(){
        setTitle("BattleGame (Moba)");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        wndToSrceenCenter();
        outSettingsInterface( INDIENT, 0, WND_WITH - INDIENT, TOP_PANEL_HEIGHT);
        outBottomInterface();
        setVisible(true);
    }

    private void wndToSrceenCenter(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - WND_WITH) / 2;
        int locationY = (screenSize.height - WND_HEIGHT) / 2;
        setBounds(locationX, locationY, WND_WITH, WND_HEIGHT);
    }

    private void outSettingsInterface(int x, int y, int width, int height){
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("Максимальное количество персонажей:"));
        jPanel.add(this.jTextMaxPlayerUnits = new JTextArea(Integer.toString(DEFAULT_HEROES_COUNT)));
        this.add(jPanel, BorderLayout.NORTH);
    }

    private void outBottomInterface(int x, int y, int width, int height){
        JPanel jPanel = new JPanel();
        btnStartGame = new JButton("Старт");
        jPanel.add(this.jTextMaxPlayerUnits = new JTextArea(Integer.toString(DEFAULT_HEROES_COUNT)));
        this.add(jPanel, BorderLayout.SOUTH);
    }

    private void outPlayerInterface(int x, int y, int width, int height, Player player){

    }

}
