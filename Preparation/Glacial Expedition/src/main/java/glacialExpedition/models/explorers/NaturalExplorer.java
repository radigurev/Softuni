package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    private static final int INITIAL_UNITS_OF_ENERGY=60;
    public NaturalExplorer(String name) {
        super(name, INITIAL_UNITS_OF_ENERGY);
    }
    @Override
    public void search() {

    }
}
