package UI;

import javax.swing.*;
import java.awt.*;

public class PostFrame extends JPanel {
    String poster;
    String description;
    int RGB;
    JButton sup=new JButton("like");
    JButton comment=new JButton("comment");
    public PostFrame(String poster, String description, Color RGB){
        setSize(400,60);
        setLayout(new GridBagLayout());
        GridBagConstraints c= new GridBagConstraints();
        c.fill=GridBagConstraints.HORIZONTAL;
        add(new JLabel(poster),c);
        JTextArea post=new JTextArea(description);
        post.setLineWrap(true);
        post.setForeground(RGB);
        post.setEditable(false);
        post.setSize(getWidth(),30);
        c.gridy=2;
        c.weightx=1.0;
        c.gridwidth=2;
        add(post,c);
        c.gridy=3;
        add(sup,c);
        c.gridx=2;
        add(comment,c);
    }
}
