package gui;

import ork.Ork;
import javax.swing.*;
import java.awt.*;

public class OrkInfoPanel extends JPanel {
    private final JTextField nameField = new JTextField(20);
    private final JTextField tribeField = new JTextField(20);
    private final JTextField typeField = new JTextField(20);
    private final JTextField weaponField = new JTextField(20);
    private final JTextField armorField = new JTextField(20);
    private final JTextField bannerField = new JTextField(20);
    private final JTextField strengthField = new JTextField(5);
    private final JTextField agilityField = new JTextField(5);
    private final JTextField intellectField = new JTextField(5);
    private final JTextField healthField = new JTextField(5);

    public OrkInfoPanel() {
        setLayout(new GridLayout(10, 2, 5, 5));
        setBorder(BorderFactory.createTitledBorder("Информация об орке"));

        addField("Имя:", nameField);
        addField("Племя:", tribeField);
        addField("Тип:", typeField);
        addField("Оружие:", weaponField);
        addField("Броня:", armorField);
        addField("Знамя:", bannerField);
        addField("Сила:", strengthField);
        addField("Ловкость:", agilityField);
        addField("Интеллект:", intellectField);
        addField("Здоровье:", healthField);

        setFieldsEditable(false);
    }

    private void addField(String label, JTextField field) {
        add(new JLabel(label));
        add(field);
    }

    private void setFieldsEditable(boolean editable) {
        for (Component comp : getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setEditable(editable);
            }
        }
    }

    public void updateInfo(Ork ork) {
        if (ork == null) return;
        nameField.setText(ork.getName());
        tribeField.setText(ork.getTribe());
        typeField.setText(ork.getType().toString());
        weaponField.setText(ork.getWeapon().toString());
        armorField.setText(ork.getArmor().toString());
        bannerField.setText(ork.getBanner().toString());
        strengthField.setText(String.valueOf(ork.getStrength()));
        agilityField.setText(String.valueOf(ork.getAgility()));
        intellectField.setText(String.valueOf(ork.getIntellect()));
        healthField.setText(String.valueOf(ork.getHealth()));
    }
}