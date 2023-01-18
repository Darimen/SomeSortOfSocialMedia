package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class Profile extends JPanel {
    int ID;
    JPanel me=new JPanel();
    JButton delete=new JButton("delete account");
    int user=0;
    public Profile(int ID){
        this.ID=ID;
        setSize(600,900);
        setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.fill=GridBagConstraints.HORIZONTAL;
        me.setLayout(new GridBagLayout());
        me.setSize(600, 300);
        me.setPreferredSize(new Dimension(600,300));
        c.gridx=1;
        c.gridwidth=1;
        me.add(new JLabel("YOUR NAME:"),c);
        JTextField name=new JTextField(getUser(ID));
        name.setEditable(false);
        c.gridx=2;
        c.gridwidth=2;
        me.add(name,c);
        c.gridy=2;
        c.gridx=1;
        c.gridwidth=1;
        me.add(new JLabel("YOUR BIRTHDAY:"),c);
        JTextField date=new JTextField(getDate(ID));
        date.setEditable(false);
        c.gridx=2;
        c.gridwidth=2;
        me.add(date,c);
        c.gridy=3;
        c.gridx=1;
        c.gridwidth=1;
        me.add(new JLabel("YOUR EMAIL:"),c);
        JTextField email=new JTextField(getEmail(ID));
        email.setEditable(false);
        c.gridx=2;
        c.gridwidth=2;
        me.add(email,c);
        delete.addActionListener(delete());
        me.add(delete);
        add(me);
        //setVisible(true);
    }

    private String getUser(int id){
        String query="Select nume as lname, prenume as fname from \"user\" where user_id="+id;
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                return rs.getString("lname")+" "+ rs.getString("fname");
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    private String getDate(int id){
        String query="Select data_nasteri as data from \"user\" where user_id="+id;
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                return rs.getDate("data").toString();
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    private String getEmail(int id){
        String query="Select email as email from \"user\" where user_id="+id;
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                return rs.getString("email");
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] arg){
        JFrame frame=new JFrame();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Profile(2));
        frame.setVisible(true);
    }

    private ActionListener delete(){
        return e->{
            int option = JOptionPane.showOptionDialog(null, "Are you sure you want to delete your account?",
                    "Delete Account Confirmation", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (option == JOptionPane.YES_OPTION) {
                try{
                    String query="delete from post where user_id="+ID;
                    Class.forName("org.postgresql.Driver");
                    Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(query);
                    query="delete from description where user_id="+ID;
                    statement.executeUpdate(query);
                    query="delete from friends where user1="+ID+" or user2="+ID;
                    statement.executeUpdate(query);
                    query="delete from \"user\" where user_id="+ID;
                    statement.executeUpdate(query);
                    connection.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null,"The account has been permanently deleted.");
                System.exit(0);
            }
        };
    }
}
