package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DatepickerUI extends JPanel implements ActionListener {

    private DatePicker datePicker;
    private JTextField yearField;
    private JTextField monthField;
    private JTextField dayField;
    private JButton setButton;

    public DatepickerUI() {
        datePicker = new DatePicker();

        yearField = new JTextField(4);
        monthField = new JTextField(2);
        dayField = new JTextField(2);
        setButton = new JButton("Set");

        setButton.addActionListener(this);

        setLayout(new FlowLayout());
        add(new JLabel("Year:"));
        add(yearField);
        add(new JLabel("Month:"));
        add(monthField);
        add(new JLabel("Day:"));
        add(dayField);
        add(setButton);

        setSize(300, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int year = Integer.parseInt(yearField.getText());
        int month = Integer.parseInt(monthField.getText());
        int day = Integer.parseInt(dayField.getText());

        datePicker.setYear(year);
        datePicker.setMonth(month);
        datePicker.setDay(day);
    }
}