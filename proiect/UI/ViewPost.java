package UI;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class ViewPost extends JPanel {

    public ViewPost(int userID){
        setLayout(new GridLayout(15,1));
        setSize(600,800);
        int[]posters=personFriend(userID);
        for (int poster : posters) {
            Description[] descriptions = findDescription(poster);
            int index = 0;
            String name = findName(userID);
            if(descriptions.length>0){
                add(new PostFrame(name, descriptions[index].getDescription(), descriptions[index].rgb));
            }
        }
    }

    public int[] personFriend(int user){
        String query="SELECT case when user1="+user+" then user2 else case when user2="+user+ " then user1 else null end end as poster from friends   ;";
        ArrayList<Integer> person=new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while (rs.next()) {
                person.add(rs.getInt("poster"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        int[] posters=new int[person.size()];
        for(int i=0; i<person.size();i++){
            posters[i]= person.get(i);
        }
        //posters[person.size()+1]=0;
        return posters;
    }
    public Description[] findDescription(int user){
        ArrayList<String> descriptions=new ArrayList<>();
        ArrayList<Color> rgb=new ArrayList<>();
        String query="select description as description, \"colorRGB\" as rgb from post join description d on d.d_id = post.description_id" +
                " join \"user\" u on u.user_id = d.user_id where u.user_id="+ user+" order by post_id";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while (rs.next()) {
                descriptions.add(rs.getString("description"));
                rgb.add(new Color(rs.getInt("rgb")));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        Description []description=new Description[descriptions.size()];
        for(int i=0; i<description.length; i++){
            description[i]=new Description();
        }

        for(int i=0; i<description.length; i++){
            description[i].setDescription(descriptions.get(i));
            description[i].setRgb(rgb.get(i));
        }
        return description;
    }
    public String findName(int user){
        String query="Select nume as lname, prenume as fname from \"user\" where user_id="+user;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while (rs.next()) {
                return rs.getString("fname")+" "+rs.getString("lname");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return "null";
    }
}
