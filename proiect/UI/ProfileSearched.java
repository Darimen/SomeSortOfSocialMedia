package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ProfileSearched extends JPanel {
    JButton addFriend=new JButton();
    int userID=0;
    int userID2=0;
    public ProfileSearched(int u1, int u2, String firstName, String lastName, String birthday){
        userID=u1;
        userID2=u2;
        setLayout(new GridLayout(2,3));
        add(new JLabel(firstName));
        add(new JLabel(lastName));
        add(new JLabel(birthday));
        add(addFriend);
        boolean friends;
        if(existingFriendship(userID, userID2)){
            addFriend.setText("Unfriend");
        }
        else{
            addFriend.setText("Add Friend");
        }
        addFriend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!existingFriendship(userID, userID2)){
                    addFriend.setText("Unfriend");
                    createFriendship(userID, userID2);
                }
                else{
                    addFriend.setText("Add Friend");
                    deleteFriendship(userID,userID2);
                }
            }
        });
    }

    public boolean existingFriendship(int user1, int user2){
        String query="SELECT case when(user1=" + user1+" AND user2="+ user2+") or (user2=" + user1+" AND user1=" +
                 user2+") THEN 1 ELSE 0 END as result from friends";
        try { // Create the post
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
            Statement statement = connection.createStatement();
            ResultSet rs= statement.executeQuery(query);
            while (rs.next()) {
                boolean ans=(rs.getInt("result") == 1);
                System.out.println(ans);
                if(ans){
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public void createFriendship(int user1, int user2){
        String query="insert into friends values ("+user1+","+ user2;
        String selectingMax="select max(friend_id) as id from friends";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
            Statement statement = connection.createStatement();
            ResultSet rs= statement.executeQuery(selectingMax);
            int id=0;
            while(rs.next()){
                 id=rs.getInt("id");
            }
            id++;
            query+=","+id+")";
            statement.executeUpdate(query);
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteFriendship(int user1, int user2){
        String query="delete from friends where (user1="+user1+" and user2="+user2+
                ") or (user1="+user2+" and user2="+user1+")";
        try {
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
