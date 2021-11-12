package Commands;

import java.util.ArrayList;

public abstract class Command {
    private String COMMANDSTRING;
    private final ArrayList<Command> subCommands = new ArrayList<>();

    public Command(){}

    public abstract void execute(String username) throws Exception;

    public String getCommandName(){return COMMANDSTRING;}
    public void addSubCommands(Command command){subCommands.add(command);}

    public void setCOMMANDSTRING(String command){COMMANDSTRING = command;}
    public ArrayList<Command> getSubCommands() {return subCommands;}


}
