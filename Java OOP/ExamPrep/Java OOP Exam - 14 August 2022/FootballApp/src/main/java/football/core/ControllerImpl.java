package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;
import football.utils.PlayerUtils;
import football.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplements = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {

        Field field = null;

        if (!StringUtils.isFieldTypeValid(fieldType)) {
            throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        } else if ("ArtificialTurf".equals(fieldType)) {
            field = new ArtificialTurf(fieldName);
        } else if ("NaturalGrass".equals(fieldType)) {
            field = new NaturalGrass(fieldName);
        }

        fields.add(field);


        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE
                , fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement = null;
        if (!StringUtils.isSupplementTypeValidForDelivery(type)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        } else if ("Powdered".equals(type)) {
            supplement = new Powdered();
        } else if ("Liquid".equals(type)) {
            supplement = new Liquid();
        }
        supplements.add(supplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE
                , type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Field field = getFieldByName(fieldName);
        Supplement supplement = supplements.findByType(supplementType);

        if (supplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND
                    , supplementType));
        }
        //todo check logic
        field.getSupplements().add(supplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD
                , supplementType
                , fieldName);
    }


    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player = null;
        Field field = getFieldByName(fieldName);

        if (!StringUtils.isPlayerTypeValid(playerType)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        } else if ("Women".equals(playerType)) {
            player = new Women(playerName, nationality, strength);
        } else if ("Men".equals(playerType)) {
            player = new Men(playerName, nationality, strength);
        }

        if (!PlayerUtils.canPlayerJoinField(playerType, field)) {
            return ConstantMessages.FIELD_NOT_SUITABLE;
        }

        field.addPlayer(player);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD
                , playerType
                , fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = getFieldByName(fieldName);
        int playersDraggedCount = field.getPlayers().size();
        field.drag();

        return String.format(ConstantMessages.PLAYER_DRAG,playersDraggedCount);
    }

    @Override
    public String calculateStrength(String fieldName) {
       Field field = getFieldByName(fieldName);
      int sumPlayersStrength = field.getPlayers()
              .stream()
              .mapToInt(Player::getStrength)
              .sum();


      return String.format(ConstantMessages.STRENGTH_FIELD,
              fieldName,
              sumPlayersStrength);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        fields.forEach(f->sb.append(f.getInfo()).append(System.lineSeparator()));

        return sb.toString().trim();
    }

    private Field getFieldByName(String fieldName) {
        return fields.stream().filter(f -> f.getName().equals(fieldName))
                .findFirst()
                .orElse(null);
    }
}
