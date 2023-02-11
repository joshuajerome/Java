package src;
import java.io.*;
import java.util.*;

public class Occasion extends Event {
    
    private String name;
    private int memberCount = 0;
    private int adminCount = 0;

    public Occasion(String name) {
        this.name = name;
    }


}
