package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TopNav extends JPanel {
    JButton home=new JButton("Home");
    JButton messages= new JButton("Messages");
    JButton profile= new JButton("Profile");
    JLabel title= new JLabel();
    JTextField search=new JTextField("search");
    ImageIcon icon=new ImageIcon("magnifying glass.png");
    JButton confirm;
    Profile prof=new Profile();
    Messages msg=new Messages();
    Home hm=new Home();
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

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hm.setVisible(true);
                msg.setVisible(false);
                prof.setVisible(false);
            }
        });

        Image image=icon.getImage();
        Image newImage=image.getScaledInstance(15,15, Image.SCALE_SMOOTH);
        ImageIcon buton=new ImageIcon(newImage);
        confirm=new JButton(buton);
        add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame search=new JFrame();
                search.setSize(500,500);
                search.setLayout(new GridLayout(40,1));
                search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                search.setVisible(true);

            }
        });

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

    public Profile getProf() {
        return prof;
    }

    public void setProf(Profile prof) {
        this.prof = prof;
    }

    public Messages getMsg() {
        return msg;
    }

    public void setMsg(Messages msg) {
        this.msg = msg;
    }

    public Home getHm() {
        return hm;
    }

    public void setHm(Home hm) {
        this.hm = hm;
    }
    public static void main(String [] arg){
        JFrame frame=new JFrame();
        frame.setSize(100,100);
        frame.add(new TopNav());
        frame.setVisible(true);
    }

}
