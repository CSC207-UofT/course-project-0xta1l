package UI;
import Controllers.UserRequestBrowse;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ListDisplay {
    public void Display(ArrayList<Object> browseInfo) {
        if (browseInfo instanceof ArrayList<String>) {
            for (String str : browseInfo) {
                System.out.println(str + "\n");
            }

        }else{
            for (Object r: browseInfo){
                System.out.println(r + "\n");
            }
        }
    }
    public void tDisplay(ArrayList<String> browseInfo) {
        if (browseInfo instanceof ArrayList<String>) {
            for (String str : browseInfo) {
                System.out.println(str + "\n");
            }

        }else{
            for (Object r: browseInfo){
                System.out.println(r + "\n");
            }
        }
    }

}
