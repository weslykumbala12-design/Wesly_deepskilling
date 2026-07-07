import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    ParameterizedLoggingExample.class
            );

    public static void main(String[] args) {

        String username = "Wesley";
        int age = 21;

        logger.info(
                "User {} is {} years old",
                username,
                age
        );

        int accountId = 101;
        double balance = 5000.50;

        logger.warn(
                "Account {} has balance {}",
                accountId,
                balance
        );

        String operation = "Fund Transfer";

        logger.error(
                "Operation {} failed for account {}",
                operation,
                accountId
        );
    }
}