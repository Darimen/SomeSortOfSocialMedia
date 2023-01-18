package UI;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {
    int ID;
    Post postArea=new Post();
    ViewPost content;
    public Home(int userId){
        ID=userId;

        setLayout(new GridBagLayout());
        setSize(800,500);
        GridBagConstraints c=new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        //c.anchor=GridBagConstraints.NORTH;
        c.weightx=1.0;
        c.weighty=0.4;
        add(postArea, c);
        //.anchor=GridBagConstraints.CENTER;
        //content=new ViewPost(userId);
        c.gridy=1;
        c.weightx=1.0;
        c.weighty=0.6;
        content=new ViewPost(userId);
        content.setPreferredSize(new Dimension(500,600));
        content.setVisible(true);
        content.setSize(800,500);
        add(content, c);
    }
    public void reinit(){
        setLayout(new GridBagLayout());
        setSize(800,500);
        GridBagConstraints c=new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        //c.anchor=GridBagConstraints.NORTH;
        c.weightx=1.0;
        c.weighty=0.4;
        add(postArea, c);
        //.anchor=GridBagConstraints.CENTER;
        //content=new ViewPost(userId);
        c.gridy=1;
        c.weightx=1.0;
        c.weighty=0.6;
        content=new ViewPost(ID);
        content.setPreferredSize(new Dimension(500,600));
        content.setVisible(true);
        content.setSize(800,500);
        add(content, c);
    }
    public void refresh(){
        GridBagConstraints c=new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        content.setVisible(false);
        content=new ViewPost(ID);
        content.setPreferredSize(new Dimension(500,600));
        content.setVisible(true);
        content.setSize(800,500);
        c.gridy=1;
        c.weightx=1.0;
        c.weighty=0.6;
        add(content, c);
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
