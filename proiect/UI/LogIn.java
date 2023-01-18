package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.Objects;


public class LogIn extends JPanel {


    JButton logIn=new JButton("LogIN");
    JButton signUp= new JButton("SignUP");
    JTextField emailLog=new JTextField("email", 40);
    JPasswordField passwordLog=new JPasswordField("password", 20);
    JTextField firstName=new JTextField("first name", 5);
    JTextField lastName=new JTextField("last name", 5);
    JTextField email=new JTextField("email");
    JPasswordField password=new JPasswordField("password");
    DatepickerUI datepicker=new DatepickerUI();
    private final String[] gen={"Other","M", "F"};
    JComboBox<String> sex=new JComboBox<>(gen);

    public LogIn(){
        setSize(900, 900);
        setLayout(new GridLayout(15,20, 10,5));
        Color back=new Color(255, 167, 65);
        setBackground(back);
        datepicker.setBackground(back);
        GridBagConstraints c = new GridBagConstraints();
        //c.fill=GridBagConstraints.HORIZONTAL;

        JLabel title=new JLabel("Welcome to IMessage, please Log in");
       // title.setFont(Font.getFont("Calimbri"));
        title.setSize(100,20);
        add(title, c);
        setGBC(c,1,1,1, 1);
        //emailLog.setPreferredSize(new Dimension(20, 10));
        add(emailLog,c);
        emailLog.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Objects.equals(emailLog.getText(), "email")) {
                    emailLog.setText("");
                }
                if(Objects.equals(passwordLog.getText(), "")){
                    passwordLog.setText("password");
                }
                if(Objects.equals(password.getText(), "")){
                    password.setText("password");
                }
                if(Objects.equals(firstName.getText(), "")){
                    firstName.setText("first name");
                }
                if(Objects.equals(lastName.getText(), "")){
                    lastName.setText("last name");
                }
                if(Objects.equals(email.getText(), "")){
                    email.setText("email");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        email.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Objects.equals(emailLog.getText(), "")) {
                    email.setText("email");
                }
                if(Objects.equals(passwordLog.getText(), "")){
                    passwordLog.setText("password");
                }
                if(Objects.equals(password.getText(), "")){
                    password.setText("password");
                }
                if(Objects.equals(firstName.getText(), "")){
                    firstName.setText("first name");
                }
                if(Objects.equals(lastName.getText(), "")){
                    lastName.setText("last name");
                }
                if(Objects.equals(email.getText(), "email")){
                    email.setText("");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                email.setText("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        passwordLog.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Objects.equals(emailLog.getText(), "")) {
                    emailLog.setText("email");
                }
                if(Objects.equals(passwordLog.getText(), "password")){
                    passwordLog.setText("");
                }
                if(Objects.equals(password.getText(), "")){
                    password.setText("password");
                }
                if(Objects.equals(firstName.getText(), "")){
                    firstName.setText("first name");
                }
                if(Objects.equals(lastName.getText(), "")){
                    lastName.setText("last name");
                }
                if(Objects.equals(email.getText(), "")){
                    email.setText("email");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        password.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Objects.equals(emailLog.getText(), "")) {
                    emailLog.setText("Email");
                }
                if(Objects.equals(passwordLog.getText(), "")){
                    passwordLog.setText("password");
                }
                if(Objects.equals(password.getText(), "password")){
                    password.setText("");
                }
                if(Objects.equals(firstName.getText(), "")){
                    firstName.setText("first name");
                }
                if(Objects.equals(lastName.getText(), "")){
                    lastName.setText("last name");
                }
                if(Objects.equals(email.getText(), "")){
                    email.setText("email");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstName.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Objects.equals(emailLog.getText(), "")) {
                    emailLog.setText("Email");
                }
                if(Objects.equals(passwordLog.getText(), "")){
                    passwordLog.setText("password");
                }
                if(Objects.equals(password.getText(), "")){
                    password.setText("password");
                }
                if(Objects.equals(firstName.getText(), "first name")){
                    firstName.setText("");
                }
                if(Objects.equals(lastName.getText(), "")){
                    lastName.setText("last name");
                }
                if(Objects.equals(email.getText(), "")){
                    email.setText("email");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        lastName.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Objects.equals(emailLog.getText(), "")) {
                    emailLog.setText("Email");
                }
                if(Objects.equals(passwordLog.getText(), "")){
                    passwordLog.setText("password");
                }
                if(Objects.equals(password.getText(), "")){
                    password.setText("password");
                }
                if(Objects.equals(firstName.getText(), "")){
                    firstName.setText("first name");
                }
                if(Objects.equals(lastName.getText(), "last name")){
                    lastName.setText("");
                }
                if(Objects.equals(email.getText(), "")){
                    email.setText("email");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        setGBC(c, 2,1,1,1);
        add(passwordLog,c);
        setGBC(c,2,2,1,1);
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(logIn,c);
        setGBC(c, 0,3,1,1);

        JLabel signUpPls=new JLabel("New Account:");
        add(signUpPls, c);

        setGBC(c, 1,3,1,1);
        add(firstName, c);
        c.gridx=2;
        add(lastName, c);
        setGBC(c, 1,4,1,1);
        c.gridwidth=1;
        add(email,c);
        c.gridx=2;
        add(password, c);
        setGBC(c,1,5,2,1);
        add(datepicker);
        c.gridx=2;
        ActionListener signUp = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!email.getText().contains("@")){
                    JOptionPane.showMessageDialog(null, "Please input a valid email!");
                }
                else if(Objects.equals(datepicker.getYearField().getText(), "") ||Objects.equals(datepicker.getDayField().getText(), "") ||
                        Objects.equals(datepicker.getMonthField().getText(), "")){
                    JOptionPane.showMessageDialog(null, "Please input a valid date!");
                }
                else {
                    int id = 1;
                    String idQ = "select max(user_id) as \"user_id\" from \"user\";";
                    try {
                        Class.forName("org.postgresql.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
                        Statement statement = connection.createStatement();
                        ResultSet rs = statement.executeQuery(idQ);
                        while (rs.next()) {
                            id += rs.getInt("user_id");

                        }
                        connection.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        ex.printStackTrace();
                        //throw new RuntimeException(ex);
                    }
                    //System.out.println(id);
                    String query = "insert into \"public\".\"user\" values(" + id + ", '" + lastName.getText() + "', '" + firstName.getText() + "'," +
                            "to_date('" + datepicker.getDayField().getText() + "." + datepicker.getMonthField().getText() + "." +
                            datepicker.getYearField().getText() + "', 'DD.MM.YYYY'), '" + sex.getSelectedItem() + "', '" +
                            email.getText() + "', '" + password.getText() + "');";
                    try {
                        Class.forName("org.postgresql.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_media", "postgres", "darius2002");
                        Statement statement = connection.createStatement();
                        statement.execute(query);
                        connection.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        ex.printStackTrace();
                        //throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null, "Account created! Welcome here!");
                }
            }
        };
        this.signUp.addActionListener(signUp);
        setGBC(c,2,5,2,1);
        add(sex,c);
        setGBC(c,3,5,2,1);

        add(this.signUp, c);

        setVisible(true);

    }

    public void setGBC(GridBagConstraints c,int x, int y, int w, int h){
        c.gridwidth=w;
        c.gridheight=h;
        c.gridx=x;
        c.gridy=y;
    }
/*
    public static void main(String []arg){
        JFrame fram=new JFrame();
        fram.setLayout(new GridBagLayout());
        fram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LogIn panel=new LogIn();
        fram.add(panel);
        fram.setVisible(true);
    }*/

    public JButton getLogIn() {
        return logIn;
    }

    public void setLogIn(JButton logIn) {
        this.logIn = logIn;
    }

    public JButton getSignUp() {
        return signUp;
    }

    public void setSignUp(JButton signUp) {
        this.signUp = signUp;
    }

    public JTextField getEmailLog() {
        return emailLog;
    }

    public void setEmailLog(JTextField emailLog) {
        this.emailLog = emailLog;
    }

    public JPasswordField getPasswordLog() {
        return passwordLog;
    }

    public void setPasswordLog(JPasswordField passwordLog) {
        this.passwordLog = passwordLog;
    }

}
