package state.statepattern;

public class UnlockedTurnstileState implements TurnstileState {
    @Override
    public void coin(Turnstile t) {
        t.thankYou();
    }

    @Override
    public void pass(Turnstile t) {
        t.setLocked();
        t.lock();
    }
}
