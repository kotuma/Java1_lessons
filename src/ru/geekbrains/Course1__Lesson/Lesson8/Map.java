package ru.geekbrains.Course1__Lesson.Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;
    private Cross cross;

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

    private void update(MouseEvent e) {
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;

        System.out.println("Cell: " + cellY + " :: " + cellX);
        if (cross.setPlayerMove(cellX, cellY)) {
            repaint();
            if (cross.getState().length() > 0) {
                JOptionPane.showMessageDialog( this , cross.getState() ,
                        "Game message", JOptionPane.INFORMATION_MESSAGE ) ;
            }
        }
    }

    private void paintXorO(Graphics g, Rectangle rect, boolean paintX) {
        int INDIENT = 8;
        // Уменьшение прямоугольника для отрисовки фигуры
        rect.x += INDIENT;
        rect.y += INDIENT;
        rect.width -= INDIENT * 2;
        rect.height -= INDIENT * 2;

        Graphics2D g2D = (Graphics2D)g;


        if(!paintX) {
            g2D.setStroke(new BasicStroke(2));
            g2D.setColor(Color.red);

            g2D.drawOval(rect.x, rect.y, rect.width, rect.height);
        }
        else {
            g2D.setStroke(new BasicStroke(3));
            g2D.setColor(Color.green);

            g2D.drawLine( rect.x, rect.y, (int) rect.getMaxX(), (int) rect.getMaxY());
            g2D.drawLine((int) rect.getMaxX(), rect.y, rect.x, (int) rect.getMaxY());
        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        System.out.println("mode = [" + mode + "], fieldSizeX = [" + fieldSizeX + "], fieldSizeY = [" + fieldSizeY + "], winLen = [" + winLen + "]");
        this.cross = new Cross(fieldSizeX, fieldSizeY, winLen, mode);
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

        // Отрисовка сетки

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        // Отрисовка ходов на поле

        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                int y = i * cellHeight;
                int x = j * cellWidth;
                Rectangle fieldRect = new Rectangle(x, y, cellWidth, cellHeight);
                char fieldVal = cross.getFieldValue(j, i);

                // отрисовка ходов
                if (fieldVal == Cross.player_DOT) {
                    paintXorO(g, fieldRect, true);
                }

                if (fieldVal == Cross.Ai_DOT) {
                    paintXorO(g, fieldRect,false);
                }
            }
        }

    }
}
