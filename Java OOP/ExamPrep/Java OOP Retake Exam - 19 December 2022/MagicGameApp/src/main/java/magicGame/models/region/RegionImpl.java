package magicGame.models.region;

import magicGame.core.Controller;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.Magic;
import magicGame.utils.MagicUtils;
import magicGame.utils.MagicianUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    //todo check logic
    @Override
    public String start(Collection<Magician> magicians) {

        List<Magician> wizards = new ArrayList<>(magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals("Wizard") && m.isAlive())
                .collect(Collectors.toList()));
        List<Magician> blackWidows = new ArrayList<>(magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals("BlackWidow") && m.isAlive())
                .collect(Collectors.toList()));



        while(MagicianUtils.hasAliveWizards(wizards) && MagicianUtils.hasAliveBlackWidows(blackWidows)){
            Magician wizard = MagicianUtils.getNextAliveWizard(wizards);
            Magician blackWidow = MagicianUtils.getNextAliveWizard(blackWidows);

            int wizardHitPoints= blackWidow.getMagic().fire();
            int blackWidowHitPoints= blackWidow.getMagic().fire();

            blackWidow.takeDamage(wizardHitPoints);
            wizard.takeDamage(blackWidowHitPoints);

        }

        if (wizards.stream().anyMatch(Magician::isAlive)) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }
    }
}
