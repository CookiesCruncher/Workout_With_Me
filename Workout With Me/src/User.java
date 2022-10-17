public class User {
    private String name;
    private Integer id = 0;
    private Routine routine;

    public User(String n){
        name = n;
        id ++;
        routine = new Routine();
    }

    public String getName(){
        return name;
    }
    public Routine getRoutine(){ return routine;}
}
