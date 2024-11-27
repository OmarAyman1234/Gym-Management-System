import java.util.Date;

public class Member extends User {
    private Date subscriptionEndDate;
    private Coach assignedCoach;
    private String membershipType;
    private boolean isActive;

    public Member(String id, String username, String password, String name, String email, String phone) {
        super(id, username, password, name, email, phone);
    }

    public void viewSubscriptionStatus() {
        System.out.println("\n=== Subscription Status ===");
        System.out.println("Subscription End Date: " + subscriptionEndDate);
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
    }

    public void viewAssignedCoach() {
        System.out.println("\n=== Assigned Coach ===");
        if (assignedCoach != null) {
            System.out.println("Coach Name: " + assignedCoach.getName());
            System.out.println("Coach Email: " + assignedCoach.getEmail());
            System.out.println("Coach Phone: " + assignedCoach.getPhone());
        } else {
            System.out.println("No coach assigned yet.");
        }
    }

    @Override
    public void updateProfile() {
        System.out.println("\n=== Update Profile ===");
        // Implementation for profile update
    }

    // Getters and setters
    public Date getSubscriptionEndDate() { return subscriptionEndDate; }
    public void setSubscriptionEndDate(Date date) { this.subscriptionEndDate = date; }
    public Coach getAssignedCoach() { return assignedCoach; }
    public void setAssignedCoach(Coach coach) { this.assignedCoach = coach; }
    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String type) { this.membershipType = type; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}