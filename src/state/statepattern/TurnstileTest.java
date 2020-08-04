package state.statepattern;

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
        Assert.assertTrue(turnstile.isUnlocked());
    }

    @Test
    public void testCoinInLockedState() {
        turnstile.setState(Turnstile.lockedState);
        turnstile.coin();
        Assert.assertTrue(turnstile.isUnlocked());
        Assert.assertTrue(controllerSpoof.unlockCalled);
    }

    @Test
    public void testCoinInUnlockedState() {
        turnstile.setState(Turnstile.unlockedState);
        turnstile.coin();
        Assert.assertTrue(turnstile.isUnlocked());
        Assert.assertTrue(controllerSpoof.thankyouCalled);
    }

    @Test
    public void testPassInLockedState() {
        turnstile.setState(Turnstile.lockedState);
        turnstile.pass();
        Assert.assertTrue(turnstile.isLocked());
        Assert.assertTrue(controllerSpoof.alarmCalled);
    }

    @Test
    public void testPassInUnlockedState() {
        turnstile.setState(Turnstile.unlockedState);
        turnstile.pass();
        Assert.assertTrue(turnstile.isLocked());
        Assert.assertTrue(controllerSpoof.lockCalled);
    }
}
