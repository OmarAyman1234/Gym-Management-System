import java.util.List;
import java.util.Scanner;

public class Admin extends User {
    private Scanner scanner = new Scanner(System.in);

    public Admin(String id, String username, String password, String name, String email, String phone) {
        super(id, username, password, name, email, phone);
    }

    public void manageCoaches() {
        while (true) {
            System.out.println("\n=== Manage Coaches ===");
            System.out.println("1. Add Coach");
            System.out.println("2. Delete Coach");
            System.out.println("3. Update Coach");
            System.out.println("4. List Coaches");
            System.out.println("5. Search Coach");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCoach();
                    break;
                case 2:
                    deleteCoach();
                    break;
                case 3:
                    updateCoach();
                    break;
                case 4:
                    listCoaches();
                    break;
                case 5:
                    searchCoach();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public void manageMembers() {
        // Similar implementation to manageCoaches()
    }

    public void manageBilling() {
        System.out.println("\n=== Billing Management ===");
        // Implementation for billing management
    }

    public void generateReports() {
        System.out.println("\n=== Generate Reports ===");
        // Implementation for report generation
    }

    public void assignMembersToCoaches() {
        System.out.println("\n=== Assign Members to Coaches ===");
        // Implementation for member assignment
    }

    @Override
    public void updateProfile() {
        System.out.println("\n=== Update Profile ===");
        // Implementation for profile update
    }

    private void addCoach() {
        // Implementation for adding a coach
    }

    private void deleteCoach() {
        // Implementation for deleting a coach
    }

    private void updateCoach() {
        // Implementation for updating a coach
    }

    private void listCoaches() {
        // Implementation for listing coaches
    }

    private void searchCoach() {
        // Implementation for searching a coach
    }
}