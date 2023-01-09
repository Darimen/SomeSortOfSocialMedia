package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;


public class LogIn extends JPanel {
    DatabaseCon db=new DatabaseCon();
    JButton logIn=new JButton("LogIN");
    JButton signUp= new JButton("SignUP");
    JTextField emailLog=new JTextField("email", 40);
    JPasswordField passwordLog=new JPasswordField("password", 20);
    JTextField firstName=new JTextField("first name", 10);
    JTextField lastName=new JTextField("last name", 10);
    JTextField email=new JTextField("email");
    JPasswordField password=new JPasswordField("password");
    DatepickerUI datepicker=new DatepickerUI();
    private final String[] gen={"M", "F", "other"};
    JComboBox<String> sex=new JComboBox<>(gen);

    public LogIn(){

        setSize(600, 900);
        setLayout(new GridBagLayout());
        setBackground(Color.cyan);
        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.HORIZONTAL;
        JLabel title=new JLabel("Welcome to IMessage, please Log in");
        add(title, c);
        setGBC(c,1,1,1, 1);
        add(emailLog,c);
        setGBC(c, 2,1,1,1);
        add(passwordLog,c);
        setGBC(c,2,2,1,1);
        add(logIn,c);
        setGBC(c, 1,2,1,1);

        JLabel signUpPls=new JLabel("New Account:");
        add(signUpPls);

        setGBC(c, 1,3,3,1);
        add(firstName, c);
        c.gridx=4;
        add(lastName, c);
        setGBC(c, 1,4,1,1);
        c.gridwidth=3;
        add(email,c);
        c.gridx=4;
        add(password, c);
        setGBC(c,1,5,1,1);
      //  add(datepicker);
        c.gridx=2;
        ActionListener e = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query="insert into user("+ lastName.getText().toString()+", "+ firstName.getText().toString() +
                        ", "+datepicker.toString()+", "+ Objects.requireNonNull(sex.getSelectedItem()).toString()+", "+
                        email.getText().toString()+ ", "+ Arrays.toString(password.getPassword()) +")";
                db.executeQuery(query);
                setVisible(false);
            }
        };
        signUp.addActionListener(e);
        add(signUp);

        setVisible(true);

    }

    public void setGBC(GridBagConstraints c,int x, int y, int w, int h){
        c.gridwidth=w;
        c.gridheight=h;
        c.gridx=x;
        c.gridy=y;
    }

    public static void main(String []arg){
        JFrame fram=new JFrame();
        fram.setLayout(new GridBagLayout());
        fram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LogIn panel=new LogIn();
        fram.add(panel);
        fram.setVisible(true);
    }

}
