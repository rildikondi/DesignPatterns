package state.statepattern;

public class Turnstile {
    protected static TurnstileState lockedState = new LockedTurnstileState();
    protected static TurnstileState unlockedState = new UnlockedTurnstileState();
    private TurnstileController turnstileController;
    private TurnstileState state = unlockedState;

    public Turnstile(TurnstileController action) {
        turnstileController = action;
    }

    public void coin() {
        state.coin(this);
    }

    public void pass() {
        state.pass(this);
    }

    public void setLocked() {
        state = lockedState;
    }

    public void setUnlocked() {
        state = unlockedState;
    }

    public boolean isLocked() {
        return state == lockedState;
    }

    public boolean isUnlocked() {
        return state == unlockedState;
    }

    protected void thankYou() {
        turnstileController.thankYou();
    }

    protected void alarm() {
        turnstileController.alarm();
    }

    protected void lock() {
        turnstileController.lock();
    }

    protected void unlock() {
        turnstileController.unlock();
    }

    public void setState(TurnstileState state) {
        this.state = state;
    }
}
