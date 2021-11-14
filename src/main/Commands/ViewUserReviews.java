package Commands;

import Controllers.UserRequestGetReview;
import Controllers.UserRequestProfile;
import Presenters.ListDisplay;
import Presenters.ProfileDisplay;

public class ViewUserReviews extends Command {
    public static String COMMANDSTRING = "view user reviews";

    ViewUserReviews(){
        setCOMMANDSTRING(COMMANDSTRING);
    }

    @Override
    public void execute(String username) {
        UserRequestGetReview get = new UserRequestGetReview();
        ListDisplay display = new ListDisplay();
        display.userReviews(get.getuserreview(username));
    }
}
