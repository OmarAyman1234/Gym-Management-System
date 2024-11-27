import java.util.Date;
import java.util.List;

public class NotificationSystem {
    public void checkSubscriptions(List<Member> members) {
        Date currentDate = new Date();
        for (Member member : members) {
            if (member.getSubscriptionEndDate() != null) {
                // Check if subscription ends within 7 days
                long daysUntilExpiration = (member.getSubscriptionEndDate().getTime() - currentDate.getTime()) 
                    / (1000 * 60 * 60 * 24);
                
                if (daysUntilExpiration <= 7 && daysUntilExpiration >= 0) {
                    sendSubscriptionNotification(member);
                }
            }
        }
    }

    private void sendSubscriptionNotification(Member member) {
        System.out.println("Notification sent to " + member.getName() + 
            ": Your subscription will expire on " + member.getSubscriptionEndDate());
        // In a real system, this would send an email or other notification
    }
}