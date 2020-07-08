package command.activeobject;

public class DelayedTyper implements Command {
    private long itsDelay;
    private char itsChar;
    private static boolean stop = false;
    private static ActiveObjectEngine engine = new ActiveObjectEngine();

    private static class StopCommand implements Command {
        @Override
        public void execute() {
            DelayedTyper.stop = true;
        }
    }

    public static void main(String[] args) {
        engine.addCommand(new DelayedTyper(100, '1'));
        engine.addCommand(new DelayedTyper(300, '3'));
        engine.addCommand(new DelayedTyper(500, '5'));
        engine.addCommand(new DelayedTyper(700, '7'));
        Command stopCommand = new StopCommand();
        engine.addCommand(new SleepCommand(20000, engine, stopCommand));
        engine.run();
    }

    public DelayedTyper(long delay, char c) {
        itsDelay = delay;
        itsChar = c;
    }

    @Override
    public void execute() {
        System.out.print(itsChar);
        if (!stop)
            delayAndRepeat();
    }

    private void delayAndRepeat() {
        engine.addCommand(new SleepCommand(itsDelay, engine, this));
    }
}
