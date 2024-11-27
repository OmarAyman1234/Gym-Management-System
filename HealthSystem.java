import java.util.Scanner;

public class HealthSystem {
    private UserManager userManager;
    private NotificationSystem notificationSystem;
    private FileHandler fileHandler;
    private User currentUser;
    private Scanner scanner;

    public HealthSystem() {
        this.fileHandler = new FileHandler();
        this.userManager = new UserManager(fileHandler);
        this.notificationSystem = new NotificationSystem();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            if (currentUser == null) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }

    private void showLoginMenu() {
        System.out.println("\n=== Health System Management ===");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    private void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        currentUser = userManager.authenticate(username, password);
        if (currentUser == null) {
            System.out.println("Invalid credentials!");
        }
    }

    private void showMainMenu() {
        if (currentUser instanceof Admin) {
            showAdminMenu();
        } else if (currentUser instanceof Coach) {
            showCoachMenu();
        } else if (currentUser instanceof Member) {
            showMemberMenu();
        }
    }

    private void showAdminMenu() {
        Admin admin = (Admin) currentUser;
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Manage Coaches");
            System.out.println("2. Manage Members");
            System.out.println("3. Billing Management");
            System.out.println("4. Generate Reports");
            System.out.println("5. Assign Members to Coaches");
            System.out.println("6. Update Profile");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    admin.manageCoaches();
                    break;
                case 2:
                    admin.manageMembers();
                    break;
                case 3:
                    admin.manageBilling();
                    break;
                case 4:
                    admin.generateReports();
                    break;
                case 5:
                    admin.assignMembersToCoaches();
                    break;
                case 6:
                    admin.updateProfile();
                    break;
                case 7:
                    logout();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void showCoachMenu() {
        Coach coach = (Coach) currentUser;
        while (true) {
            System.out.println("\n=== Coach Menu ===");
            System.out.println("1. Manage Member Plans");
            System.out.println("2. Send Messages to Members");
            System.out.println("3. Update Profile");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    coach.manageMemberPlans();
                    break;
                case 2:
                    coach.sendMessages();
                    break;
                case 3:
                    coach.updateProfile();
                    break;
                case 4:
                    logout();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void showMemberMenu() {
        Member member = (Member) currentUser;
        while (true) {
            System.out.println("\n=== Member Menu ===");
            System.out.println("1. View Subscription Status");
            System.out.println("2. View Assigned Coach");
            System.out.println("3. Update Profile");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    member.viewSubscriptionStatus();
                    break;
                case 2:
                    member.viewAssignedCoach();
                    break;
                case 3:
                    member.updateProfile();
                    break;
                case 4:
                    logout();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void logout() {
        currentUser = null;
        System.out.println("Logged out successfully!");
    }
}