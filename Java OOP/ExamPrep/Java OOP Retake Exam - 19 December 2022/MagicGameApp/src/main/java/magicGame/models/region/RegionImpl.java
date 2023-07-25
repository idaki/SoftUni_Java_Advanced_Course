package magicGame.models.region;

import magicGame.core.Controller;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    //todo check logic
    @Override
    public String start(Collection<Magician> magicians) {


        List<Magician> wizardList = new ArrayList<>(magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals("Wizard"))
                .collect(Collectors.toList()));
        List<Magician> blackWidowList = new ArrayList<>(magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals("BlackWidow"))
                .collect(Collectors.toList()));

        wizardList.stream()
                .anyMatch(Magician::isAlive);

        Magician wizard = wizardList.iterator().next();
        Magician blackWidow = blackWidowList.iterator().next();


        while (wizardList.stream().anyMatch(Magician::isAlive)
                && blackWidowList.stream().anyMatch(Magician::isAlive) ){

            int hitPointBW= blackWidow.getMagic().fire();
            int hitPointsW= wizard.getMagic().fire();

            blackWidow.takeDamage(hitPointsW);
            wizard.takeDamage(hitPointBW);

            if (!blackWidow.isAlive()){
                blackWidow = blackWidowList.iterator().next();
            }

            if (!wizard.isAlive()){
                wizard = wizardList.iterator().next();
            }

        }

        if (wizardList.stream().anyMatch(Magician::isAlive)) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }
    }
}
