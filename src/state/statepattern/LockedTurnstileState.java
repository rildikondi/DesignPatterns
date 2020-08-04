package state.statepattern;

public class LockedTurnstileState implements TurnstileState {
    @Override
    public void coin(Turnstile t) {
        t.setUnlocked();
        t.unlock();
    }

    @Override
    public void pass(Turnstile t) {
        t.alarm();
    }
}
