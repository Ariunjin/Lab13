public class User {
    String username;
    String password;
    User(String username,String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof User)) return false;
        User newuser = (User) obj;
        return this.username.equals(newuser.username) && this.password.equals(newuser.password);
    }
}
