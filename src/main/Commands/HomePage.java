package Commands;

public class HomePage extends Command{

        public static String COMMANDSTRING = "home";
        HomePage(){
            setCOMMANDSTRING(COMMANDSTRING);
            addSubCommands(new ViewGenres());
            addSubCommands(new Logout());
        }

        @Override
        public void execute(String username) {}

}
