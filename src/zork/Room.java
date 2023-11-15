package zork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.text.html.Option;

public class Room {

    private final String roomID;
    private String roomName;
    private String description;
    private Map<String,String> direction = new HashMap<>();
    private List<String> items = new LinkedList<>();

    public Room(String roomID){ 
        this.roomID = roomID;
    }
    public Room(String roomID, String roomName) {
         this.roomID = roomID; 
		this.roomName = roomName;}
    
    public String getRoomID(){ 
        return roomID;
    }

    public String getRoomName(){ 
        return roomName;
    }

    public void setRoomName(String name){
        this.roomName = roomName;
    }

    public String getDescription(){ 
        return description;
    }
    public void setDescription (String desc){
        this.description = description;
    }

    public void setDirection(String dir, String roomID){
        direction.put(dir, roomID);
    }

    public boolean isAccessible(String dir) {
        return direction.containsKey(dir);
    }

    public Optional<String> getRoom(String dir) {
            if (isAccessible(dir))
               return Optional.of(direction.get(direction));
            return Optional.empty();
         }

    public void putItem(String item){
        this.items.add(item);
    }

    public List<String> getItems(){
        return Collections.unmodifiableList(this.items);
    }
   
    public Optional<String>takeItem(String item){
            List<String> newList = this.items.stream()
                .filter(i-> items.equals(i))
                .toList();
            if(newList.size()!= items.size()){
                items = newList;
                return Optional.of(item);
            }
            return Optional.empty();
        }
    
}
    
