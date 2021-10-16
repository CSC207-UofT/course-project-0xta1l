package UI;
import Controllers.UserRequestBrowse;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ListDisplay {
    public void DisplayGenre(ArrayList<String> browseInfo) {
        for(String str: browseInfo){
            System.out.println(str + "\n");
        }
    }
    public void DisplayListOfRecipes(ArrayList<Object> browseInfo) {
        for(Object obj: browseInfo){
            System.out.println(obj + "\n");
        }
    }
}