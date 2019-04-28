package ru.geekbrains.Course1__Lesson.Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {
    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    int [][] field;
    int fieldSizeX;
    int fieldSizeY;
    int winLength;

    int cellHeight;
    int cellWidth;

    boolean isInitialized = false;

    public Map() {
        setBackground(Color.orange);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //super.mouseReleased(e);
                update(e);
            }
        });
    }

    void update(MouseEvent e) {
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;

        System.out.println("Ячейка: " + cellY + " :: " + cellX);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        System.out.println("mode = [" + mode + "], fieldSizeX = [" + fieldSizeX + "], fieldSizeY = [" + fieldSizeY + "], winLen = [" + winLen + "]");
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLen;

        field = new int[fieldSizeY][fieldSizeX];
        isInitialized = true;
        repaint();

    }

    void render(Graphics g) {
        if(!isInitialized) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSizeX;
        cellHeight = panelHeight / fieldSizeY;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
    }
}

// призязать логику из 5 вебинара
// drawOval drawLine