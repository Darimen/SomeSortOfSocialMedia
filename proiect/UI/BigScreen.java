package UI;

import javax.swing.*;
import java.awt.*;

public class BigScreen extends JFrame {
    LogIn main=new LogIn();
    public BigScreen(){
        setLayout(new GridBagLayout());
        setSize(600,900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(main);
        setVisible(true);
    }
}
