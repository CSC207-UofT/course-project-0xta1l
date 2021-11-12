package UseCases;

import Entities.User;
import Entities.UserInfo;
import Constants.*;

public class UserProfileViewEdit {
    public UserInfo get (String username) {
        User user = Constants.USERSECURITY.getUserByID(username);
        return user.getProfile();
    }

    public void editPassword (String username, String newPassword) {
        Constants.USERSECURITY.changePassword(username, newPassword);
    }
}
