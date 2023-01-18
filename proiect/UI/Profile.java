package UI;

import javax.swing.*;
import java.awt.*;

public class Profile extends JPanel {
    JPanel me=new JPanel();
    JButton delete=new JButton("delete account");
    public Profile(int userID){
        setSize(600,900);
        setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();

    }
}
