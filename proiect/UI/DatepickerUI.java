package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DatepickerUI extends JPanel {


    private JTextField yearField;
    private JTextField monthField;
    private JTextField dayField;

    public DatepickerUI() {

        yearField = new JTextField(4);
        monthField = new JTextField(2);
        dayField = new JTextField(2);

        setLayout(new GridBagLayout());
        add(new JLabel("Year:"));
        add(yearField);
        add(new JLabel("Month:"));
        add(monthField);
        add(new JLabel("Day:"));
        add(dayField);
        setSize(300, 200);
        setVisible(true);
    }

    public JTextField getYearField() {
        return yearField;
    }

    public void setYearField(JTextField yearField) {
        this.yearField = yearField;
    }

    public JTextField getMonthField() {
        return monthField;
    }

    public void setMonthField(JTextField monthField) {
        this.monthField = monthField;
    }

    public JTextField getDayField() {
        return dayField;
    }

    public void setDayField(JTextField dayField) {
        this.dayField = dayField;
    }
}