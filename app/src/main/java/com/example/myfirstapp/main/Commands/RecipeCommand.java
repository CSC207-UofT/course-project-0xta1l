package Commands;

import java.util.ArrayList;

public abstract class RecipeCommand extends Command{
    private String COMMANDSTRING;
    private final ArrayList<Command> subCommands = new ArrayList<>();
    private String VIEWEDRECIPE;
    private String VIEWEDGENRE;

    public RecipeCommand(){}

    public abstract void execute(String username, String recipeID) throws Exception;

    public String getCommandName(){return COMMANDSTRING;}
    public void addSubCommands(Command command){subCommands.add(command);}

    public void setCOMMANDSTRING(String command){COMMANDSTRING = command;}
    public ArrayList<Command> getSubCommands() {return subCommands;}

    public void setVIEWEDRECIPE(String recipeID){VIEWEDRECIPE = recipeID;}
    public void setVIEWEDGENRE(String genre){VIEWEDGENRE = genre;}
    public String getViewedRecipe() {return VIEWEDRECIPE;}
    public String getViewedGenre() {return VIEWEDGENRE;}

}
