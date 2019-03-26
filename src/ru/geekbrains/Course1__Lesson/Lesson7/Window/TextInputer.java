package ru.geekbrains.Course1__Lesson.Lesson7.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextInputer {
    public static void main(String[] args) {
        MainWindow main = new MainWindow();
    }
}

class MainWindow extends JFrame{
    public MainWindow(){
        setTitle("Main input window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setBounds(300, 300, 400, 500);

        int sizeWidth = 500;
        int sizeHeight = 400;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);

        JButton jbtnCall = new JButton("Call");

        // Создание панели с табличным расположением
        JPanel grid = new JPanel(new GridLayout(1, 1, 10, 0) );
        // Добавление кнопок в панель
        grid.add (jbtnCall);

        jbtnCall.setPreferredSize(new Dimension(150, 25));

        JTextArea textArea = new JTextArea("Иванов Иван Иванович");
        textArea.setEditable(false);

        jbtnCall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditWindow editWnd = new EditWindow(textArea.getText(), textArea);
            }
        });



        // Создание панели с последовательным расположением
        // компонентов и выравниванием по правому краю
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid);

        add(flow, BorderLayout.SOUTH);

        JPanel jTopPanel = new JPanel();
        jTopPanel.add(textArea);

        add(jTopPanel, BorderLayout.NORTH);

        setVisible(true);
    }

}

class EditWindow extends JFrame{
    //private String text;
    JTextArea family;
    JTextArea name;
    JTextArea patronymic;

    public EditWindow(String text, JTextArea mainFio) {
        setTitle("Edit window");
        this.family = new JTextArea();
        this.name = new JTextArea();
        this.patronymic = new JTextArea();
        setFioToJTexts(text);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        int sizeWidth = 300;
        int sizeHeight = 250;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);

        JButton jbtnSave = new JButton("Save");

        // Создание панели с табличным расположением
        JPanel grid = new JPanel(new GridLayout(1, 1, 10, 0));
        // Добавление кнопки в панель
        grid.add(jbtnSave);

        jbtnSave.setPreferredSize(new Dimension(150, 25));

        jbtnSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFio.setText(fieldsToFio());
                setVisible(false);
                dispose();
            }
        });

        // Создание панели с последовательным расположением
        // компонентов и выравниванием по правому краю
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid);

        add(flow, BorderLayout.SOUTH);

        // Создание интерфейса окна
        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(200, 200));
        jPanel.add(new JLabel("Фамилия :"));
        jPanel.add(this.family);
        jPanel.add(new JLabel("Имя :"));
        jPanel.add(this.name);
        jPanel.add(new JLabel("Отчество :"));
        jPanel.add(this.patronymic);
        //setContentPane(jPanel);
        add(jPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void setFioToJTexts(String fio) {
        String[] parts = fio.split(" ");
        if (parts.length > 0) {
            this.family.setText(parts[0]);
        }

        if (parts.length > 1) {
            this.name.setText(parts[1]);
        }

        if (parts.length > 2) {
            this.patronymic.setText(parts[2]);
        }
    }

    private String fieldsToFio() {
        return this.family.getText() + " " +
                this.name.getText() + " " +
                this.patronymic.getText();
    }
}