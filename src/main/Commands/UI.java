package Commands;
import Constants.*;
import Entities.User;

import java.util.Scanner;

public class UI {
    //CommandTree commandTree = new CommandTree(new CommandTree.CommandNode());
    CommandTree commandTree = Constants.COMMANDTREE;
    CommandTree.CommandNode currentNode = commandTree.root;
    boolean is_running = true;

    public static void main(String[] args) {
        UI ui = new UI();
        Scanner scanner = new Scanner(System.in);
        //Userlogs in here
        // User user = something
        User user = new User(); //TODO: temporary change later

        while(ui.is_running){
            try {
                for (CommandTree.CommandNode child : ui.currentNode.children) {
                    System.out.println(child.getCommand().getCommandName());
                }
                String action = scanner.nextLine(); //user types input

                boolean hasMatch = false;
                for (CommandTree.CommandNode child : ui.currentNode.children) {
                    if (action.equals(child.getCommand().getCommandName())) {
                        child.getCommand().execute(user.getUsername());
                        ui.currentNode = child;
                        hasMatch = true;
                        break;
                    } else if (action.equals("back") && !ui.currentNode.getCommand().getCommandName().equals("home")) {
                        child.getParent().getCommand().execute(user.getUsername());
                        hasMatch = true;
                        break;
                    }
                }
                if (!hasMatch) {
                    // TO FORCE SHUTDOWN PROGRAM
                    if (action.equals("SHUTDOWN")){
                        ui.is_running=false;
                    }else{System.out.println("Please enter a valid command");}
                }
            } catch(Exception e){ System.out.println(e.getMessage());}
        }
    }


}
