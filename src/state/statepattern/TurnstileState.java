package state.statepattern;

public interface TurnstileState {
    void coin(Turnstile t);

    void pass(Turnstile t);
}