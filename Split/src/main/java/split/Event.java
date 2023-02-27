package split;
import java.io.*;
import java.util.*;

public class Event extends Trip {
    
    private String name;
    private int memberCount = 0;
    private int adminCount = 0;

    public Event(String name) {
        this.name = name;
        events.add(this);
    }

    public Event() {}
    

}
