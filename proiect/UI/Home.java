package UI;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {
    Post postArea=new Post();
    ViewPost content;
    public Home(int userId){

        setLayout(new GridBagLayout());
        setSize(500,500);
        GridBagConstraints c=new GridBagConstraints();
        c.weightx=1.0;
        c.weighty=0.2;
        add(postArea, c);

        content=new ViewPost(userId);
        c.gridy=2;
        c.weightx=1.0;
        c.weighty=0.8;
        add(content, c);
    }

    public void refresh(int userID){
        GridBagConstraints c=new GridBagConstraints();
        content=new ViewPost(userID);
        content.setVisible(true);
    }

    public Post getPostArea() {
        return postArea;
    }

    public void setPostArea(Post postArea) {
        this.postArea = postArea;
    }

    public ViewPost getContent() {
        return content;
    }

    public void setContent(ViewPost content) {
        this.content = content;
    }


}
