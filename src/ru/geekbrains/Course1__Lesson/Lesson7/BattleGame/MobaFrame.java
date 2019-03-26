package ru.geekbrains.Course1__Lesson.Lesson7.BattleGame;

import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

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
        outBottomInterface(INDIENT, WND_HEIGHT - BOTTOM_PANEL_HEIGHT, WND_WIDTH - INDIENT * 2, BOTTOM_PANEL_HEIGHT - INDIENT);
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
        //jTextMaxPlayerUnits.setBorder();
        this.add(jPanel, BorderLayout.NORTH);
    }

    private void outBottomInterface(int x, int y, int width, int height){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setPreferredSize(new Dimension( width, height));
        final int BUTTON_WIDTH = 100;
        btnStartGame = new JButton("Старт");
        //btnStartGame.setBounds((width - BUTTON_WIDTH)/2, y, BUTTON_WIDTH, BUTTON_HEIGHT);
        btnStartGame.setBounds((width - BUTTON_WIDTH)/2, y, BUTTON_WIDTH, BUTTON_HEIGHT);
        jPanel.add(btnStartGame);

        jTextGameLog = new JTextArea("Протокол игры:", 10, 1);
        JScrollPane jScroll = new JScrollPane(jTextGameLog);
        //jScroll.setPreferredSize(new Dimension(0, 150));
        //int top = y + BUTTON_HEIGHT + INDIENT;
        int top = INDIENT + BUTTON_HEIGHT + INDIENT;

        jScroll.setBounds(x , top, width - 18, 200);//height - BUTTON_HEIGHT - INDIENT); // 145);//
        jPanel.add(jScroll);
        add(jPanel);
    }

    private void outPlayerInterface(int x, int y, int width, int height, Player player){

    }

}
