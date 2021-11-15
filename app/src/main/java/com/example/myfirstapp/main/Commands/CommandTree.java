package com.example.myfirstapp.main.Commands;

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


    }
}



