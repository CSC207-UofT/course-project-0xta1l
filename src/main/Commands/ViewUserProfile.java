package Commands;

import Controllers.UserRequestProfile;
import Presenters.ProfileDisplay;


public class ViewUserProfile extends Command {
    public static String COMMANDSTRING = "view user profile";

    ViewUserProfile(){
        setCOMMANDSTRING(COMMANDSTRING);
        //addSubCommands(new ChangeSecurity());   PHASE 2!
        //addSubCommands(new ChangeAccountDetails());   PHASE 2!
    }


    @Override
    public void execute(String username) {
        UserRequestProfile profile = new UserRequestProfile();
        ProfileDisplay display = new ProfileDisplay();
        display.displayProfile(profile.getProfile(username));
    }
}