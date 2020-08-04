package state.switchcase;

import static state.switchcase.State.LOCKED;
import static state.switchcase.State.UNLOCKED;

public class Turnstile {
    private State state = LOCKED;
    private TurnstileController turnstileController;

    public Turnstile(TurnstileController action) {
        this.turnstileController = action;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handleEvent(Event event) {
        switch (state) {
            case LOCKED:
                switch (event) {
                    case COIN:
                        state = UNLOCKED;
                        turnstileController.unlock();
                        break;
                    case PASS:
                        turnstileController.alarm();
                        break;
                }
                break;
            case UNLOCKED:
                switch (event) {
                    case COIN:
                        turnstileController.thankYou();
                        break;
                    case PASS:
                        state = LOCKED;
                        turnstileController.lock();
                        break;
                }
                break;
        }
    }
}
