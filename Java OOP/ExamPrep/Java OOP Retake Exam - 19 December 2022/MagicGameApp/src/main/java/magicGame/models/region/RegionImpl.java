package magicGame.models.region;

import magicGame.core.Controller;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.Magic;
import magicGame.utils.MagicUtils;

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
                .filter(m -> m.getClass().getSimpleName().equals("Wizard") && m.isAlive())
                .collect(Collectors.toList()));
        List<Magician> blackWidowList = new ArrayList<>(magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals("BlackWidow") && m.isAlive())
                .collect(Collectors.toList()));


        Magician wizard = wizardList.iterator().next();
        Magician blackWidow = blackWidowList.iterator().next();


        while(!wizardList.isEmpty() && !blackWidowList.isEmpty()){

            blackWidow.takeDamage(wizard.getMagic().fire());
            if (blackWidow.isAlive()){
                wizard.takeDamage(blackWidow.getMagic().fire());
                if (!wizard.isAlive()){
                    wizardList.remove(wizard);
                    wizard = wizardList.iterator().next();
                }
            } else {
                blackWidowList.remove(blackWidow);
                blackWidow = blackWidowList.iterator().next();
            }
        }

        if (wizardList.stream().anyMatch(Magician::isAlive)) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }
    }
}
