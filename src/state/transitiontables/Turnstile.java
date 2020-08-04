package state.transitiontables;

import java.util.ArrayList;
import java.util.List;

public class Turnstile {
    private State state = State.LOCKED;
    private List<Transition> transitions = new ArrayList<>();

    private interface Action {
        void execute();
    }

    public Turnstile(TurnstileController controller) {
        Action unlock = controller::unlock;
        Action alarm = controller::alarm;
        Action thankYou = controller::thankYou;
        Action lockAction = controller::lock;
        addTransition(State.LOCKED, Event.COIN, State.UNLOCKED, unlock);
        addTransition(State.LOCKED, Event.PASS, State.LOCKED, alarm);
        addTransition(State.UNLOCKED, Event.COIN, State.UNLOCKED, thankYou);
        addTransition(State.UNLOCKED, Event.PASS, State.LOCKED, lockAction);
    }

    public void handleEvent(Event event) {
        for (Transition transition : transitions) {
            if (state == transition.startState &&
                    event == transition.trigger) {
                state = transition.endState;
                transition.action.execute();
            }
        }
    }

    private void addTransition(State start, Event e, State end, Action action) {
        transitions.add(new Transition(start, e, end, action));
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private class Transition {
        public State startState;
        public Event trigger;
        public State endState;
        public Action action;

        public Transition(State start, Event e, State end, Action a) {
            this.startState = start;
            this.trigger = e;
            this.endState = end;
            this.action = a;
        }
    }
}