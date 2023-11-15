package zork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class World {


    private final Map<String, Room> rooms = new HashMap<>();
    public Room currRoom;
    public String file;


    public World(String file) {
        this.file = file;
    }


    private void saveRoom(Room room) { 
        rooms.put(room.getRoomID(), room); 
    }


        
    public void parse() {
        try (FileReader fr = new FileReader(file)){
        System.out.println("Start of try block");
        BufferedReader br = new BufferedReader(fr);
        String eachLine = br.readLine();
        Room room = null;

        while(null!= (eachLine = br.readLine())){
            eachLine.trim();
            if(eachLine.length()>0){
               String[] terms = eachLine.split(":");

            switch (terms[0]) {
                case "room":
                    room = new Room(terms[1]);
                    saveRoom(room);
                    break;

                case "name":
                    room.setRoomName(terms[1]);
                    break;

                case "description":
                    room.setDescription(terms[1]);
                    break;
                
                case "direction":
                    room.setDirection(terms[1], terms[2]);

                case "start":
                    currRoom = rooms.get(terms[1]);
            }
        }
    }
    
    }
    catch (Exception error) {
        System.out.printf("There has been an error %s", error);
    }
    finally {
        //
    }

    boolean flag = true;
    while (flag) {
        Scanner myScanner = new Scanner(System.in);
        System.out.printf(">");
        System.out.println(currRoom.getDescription());
        String userInput = myScanner.nextLine();
        Optional<String> roomId;
    
        if (userInput.contains("go")) {
            String[] terms = userInput.trim().split(" ");
            String direction = terms[1];
            if (currRoom.isAccessible(direction)){
                roomId = currRoom.getRoom(direction);
                currRoom = rooms.get(roomId);
                System.out.println(currRoom.getDescription());
            }
            else {
                System.out.println("That direction is invalid!");
            }  
        }
    }
}
    
}
   
