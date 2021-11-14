package Commands;

import java.util.ArrayList;

public class CommandTree{
    public CommandNode root;
    public ArrayList<CommandNode> children;

    public CommandTree(CommandNode rootNode) {
        root = new CommandNode();
        root.command = new HomePage();
        root.children = new ArrayList<>();
    }
    public void setRoot(CommandNode node) {
        this.root = node;
    }

    public static class CommandNode {
        public Command command;
        public CommandNode parent;
        public ArrayList<CommandNode> children = new ArrayList<>();
        public void addChild(CommandNode node){
            node.setParent(this);
            this.children.add(node);}

        public Command getCommand() {return command;}
        public CommandNode getParent(){return parent;}
        public void setCommand(Command c){this.command = c;}
        public void setParent(CommandNode node){this.parent = node;}

        public String toString() {
            String tree = "";
            tree = tree + this.getCommand().getCommandName() + "\n";
            ArrayList<CommandNode> children = this.children;
            if (!children.isEmpty()) {
                for (CommandNode c: children){
                    tree = tree + "   " + c.toString() + "\n";
                }
            }
            return tree;
        }
    }

    public String toString() {
        String tree = "";
        tree = tree + this.root.getCommand().getCommandName() + "\n";
        ArrayList<CommandNode> children = this.root.children;
        if (!children.isEmpty()) {
            for (CommandNode c: children){
                tree = tree + c.toString();
            }
        }
        return tree;
    }

}



