import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;


public class TestResultLogger implements TestWatcher
{
    Log log = new Log();

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        log.info(testName + "Passed");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String failCause = cause.getMessage();
        log.info(testName + " Failed: " + failCause);
    }
}
