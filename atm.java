import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class ATM_PIN_Generator {

    private static HashMap<String, String> userPins = new HashMap<>();
    private static Random rand = new Random();
    
    public static String generateUniquePin() {
        String pin;
        
        do {
            pin = String.format("%04d", rand.nextInt(10000));
        } while (userPins.containsValue(pin));
        
        return pin;
    }

    public static void addUser(String name) {
        String pin = generateUniquePin();
        userPins.put(name, pin);
        System.out.println("User: " + name + " | Pin Assigned: " + pin);
    }

    public static void displayUsers() {
        if (userPins.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("Existing Users and Pins:");
            for (String name : userPins.keySet()) {
                System.out.println("Name: " + name + " | Pin: " + userPins.get(name));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Pin Generator");
            System.out.println("1. Add New User");
            System.out.println("2. Display Existing Users and Pins");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter user's name: ");
                    String name = scanner.nextLine();
                    addUser(name);
                    break;
                case 2:
                    displayUsers();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
