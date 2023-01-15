package UI;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {
    Post postArea=new Post();
    Scroll content=new Scroll();
    public Home(){

        setLayout(new GridBagLayout());
        setSize(500,500);
        GridBagConstraints c=new GridBagConstraints();
        c.weightx=1.0;
        add(postArea, c);

        c.gridy=1;
        c.weightx=1;
        add(content, c);
    }

    public Post getPostArea() {
        return postArea;
    }

    public void setPostArea(Post postArea) {
        this.postArea = postArea;
    }

    public Scroll getContent() {
        return content;
    }

    public void setContent(Scroll content) {
        this.content = content;
    }
}
