package newsletter.subscription;
import edu.ucr.cs.riple.taint.ucrtainting.qual.RUntainted;

public interface MailSender {
    String send(@RUntainted String to, String subject, String body);
}
