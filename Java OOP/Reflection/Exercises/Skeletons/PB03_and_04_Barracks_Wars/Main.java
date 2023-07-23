package PB03_and_04_Barracks_Wars;

import PB03_and_04_Barracks_Wars.interfaces.Repository;
import PB03_and_04_Barracks_Wars.interfaces.Runnable;
import PB03_and_04_Barracks_Wars.interfaces.UnitFactory;
import PB03_and_04_Barracks_Wars.core.Engine;
import PB03_and_04_Barracks_Wars.core.factories.UnitFactoryImpl;
import PB03_and_04_Barracks_Wars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }

    //Engine -> parse and execute commands
    //Repository -> военна единица : брой
        //archer: брой стрелци
        //pikeman: брой копиеносци
        //swordsman: брой мечоносците
    //UnitFactory: създаване на военни единици
}
