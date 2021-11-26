package com.example.myfirstapp.main.Commands;

import java.util.ArrayList;

public abstract class GenreCommand extends Command{
    private String COMMANDSTRING;
    private final ArrayList<Command> subCommands = new ArrayList<>();
    private ArrayList<String> VIEWEDGENRES = new ArrayList<>();

    public GenreCommand(){}

    public abstract void execute(String username, ArrayList<String> genres) throws Exception;

    public String getCommandName(){return COMMANDSTRING;}
    public void addSubCommands(Command command){subCommands.add(command);}

    public void setCOMMANDSTRING(String command){COMMANDSTRING = command;}
    public ArrayList<Command> getSubCommands() {return subCommands;}

    public void setVIEWEDGENRES(ArrayList<String> genres){VIEWEDGENRES = genres;}
    public void addVIEWEDGENRE(String genre){VIEWEDGENRES.add(genre);}
    public ArrayList<String> getViewedGenre() {return VIEWEDGENRES;}

}
