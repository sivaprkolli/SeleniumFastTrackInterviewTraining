package SeleniumLogs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LogsCheck {
    private static final Logger logger
            = LoggerFactory.getLogger(LogsCheck.class);

    public final Logger logger1
            = LoggerFactory.getLogger(LogsCheck.class);

   /* public static void main(String[] args) {
        logger1.info("Example log from {}", LogsCheck.class.getSimpleName());
    }*/

    @Test
    public void verifyLogs() {
        logger1.info("Example log from {}", LogsCheck.class.getSimpleName());
    }
}
