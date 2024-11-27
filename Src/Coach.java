import java.util.List;
import java.util.ArrayList;

public class Coach extends User {
    private List<Member> assignedMembers;
    private List<String> specializations;

    public Coach(String id, String username, String password, String name, String email, String phone) {
        super(id, username, password, name, email, phone);
        this.assignedMembers = new ArrayList<>();
        this.specializations = new ArrayList<>();
    }

    public void manageMemberPlans() {
        System.out.println("\n=== Manage Member Plans ===");
        // Implementation for managing member plans
    }

    public void sendMessages() {
        System.out.println("\n=== Send Messages ===");
        // Implementation for sending messages
    }

    @Override
    public void updateProfile() {
        System.out.println("\n=== Update Profile ===");
        // Implementation for profile update
    }

    // Getters and setters for assigned members and specializations
    public List<Member> getAssignedMembers() { return assignedMembers; }
    public void setAssignedMembers(List<Member> members) { this.assignedMembers = members; }
    public List<String> getSpecializations() { return specializations; }
    public void setSpecializations(List<String> specializations) { this.specializations = specializations; }
}