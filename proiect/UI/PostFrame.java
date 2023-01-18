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
        setSize(400,80);
        setLayout(new GridBagLayout());
        GridBagConstraints c= new GridBagConstraints();
        add(new JLabel(poster),c);
        JTextArea post=new JTextArea(description);
        post.setLineWrap(true);
        post.setForeground(RGB);
        post.setEditable(false);
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridy=2;
        add(post,c);
        c.gridy=3;
        add(sup,c);
        c.gridx=2;
        add(comment,c);
    }
}