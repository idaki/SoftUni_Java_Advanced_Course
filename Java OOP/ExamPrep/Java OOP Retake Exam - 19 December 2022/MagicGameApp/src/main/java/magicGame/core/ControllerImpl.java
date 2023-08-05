package magicGame.core;


import magicGame.common.ExceptionMessages;
import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepository;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;
import magicGame.utils.MagicUtils;
import magicGame.utils.MagicianUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic magic = null;

        if (!MagicUtils.isMagicValid(type)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        } else if ("RedMagic".equals(type)) {
            magic = new RedMagic(name, bulletsCount);
        } else if ("BlackMagic".equals(type)) {
            magic = new BlackMagic(name, bulletsCount);
        }
        this.magics.addMagic(magic);

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
//    AddMagician              BlackWidow   magicianPeter    30            30               Luna
        Magician magician = null;
        Magic magic = magics.findByName(magicName);

        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
        } else if (!MagicianUtils.isMagicianTypeValid(type)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
        } else if ("Wizard".equals(type)) {
            magician = new Wizard(username, health, protection, magic);
        } else if ("BlackWidow".equals(type)) {
            magician = new BlackWidow(username, health, protection, magic);
        }
        this.magicians.addMagician(magician);

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {

        return region.start(magicians.getData());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        List<Magician> magicianList = new ArrayList<>(magicians.getData());

        magicianList.sort(Comparator.comparing(Magician::getHealth));
        magicianList.sort(Comparator.comparing(Magician::getUsername));
        magicianList.sort(Comparator.comparing(m -> m.getClass().getSimpleName()));


        for (Magician magician : magicianList) {

            sb.append(magician.getClass().getSimpleName()).append(": ")
                    .append(magician.getUsername())
                    .append(System.lineSeparator());
            sb.append("Health: ")
                    .append(magician.getHealth())
                    .append(System.lineSeparator());
            sb.append("Protection: ")
                    .append(magician.getProtection())
                    .append(System.lineSeparator());
            sb.append("Magic: ")
                    .append(magician.getMagic().getName())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
