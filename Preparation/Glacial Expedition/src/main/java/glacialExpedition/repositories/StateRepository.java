package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.Collection;

public class StateRepository implements Repository<State>{
    private Collection<State> states;

    @Override
    public Collection getCollection() {
        return null;
    }

    @Override
    public void add(State entity) {

    }

    @Override
    public boolean remove(State entity) {
        return false;
    }

    @Override
    public State byName(String name) {
        return null;
    }
}
