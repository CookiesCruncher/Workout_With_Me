import java.util.ArrayList;
import java.util.Scanner;

public class Exercise {
    private String name;
    private Integer[] set;
    private short min;
    private short max;
    private short weight;

    private Scanner reader= new Scanner(System.in);

    public Exercise(){
    }
    public Exercise(String n, short s, short min, short max, short w){
        name = n;
        set = new Integer[s];
        this.min = min;
        this.max = max;
        weight = w;
    }
    public String getName(){
        return name;
    }

    public Integer[] getSet(){return set;}

    public void track(){
        for(int i = 0; i < set.length; i++){
            Integer r = reader.nextInt();
            reader.nextLine();
            set[i] = r;
        }
    }
    public short getMin(){return min;}

    public short getMax(){return max;}
    public short getWeight(){return weight;}
}