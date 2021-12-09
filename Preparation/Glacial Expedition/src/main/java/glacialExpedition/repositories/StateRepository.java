package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StateRepository implements Repository<State>{
    private Collection<State> states;

    public StateRepository(){
        states=new ArrayList<>();
    }

    @Override
    public Collection getCollection() {
        return Collections.unmodifiableCollection(this.states);
    }

    @Override
    public void add(State entity) {
        states.add(entity);
    }

    @Override
    public boolean remove(State entity) {
        return states.remove(entity);
    }

    @Override
    public State byName(String name) {
        return states.stream()
                .filter(s->s.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
