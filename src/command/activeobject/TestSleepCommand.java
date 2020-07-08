package command.activeobject;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TestSleepCommand {

    private class WakeUpCommand implements Command {
        public boolean executed = false;

        public void execute() {
            executed = true;
        }
    }

    @Test
    public void testSleep() {
        WakeUpCommand wakeup = new WakeUpCommand();
        ActiveObjectEngine e = new ActiveObjectEngine();
        SleepCommand c = new SleepCommand(1000, e, wakeup);
        e.addCommand(c);
        Date start = new Date(System.currentTimeMillis());
        e.run();
        Date stop = new Date(System.currentTimeMillis());
        long sleepTime = stop.getTime() - start.getTime();
        Assert.assertTrue("SleepTime " + sleepTime + " expected > 1000", sleepTime >= 1000);
        Assert.assertTrue("SleepTime " + sleepTime + " expected < 1100", sleepTime <= 1100);
        Assert.assertTrue("Command Executed", wakeup.executed);
    }
}
