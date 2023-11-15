package zork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class zorkGame {
    

    public static void main(String[] args) throws Exception {

        System.out.println(args[0]);

        // File file = new File(args[0]);
        // System.out.println(file);

        World zorkGame1 = new World(args[0]);
        zorkGame1.parse();

        

        // System.out.println(zorkGame1.currRoom); 



        // Processing the file to use
        System.out.println("Enter 'start' to start game");
       
                    

    }
}