package ru.geekbrains.Course1__Lesson.Lesson7.Window;

import javax.swing.*;
import java.awt.*;

public class SwingMain {
    public static void main(String[] args) {
        new MyWindow();
    }
}

class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Main test window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 500);

        //JButton jbtn1 = new JButton("Button Ok");
        //JButton jbtn2 = new JButton("Button 2");

        //setLayout(new BorderLayout());
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        //setLayout(new FlowLayout( 0));
        //setLayout(null);

        //jbtn1.setBounds(10, 5, 100, 25);
        //add(jbtn1);
        setMinimumSize(new Dimension(200, 200));
        //setResizable(false);

//        JButton[] jbs = new JButton[11];
//
//        for (int i = 0; i < jbs.length; i++) {
//            jbs[i] = new JButton("#" +  (i+1));
//            jbs[i].setAlignmentX(CENTER_ALIGNMENT);
//            add(jbs[i]);
//        }

//        JPanel jPanel = new JPanel(new GridLayout(1, 2));
//
//        jbtn1.setPreferredSize(new Dimension(200, 200));
//
//        jPanel.add(jbtn1);
//        jPanel.add(jbtn2);
//
//
//        add(jPanel, BorderLayout.SOUTH);

//        add(jbtn1, BorderLayout.NORTH);
//        add(jbtn2, BorderLayout.SOUTH);

        // Создание панели с табличным расположением
        JPanel grid = new JPanel(new GridLayout(1, 2, 10, 0) );
        // Добавление кнопок в панель
        grid.add (new JButton("OK"    ));
        grid.add (new JButton("Отмена"));
        // Создание панели с последовательным расположением
        // компонентов и выравниванием по правому краю
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid);
        //add(flow, BorderLayout.SOUTH);
        // Получение панели содержимого
        Container container = getContentPane();
        // Размещение панели с кнопками внизу справа
        container.add(flow, BorderLayout.SOUTH);

        int sizeWidth = 500;
        int sizeHeight = 400;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);
        setVisible(true);
    }
}