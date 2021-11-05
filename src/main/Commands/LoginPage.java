package Commands;

import java.util.ArrayList;

public class LoginPage extends Command{

    public static String COMMANDSTRING = "login page";
    LoginPage(){
        setCOMMANDSTRING(COMMANDSTRING);
        addSubCommands(new HomePage());
        addSubCommands(new CreateNewAccount());
    }

    @Override
    public void execute(String username) {}

}
