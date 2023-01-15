package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

public class BigScreen extends JFrame {
    int userID =0;
    DatabaseCon db=new DatabaseCon();
    TopNav topNav=new TopNav();
    String nume ="";
    int currentID=0;
    String prenume="";
    JButton logIn=new JButton();
    LogIn main=new LogIn();
    public BigScreen(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.HORIZONTAL;
        setSize(1000,900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(main, gbc);
        ActionListener log= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!main.getEmailLog().getText().contains("@")){
                    JOptionPane.showMessageDialog(null,"please input a valid email");
                }else{
                    String query="Select user_id as id from \"user\" where email='"+
                            main.getEmailLog().getText()+"' and password='"+ main.getPasswordLog().getText()+ "';";
                    try {
                        Class.forName("org.postgresql.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
                        Statement statement = connection.createStatement();
                        ResultSet rs = statement.executeQuery(query);
                        while(rs.next())
                            userID = rs.getInt("id");
                        connection.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        JOptionPane.showMessageDialog(null,"the email or the password is wrong");
                        ex.printStackTrace();
                        //throw new RuntimeException(ex);
                    }
                    main.setVisible(false);
                    add(topNav);
                    query= "Select nume as lname, prenume as fname from social_media.public.\"user\" where user_id="+ userID;
                    try {
                        Class.forName("org.postgresql.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
                        Statement statement = connection.createStatement();
                        ResultSet rs = statement.executeQuery(query);
                        while(rs.next()) {
                            prenume=rs.getString("fname");
                            nume=rs.getString("lname");
                        }
                        connection.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        //JOptionPane.showMessageDialog(null,"the email or the password is wrong");
                        ex.printStackTrace();
                        //throw new RuntimeException(ex);
                    }

                    JOptionPane.showMessageDialog(null, nume+prenume);
                    topNav.getTitle().setText("Welcome, "+ nume+ " "+ prenume);
                    //topNav.setVisible(true);
                }
            }
        };

        topNav.getHm().getPostArea().getPost().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(topNav.getHm().getPostArea().getDescription().getText().trim().length() == 0){
                    int id=0;
                    try {
                        String query="Select max(d_id) as id from social_media.public.description;";
                        Class.forName("org.postgresql.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
                        Statement statement = connection.createStatement();
                        ResultSet rs = statement.executeQuery(query);
                        while(rs.next()) {
                            id=rs.getInt("id");
                        }
                        connection.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        //JOptionPane.showMessageDialog(null,"the email or the password is wrong");
                        ex.printStackTrace();
                        //throw new RuntimeException(ex);
                    }
                    currentID=id; // get id of description

                    try {//insert the description
                        String query="INSERT INTO social_media.public.description VALUES ("+ id+ ", " +
                                currentID+ ", '"+topNav.getHm().getPostArea().getDescription().getText()+"', "+
                                topNav.getHm().getPostArea().getDescription().getForeground().getRGB()+ "')";
                        Class.forName("org.postgresql.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(query);
                        connection.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {// get an id for post
                        String query="Select max(post_id) as id from social_media.public.post;";
                        Class.forName("org.postgresql.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
                        Statement statement = connection.createStatement();
                        ResultSet rs = statement.executeQuery(query);
                        while(rs.next()) {
                            id=rs.getInt("id");
                        }
                        connection.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        //JOptionPane.showMessageDialog(null,"the email or the password is wrong");
                        ex.printStackTrace();
                        //throw new RuntimeException(ex);
                    }

                    try { // Create the post
                        String query="INSERT INTO social_media.public.post VALUES ("+ id+ ", " +
                                currentID+ ", null, null, "+ userID+ ")";

                        Class.forName("org.postgresql.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(query);
                        connection.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        main.getLogIn().addActionListener(log);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    log.actionPerformed(null);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setVisible(true);
    }
}
