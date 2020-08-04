package state.switchcase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnstileTest {
    private Turnstile turnstile;
    private TurnstileControllerSpoof controllerSpoof;

    private class TurnstileControllerSpoof implements TurnstileController {
        public boolean lockCalled = false;
        public boolean unlockCalled = false;
        public boolean thankyouCalled = false;
        public boolean alarmCalled = false;

        @Override
        public void lock() {
            lockCalled = true;
        }

        @Override
        public void unlock() {
            unlockCalled = true;
        }

        @Override
        public void thankYou() {
            thankyouCalled = true;
        }

        @Override
        public void alarm() {
            alarmCalled = true;
        }
    }

    @Before
    public void setUp() {
        controllerSpoof = new TurnstileControllerSpoof();
        turnstile = new Turnstile(controllerSpoof);
    }

    @Test
    public void testInitialConditions() {
        Assert.assertEquals(State.LOCKED, turnstile.getState());
    }

    @Test
    public void testCoinInLockedState() {
        turnstile.setState(State.LOCKED);
        turnstile.handleEvent(Event.COIN);
        Assert.assertEquals(State.UNLOCKED, turnstile.getState());
        Assert.assertTrue(controllerSpoof.unlockCalled);
    }

    @Test
    public void testCoinInUnlockedState() {
        turnstile.setState(State.UNLOCKED);
        turnstile.handleEvent(Event.COIN);
        Assert.assertEquals(State.UNLOCKED, turnstile.getState());
        Assert.assertTrue(controllerSpoof.thankyouCalled);
    }

    @Test
    public void testPassInLockedState() {
        turnstile.setState(State.LOCKED);
        turnstile.handleEvent(Event.PASS);
        Assert.assertEquals(State.LOCKED, turnstile.getState());
        Assert.assertTrue(controllerSpoof.alarmCalled);
    }

    @Test
    public void testPassInUnlockedState() {
        turnstile.setState(State.UNLOCKED);
        turnstile.handleEvent(Event.PASS);
        Assert.assertEquals(State.LOCKED, turnstile.getState());
        Assert.assertTrue(controllerSpoof.lockCalled);
    }
}
