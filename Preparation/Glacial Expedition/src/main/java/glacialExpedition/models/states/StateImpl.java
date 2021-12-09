package glacialExpedition.models.states;

import java.util.Collection;

public class StateImpl implements State{
    private String name;
    private Collection<String> exhibits;

    protected StateImpl(String name) {
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
