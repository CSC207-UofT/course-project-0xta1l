import java.util.HashMap;

public class UserSecurity {
    // mapping of username to password
    private HashMap<String, String> UserPassword = new HashMap<>();

    // mapping of username to user
    private HashMap<String, User> UsernameList = new HashMap<>();

    public HashMap<String, User> getUsernames() {return UsernameList;}

    public void checkPassword(String username, String password){
        try{
            if (this.UserPassword.get(username).equals(password)){
                System.out.println("Password is valid");
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void changePassword(String username, String password){
        // Changes user password for given username
        this.UserPassword.replace(username, password);

        // sets the new password for user.
        this.UsernameList.get(username).setPassword(password);
    }
}
