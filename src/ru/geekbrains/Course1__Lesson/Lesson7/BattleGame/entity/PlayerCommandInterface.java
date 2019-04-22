package ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity;

import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.units.Healer;
import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.units.Hero;
import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.units.HeroesHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerCommandInterface extends Player {
    private int maxUnitsCount;
    private JComboBox jComboBoxHeroSelector;
    private JButton jButtonAddHero;
    private JTextArea jTextArea;
    private JTextArea jTextMaxPlayerUnits;

    public void setjTextGameLog(JTextArea jTextGameLog) {
        this.jTextGameLog = jTextGameLog;
    }

    private JTextArea jTextGameLog;


    public void setjTextMaxPlayerUnits(JTextArea jTextMaxPlayerUnits) {
        this.jTextMaxPlayerUnits = jTextMaxPlayerUnits;
    }

    public void setjComboBoxHeroSelector(JComboBox jComboBoxHeroSelector) {
        this.jComboBoxHeroSelector = jComboBoxHeroSelector;
    }

    public void setjTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }


    public void setjButtonAddHero(JButton jButtonAddHero) {
        this.jButtonAddHero = jButtonAddHero;
        ActionListener btnAddHeroListener = new ButtonAddHeroListener();
        this.jButtonAddHero.addActionListener(btnAddHeroListener);
    }

    public PlayerCommandInterface(String name, boolean active, Hero[] heroes) {
        super(name, active, heroes);
    }

    public PlayerCommandInterface(String name, boolean active) {
        super(name, active);
    }


    // Заполнение списка юнитов
    public void setComboBoxHeroItems(JComboBox jComboBox) {
        jComboBoxHeroSelector = jComboBox;
        fillComboBoxHeroes();
    }

    // Заполнение списка с возможными Units
    private void fillComboBoxHeroes(){
        for (int i = HeroesHelper.getMinHeroesID(); i <= HeroesHelper.getMaxHeroesID() ; i++) {
            jComboBoxHeroSelector.addItem(HeroesHelper.getHeroTypeByID(i));
        }
    }

    public boolean isWinAfterAttack(Player enemyPlayer) {
        Hero ourHero = this.getHero();
        Hero enemyHero = enemyPlayer.getHero();
        if(enemyHero == null) {
            return true;
        }

        ourHero.setDamage(enemyHero);

        jTextGameLog.append("\n" + "     Детали атаки:");
        String stat =
                "      - " + this.getName() + " " +
                        ourHero.getClass().getSimpleName() + " атаковал " +
                        enemyHero.getClass().getSimpleName();
        if (enemyHero.isAlive()) {
            jTextGameLog.append("\n" + stat + " (его здоровье после атаки: " + enemyHero.getHealth() + ")");
        } else {
            jTextGameLog.append("\n" + stat + " (убит)");
        }

        if (enemyHero.isAlive()) {
            Healer enemyHealer = enemyPlayer.getHealer();
            if (enemyHealer != null) {
                enemyHealer.healingHero(enemyPlayer.getHero());
                jTextGameLog.append("\n" + "      - Доктор вылечил " + enemyHero.getClass().getSimpleName() + " до " + enemyHero.getHealth());
            }
        }

        return enemyPlayer.isDamaged();
    }

    private class ButtonAddHeroListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            maxUnitsCount = Integer.parseInt(jTextMaxPlayerUnits.getText().toString());

            Hero[] heroes = getHeroes();

            if(heroes == null || getHeroes().length != maxUnitsCount) {
                jTextArea.setText("Состав команды:");
                heroes = new Hero[maxUnitsCount];
                for (int i = 0; i < heroes.length; i++) {
                    heroes[i] = null;
                }
                setHeroes(heroes);
            }

            int i = 0;
            while (i <= maxUnitsCount - 1) {
                if (heroes[i] == null){
                    break;
                } else {
                    i++;
                }
            }

            if (heroes != null && i < maxUnitsCount && heroes[i] == null) {
                jTextArea.append("\n" + (i+1) + ". " + HeroesHelper.getHeroTypeByID(jComboBoxHeroSelector.getSelectedIndex()));
                heroes[i] = HeroesHelper.generateHeroByID(jComboBoxHeroSelector.getSelectedIndex());
                setHeroes(heroes);
            }

        }
    }


}
