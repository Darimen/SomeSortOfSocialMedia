package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BigScreen extends JFrame {
    int userID =0;
    TopNav topNav=new TopNav();
    String nume ="";
    int descriptionID =0;
    String prenume="";
    JButton logIn=new JButton();
    LogIn main=new LogIn();
    Home home;
    Messages messages=new Messages();
    Profile profile=new Profile(userID);
    public BigScreen(){
        setup();

        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(main, gbc);// starts with the logIn
        home=new Home(userID);
        ActionListener log= logInAction(gbc);

        //adds the action of posting to home;
        main.getLogIn().addActionListener(log);
        home.getPostArea().getPost().addActionListener(posting(gbc));
        gbc.gridy=2;
        add(home,gbc);
        add(messages, gbc);
        add(profile, gbc);
        hideAccount(); // hides everything that's now the login form

        topNav.getHome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(home.ID==0)
                    home=new Home(userID);
                home.setVisible(true);
                messages.setVisible(false);
                profile.setVisible(false);
            }
        });
        topNav.getMessages().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(home.ID==0)
                    home=new Home(userID);
                home.setVisible(false);
                messages.setVisible(true);
                profile.setVisible(false);
            }
        });
        topNav.getProfile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.setVisible(false);
                messages.setVisible(false);
                if(profile.ID==0)
                    profile=new Profile(userID);
                profile.setVisible(true);
            }
        });
        topNav.getConfirm().addActionListener(searching());
        home.setContent(new ViewPost(userID));
        setVisible(true);
    }

    private ActionListener searching(){
        return e -> {
            JFrame searchPerson=new JFrame();
            searchPerson.setSize(500,900);
            searchPerson.setLayout(new GridLayout(20,1));
            searchPerson.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            int length=topNav.getSearch().getText().length();
            int posSpace=topNav.getSearch().getText().indexOf(" ");
            try {
                String query="Select user_id as id, nume as lastname, prenume as firstname, data_nasteri as birthday from \"user\"" +
                        " where nume like '%"+topNav.getSearch().getText()+"%' or " +
                        " prenume like '%"+topNav.getSearch().getText()+"%' ";
                if(posSpace!=-1 && length>posSpace){
                    query= query.concat("  or (nume like '%"+topNav.getSearch().getText().substring(0,posSpace-1)+"%' and prenume like '%" +
                            topNav.getSearch().getText().substring(posSpace+1)+"%') or " +
                            " prenume like '%"+topNav.getSearch().getText().substring(0,posSpace-1)+"%' and nume like '%"+
                            topNav.getSearch().getText().substring(posSpace+1)+"%'");
                }
                //JOptionPane.showMessageDialog(null, query);
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while(rs.next()) {
                    ProfileSearched person=new ProfileSearched(userID,rs.getInt("id"), rs.getString("firstname"),
                            rs.getString("lastname"), rs.getDate("birthday").toString());
                    searchPerson.add(person);
                }
                connection.close();
            } catch ( ClassNotFoundException | SQLException ex) {
                //throw new RuntimeException(ex);
                ex.printStackTrace();
            }
            searchPerson.setVisible(true);
        };
    }
    private ActionListener logInAction(GridBagConstraints gbc){
        return e ->
            {
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
                    gbc.gridy=1;
                    add(topNav, gbc);
                    //home=new Home(userID);
                    gbc.gridy=2;
                    home=new Home(userID);
                    profile=new Profile(userID);
                    add(home, gbc);
                    home.setVisible(true);
                    add(profile,gbc);
                    profile.setVisible(false);
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

                    //JOptionPane.showMessageDialog(null, nume+prenume);
                    topNav.getTitle().setText("Welcome, "+ nume+ " "+ prenume);
                    //topNav.setVisible(true);
                }
            };

    }

    private void setup(){
        setLayout(new GridBagLayout());
        setSize(1000,900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0x318EFF));
    }

    private ActionListener posting(GridBagConstraints gbc){
        return e->{{
            if(home.getPostArea().getDescription().getText().trim().length() != 0){
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
                descriptionID =id; // get id of description
                id++;
                try {//insert the description
                    String query="INSERT INTO social_media.public.description VALUES ("+ id+ ", " +
                            userID+ ", '"+home.getPostArea().getDescription().getText()+"', "+
                            home.getPostArea().getDescription().getForeground().getRGB()+ ")";
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
                id++;
                descriptionID++;

                try { // Create the post
                    String query="INSERT INTO social_media.public.post VALUES ("+ id+ ", " +
                            descriptionID + ", null, null, "+ userID+ ")";

                    Class.forName("org.postgresql.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(query);
                    connection.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"There is nothing to be posted");
            }
        }
        };
    }
    private void hideAccount(){
        home.setVisible(false);
        messages.setVisible(false);
        profile.setVisible(false);
    }
}
