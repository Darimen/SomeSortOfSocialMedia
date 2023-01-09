import java.sql.Date;

public class User {
    String nume, prenume, sex, email, password;
    Date data;
    private final int id_count=1;
    int id;

    public User(String nume, String prenume, String sex, String email, String password, Date data) {
        this.nume = nume;
        this.prenume = prenume;
        this.sex = sex;
        this.email = email;
        this.password = password;
        this.data = data;
        this.id = id_count;
    }



    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
