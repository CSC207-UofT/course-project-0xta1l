package com.example.myfirstapp.main.Commands;

public class HomePage extends Command{

        public static String COMMANDSTRING = "home";
        public HomePage(){
            setCOMMANDSTRING(COMMANDSTRING);
            addSubCommands(new ViewGenres());
            addSubCommands(new ViewUserProfile());
            addSubCommands(new ViewSavedRecipes());
            addSubCommands(new UploadRecipe());
            addSubCommands(new Logout());
        }

        @Override
        public void execute(String username) throws Exception {
        }

}
