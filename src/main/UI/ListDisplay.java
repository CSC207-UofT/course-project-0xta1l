package UI;
import Controllers.UserRequestBrowse;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ListDisplay {
    public void Display(ArrayList<Object> browseInfo) {
        if (browseInfo.get(1).equals("Genre")) {
            for (String genre : browseInfo.get(0)) {
                System.out.println(genre + "\n");
            }

        }else{
            for (Object r: browseInfo.get(0)){
                System.out.println(r + "\n");
            }
        }
    }

}
