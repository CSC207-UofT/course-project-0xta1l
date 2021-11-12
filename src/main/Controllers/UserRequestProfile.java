package Controllers;
import Entities.UserInfo;
import UseCases.UserProfileViewEdit;

public class UserRequestProfile {
    private UserProfileViewEdit profile = new UserProfileViewEdit();

    public UserInfo getProfile (String username) {
        return profile.get(username);
    }

    public boolean changePassword (String username, String password, String oldPassword) {
        return true;
    }
}
