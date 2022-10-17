import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String input = "";
        ArrayList<User> userList = new ArrayList<>();
        Integer userId = 0;
        String name = "";
        while(!input.equals("9")){

            if(userList.isEmpty()){
                menu(1);
                name = reader.nextLine();
                userList.add(new User(name));
            }

            System.out.println("Hello "+userList.get(userId).getName());
            menu(0);

            input = reader.nextLine();

            if(input.equals("1") || input.equals("6")){
                menu(2);
                name = reader.nextLine();
                boolean contain = false;
                for(int i = 0; i < userList.size(); i++){
                    if(userList.get(i).getName().equals(name)){
                        userId = i;
                        menu(3);
                        contain = true;
                    }
                }
                if(contain == false){
                    menu(4);
                }

            }

            if(input.equals("2")){
                userList.get(userId).getRoutine().printRoutine();
            }

            if(input.equals("3")){
                userList.get(userId).getRoutine().addExercise();
            }

            if(input.equals("4")){
                userList.get(userId).getRoutine().removeExercise();
            }

            if(input.equals("5")){
                System.out.print("Enter the day: ");
                input = reader.nextLine();
                userList.get(userId).getRoutine().tracker(input);
            }

            if(input.equals("7")){
                menu(1);
                name = reader.nextLine();
                Boolean contain = false;
                for(int i = 0; i < userList.size(); i++){
                    if(userList.get(i).getName().equals(name)){
                        menu(6);
                        contain = true;
                    }
                }
                if(contain == false){
                    userList.add(new User(name));
                    userId = userList.size() - 1;
                }
            }

            if(input.equals("8")){
                menu(2);
                name = reader.nextLine();
                for(int i = 0; i < userList.size(); i++){
                    if(userList.get(i).getName().equals(name)){
                        userList.remove(i);
                        userId = 0;
                        menu(5);
                    }
                }
            }
        }
    }
    public static void menu(int i){
        if(i == 0){
            System.out.println(
                    "1. Login\n" +
                            "2. View Routine\n" +
                            "3. Add Exercise\n"+
                            "4. Remove Exercise\n" +
                            "5. Track Exercise\n" +
                            "6. Switch Account\n" +
                            "7. Create Account\n" +
                            "8. Remove Account\n" +
                            "9. Exit"
            );
        }
        if(i == 1){
            System.out.print("Enter your name: ");
        }
        if(i == 2){
            System.out.print("Enter your user name: ");
        }
        if(i == 3){
            System.out.println("Logged in");
        }
        if(i == 4){
            System.out.println("No user under that name");
        }
        if(i == 5){
            System.out.println("Removed");
        }
        if(i == 6){
            System.out.println("There is already someone with that name");
        }
    }

}