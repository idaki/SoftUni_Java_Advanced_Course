package handball.core;

import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.HashMap;

import static handball.common.ConstantMessages.*;
import static handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private EquipmentRepository equipmentRepository;
    private HashMap<String, Gameplay> gameplays;

    public ControllerImpl() {
        this.equipmentRepository = new EquipmentRepository();
        this.gameplays = new HashMap<>();
    }



    @Override
    public String addGameplay(String gameplayType, String gameplayName) {

        Gameplay currentGameplay = null;

        if (gameplayType.equals("Outdoor")) {
            currentGameplay = new Outdoor(gameplayName);
        } else if (gameplayType.equals("Indoor")) {
            currentGameplay = new Indoor(gameplayName);
        } else {
            throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        }
        this.gameplays.put(gameplayName, currentGameplay);

        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment currentEquipment = null;

        if (equipmentType.equals("Kneepad")) {
            currentEquipment = new Kneepad();
        } else if (equipmentType.equals("ElbowPad")) {
            currentEquipment = new ElbowPad();
        } else {
            throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        }
        this.equipmentRepository.add(currentEquipment);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);


    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {

        Equipment currentEquipment = this.equipmentRepository.findByType(equipmentType);
        if (currentEquipment == null) {
            throw new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND, equipmentType));
        }
        Gameplay gameplay = gameplays.get(gameplayName);
        gameplay.addEquipment(currentEquipment);

        this.equipmentRepository.remove(currentEquipment);


        return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
       Team currentTeam = null;
        if (teamType.equals("Bulgaria")){

            currentTeam = new Bulgaria(teamName,country,advantage);

       }else if(teamType.equals("Germany")){
            currentTeam = new Germany(teamName,country,advantage);

       }else{
           throw new IllegalArgumentException( INVALID_TEAM_TYPE);
       }
        Gameplay gameplay = gameplays.get(gameplayName);
        boolean isSuitable = gameplay.getClass().getSimpleName().equals("Outdoor") && teamType.equals("Bulgaria") ||
                gameplay.getClass().getSimpleName().equals("Indoor") && teamType.equals("Germany");

        if (!isSuitable) {
            return GAMEPLAY_NOT_SUITABLE;
        }
        this.gameplays.get(gameplayName).addTeam(currentTeam);
        return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
    }


    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = this.gameplays.get(gameplayName);
        gameplay.teamsInGameplay();

        return String.format(TEAMS_PLAYED, gameplay.getTeam().size());
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        return String.format(ADVANTAGE_GAMEPLAY, gameplayName,
                this.gameplays.get(gameplayName).getTeam().stream().mapToInt(Team::getAdvantage).sum());
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        this.gameplays.values().forEach(output::append);
        return output.toString().trim();
    }
}
