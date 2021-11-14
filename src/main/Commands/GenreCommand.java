package Commands;

import java.util.ArrayList;

public abstract class GenreCommand extends Command{
    private String COMMANDSTRING;
    private final ArrayList<Command> subCommands = new ArrayList<>();
    private String VIEWEDGENRE;

    public GenreCommand(){}

    public abstract void execute(String username, String genre) throws Exception;

    public String getCommandName(){return COMMANDSTRING;}
    public void addSubCommands(Command command){subCommands.add(command);}

    public void setCOMMANDSTRING(String command){COMMANDSTRING = command;}
    public ArrayList<Command> getSubCommands() {return subCommands;}
    
    public void setVIEWEDGENRE(String genre){VIEWEDGENRE = genre;}
    public String getViewedGenre() {return VIEWEDGENRE;}

}
