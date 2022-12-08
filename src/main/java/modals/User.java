package modals;

public class User {
    String email;
    String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
        //return new User();
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
        //return new User();

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

