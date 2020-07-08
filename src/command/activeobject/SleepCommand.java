package command.activeobject;

import java.util.Date;


public class SleepCommand implements Command {
    private Command wakeupCommand = null;
    private ActiveObjectEngine engine = null;
    private long sleepTime = 0;
    private Date startTime;
    private boolean started = false;

    public SleepCommand(long milliseconds, ActiveObjectEngine e, Command wakeupCommand) {
        sleepTime = milliseconds;
        engine = e;
        this.wakeupCommand = wakeupCommand;
    }

    @Override
    public void execute() {
        Date currentTime = new Date(System.currentTimeMillis());
        if (!started) {
            started = true;
            startTime = currentTime;
            engine.addCommand(this);
        } else {
            long diff = currentTime.getTime() - startTime.getTime();
            if (diff < sleepTime) {
                engine.addCommand(this);
            } else {
                engine.addCommand(wakeupCommand);
            }
        }
    }
}