package UI;

import javax.swing.*;
import java.awt.*;

public class BigScreen extends JFrame {
    LogIn main=new LogIn();
    public BigScreen(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        setSize(1000,900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(main, gbc);
        setVisible(true);
    }
}
