package UI;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;
import java.time.Period;
import java.util.ArrayList;

public class TopNav extends JPanel {
    JButton home=new JButton("Home");
    JButton messages= new JButton("Messages");
    JButton profile= new JButton("Profile");
    JLabel title= new JLabel();
    JTextField search=new JTextField("search");
    ImageIcon icon=new ImageIcon("magnifying glass.png");
    JButton confirm;
    public TopNav(){
        setLayout(new FlowLayout());
        setSize(new Dimension(900, 30));
        add(home);

        add(search);
        search.setPreferredSize(new Dimension(200,25));
        search.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(search.getText().toLowerCase().equals("search")){
                    search.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(search.getText().trim().length()==0){
                    search.setText("search");
                }
            }
        });

        Image image=icon.getImage();
        Image newImage=image.getScaledInstance(15,15, Image.SCALE_SMOOTH);
        ImageIcon buton=new ImageIcon(newImage);
        confirm=new JButton(buton);
        add(confirm);


        add(messages);
        add(profile);
        add(title);
        //hm.setVisible(true);
    }

    public JButton getHome() {
        return home;
    }

    public void setHome(JButton home) {
        this.home = home;
    }

    public JButton getMessages() {
        return messages;
    }

    public void setMessages(JButton messages) {
        this.messages = messages;
    }

    public JButton getProfile() {
        return profile;
    }

    public void setProfile(JButton profile) {
        this.profile = profile;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public static void main(String [] arg){
        JFrame frame=new JFrame();
        frame.setSize(100,100);
        frame.add(new TopNav());
        frame.setVisible(true);
    }

    public JTextField getSearch() {
        return search;
    }

    public void setSearch(JTextField search) {
        this.search = search;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public JButton getConfirm() {
        return confirm;
    }

    public void setConfirm(JButton confirm) {
        this.confirm = confirm;
    }
}
