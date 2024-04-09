package handball.entities.gameplay;

import handball.entities.equipment.BaseEquipment;
import handball.entities.equipment.Equipment;

public class Indoor extends BaseGameplay {

    private static final int INITIAL_CAPACITY = 250;
    public Indoor(String name ) {
        super(name, INITIAL_CAPACITY );
    }
}
