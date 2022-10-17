import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Routine {

    Scanner reader = new Scanner(System.in);
    private Map<String, ArrayList<Exercise>> routine = new HashMap<String, ArrayList<Exercise>>();

    public Routine() {
        routine.put("Sunday", new ArrayList<Exercise>());
        routine.put("Monday", new ArrayList<Exercise>());
        routine.put("Tuesday", new ArrayList<Exercise>());
        routine.put("Wednesday", new ArrayList<Exercise>());
        routine.put("Thursday", new ArrayList<Exercise>());
        routine.put("Friday", new ArrayList<Exercise>());
        routine.put("Saturday", new ArrayList<Exercise>());
    }

    public void addExercise(){
        System.out.print("Enter the exercise name: ");
        String exercise = reader.nextLine();
        System.out.print("Enter the day for the exercise: ");
        String day = reader.nextLine();
        System.out.print("Enter the set for the exercise: ");
        short set = reader.nextShort();
        reader.nextLine();
        System.out.print("Enter the rep(min) for the exercise: ");
        short min = reader.nextShort();
        reader.nextLine();
        System.out.print("Enter the rep(max) for the exercise: ");
        short max = reader.nextShort();
        reader.nextLine();
        System.out.print("Enter the lifting weight(lbs): ");
        short weight = reader.nextShort();
        reader.nextLine();
        if(!contain(exercise, routine.get(day))){
                routine.get(day).add(new Exercise(exercise, set, min, max, weight));
                System.out.println("Added!!");
        }
        else System.out.println("That exercise already exist on "+day);
    }

    public void removeExercise(){
        System.out.print("Enter exercise name: ");
        String name = reader.nextLine();
        System.out.print("Enter the date: ");
        String day = reader.nextLine();
        if(contain(name, routine.get(day))){
            for(int i = 0; i < routine.get(day).size(); i++){
                if(routine.get(day).get(i).getName().equals(name)) {
                    routine.get(day).remove(i);
                    System.out.println("Removed!!");
                }
            }
        }
        else System.out.println("Routine does not have that data");
    }

    public void printRoutine(){
        for(String day : routine.keySet()){
            System.out.println(day+": ");
            for(Exercise e : routine.get(day)){
                System.out.println(e.getSet().length+"x "+e.getName()+" ("+e.getMin()+" - "+e.getMax()+") ("+e.getWeight()+" lbs)");
                for(int i = 0; i < e.getSet().length; i++){
                    System.out.println(i+". "+e.getSet()[i]);
                }
            }
        }
    }

    public void tracker(String day){
        for(int i = 0; i < routine.get(day).size(); i++){
            System.out.println(routine.get(day).get(i).getName()+": ");
            routine.get(day).get(i).track();
        }
    }
    public boolean contain(String i, ArrayList<Exercise> j){
        for(int k = 0; k < j.size(); k++){
            if(j.get(k).getName().equals(i)){
                return true;
            }
        }
        return false;
    }
}
