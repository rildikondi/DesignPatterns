package state.smc;

public class TurnstileFSM extends Turnstile {
    private final TurnstileController
    controller;

    public TurnstileFSM(TurnstileController controller) {
        this.controller = controller;
    }

    @Override
    public void lock() {
        controller.lock();
    }

    @Override
    public void unlock() {
        controller.unlock();
    }

    @Override
    public void thankYou() {
        controller.thankYou();
    }

    @Override
    public void alarm() {
        controller.alarm();
    }
}