package ua.ithlillel.dnipro.Cherednychenko;

import java.io.IOException;
import java.util.Scanner;

public interface MenuAction {
    public void doAction() throws IOException;
    public String getName();

    public default boolean closeAfter(){
            boolean close = false;
            System.out.println("If you want to close the program - please enter '4'");
            if (new Scanner(System.in).nextInt()==4){
                close=true;
                System.out.println("The program is closing");
            }
            return close;
    }
}
