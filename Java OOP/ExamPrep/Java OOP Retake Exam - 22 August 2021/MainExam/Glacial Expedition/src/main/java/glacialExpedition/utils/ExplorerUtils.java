package glacialExpedition.utils;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;

public final class ExplorerUtils {
    private ExplorerUtils() {
    }

    public static boolean isExplorerTypeValid(String type) {
        return "AnimalExplorer".equals(type) || "NaturalExplorer".equals(type) || "GlacierExplorer".equals(type);
    }




    public static Explorer createNewExplorer(String type, String name) {
        Explorer explorer = null;
        if ("AnimalExplorer".equals(type)) {
            explorer = new AnimalExplorer(name);
        } else if ("NaturalExplorer".equals(type)) {
            explorer = new NaturalExplorer(name);
        } else if ("GlacierExplorer".equals(type)) {
            explorer = new GlacierExplorer(name);
        }
        return explorer;
    }


}
