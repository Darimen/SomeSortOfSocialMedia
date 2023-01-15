package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class Post extends JPanel {
    JButton post=new JButton("Post");
    JButton addPhoto=new JButton("Add Photo");
    JButton addVideo=new JButton("Add Video");
    JButton color=new JButton("Change the text's color");
    JTextArea description=new JTextArea("your post");
    public Post(){
        setLayout(new GridBagLayout());
        setSize(700,600);
        GridBagConstraints c=new GridBagConstraints();
        description.setRows(5);

        c.gridheight=5;
        c.gridwidth=7;
        c.fill=GridBagConstraints.HORIZONTAL;
        description.setLineWrap(true);
        add(description,c);
        c.gridy=7;
        c.gridwidth=1;
        add(color,c);
        c.gridx=2;
        add(addPhoto,c);
        c.gridx=3;
        add(addVideo,c);
        c.gridx=4;
        add(post,c);

        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color text= JColorChooser.showDialog(new JFrame(),"Select a Color:", Color.BLACK);
                description.setForeground(text);
            }
        });

        ActionListener notImplemented=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"This feature is not implemented yet.");
                JOptionPane.showMessageDialog(null,description.getForeground());
            }
        };

        addVideo.addActionListener(notImplemented);
        addPhoto.addActionListener(notImplemented);
        setVisible(true);
    }
    public static void main(String arg[]){
        JFrame frame=new JFrame();
        frame.setSize(900,700);
        frame.add(new Post());
        frame.setVisible(true);
    }

    public JButton getPost() {
        return post;
    }

    public void setPost(JButton post) {
        this.post = post;
    }

    public JButton getAddPhoto() {
        return addPhoto;
    }

    public void setAddPhoto(JButton addPhoto) {
        this.addPhoto = addPhoto;
    }

    public JButton getAddVideo() {
        return addVideo;
    }

    public void setAddVideo(JButton addVideo) {
        this.addVideo = addVideo;
    }

    public JButton getColor() {
        return color;
    }

    public void setColor(JButton color) {
        this.color = color;
    }

    public JTextArea getDescription() {
        return description;
    }

    public void setDescription(JTextArea description) {
        this.description = description;
    }
}
