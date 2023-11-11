package glacialExpedition.models.explorers;

import glacialExpedition.utils.DoubleUtils;

public class GlacierExplorer extends BaseExplorer{

    private static final double INITIAL_ENERGY = 40;


    public GlacierExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }



}
