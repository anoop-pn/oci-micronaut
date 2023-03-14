package newsletter.subscription;

import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.oraclecloud.function.OciFunction;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Collections;
import java.util.Map;
import edu.ucr.cs.riple.taint.ucrtainting.qual.RUntainted;

@Singleton
public class Function extends OciFunction {

    @Inject
    MailSender mailSender;

    @ReflectiveAccess
    public Map<String, String> handleRequest(@RUntainted String toEmail) {
        final String messageID = mailSender.send(
                toEmail,
                "Hello from Mushop",
                "Thanks for confirming your <b>subscription</b>!"
        );

        return Collections.singletonMap("messageId", messageID);
    }
}
