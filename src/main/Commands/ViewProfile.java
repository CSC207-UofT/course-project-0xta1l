package Commands;

import Controllers.UserRequestProfile;
import Presenters.ProfileDisplay;


public class ViewProfile extends Command {
    public static String COMMANDSTRING = "view profile";

    ViewProfile(){
        setCOMMANDSTRING(COMMANDSTRING);
        addSubCommands(new ViewUserReviews());
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
