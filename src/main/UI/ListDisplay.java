package UI;
import Controllers.UserRequestBrowse;
import

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ListDisplay {
    public ListDisplay(UserRequestBrowse browseInfo) {
        if (browseInfo instanceof ArrayList<String>) {
            for (String str : browseInfo) {
                System.out.println(str + "\n");
            }

        }else{
            for (Recipe r: browseInfo){
                System.out.println(r + "\n");
            }
        }
    }
}
