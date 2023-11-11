package football.core;

import football.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();//TODO implement first
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddField:
                result = addField(data);
                break;
            case DeliverySupplement:
                result = deliverySupplement(data);
                break;
            case SupplementForField:
                result = supplementForField(data);
                break;
            case AddPlayer:
                result = addPlayer(data);
                break;
            case DragPlayer:
                result = dragPlayer(data);
                break;
            case CalculateStrength:
                result = calculateStrength(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }

    private String addField(String[] data) {
        String type = data[0];
        String name = data[1];

        return this.controller.addField(type, name);
    }

    private String deliverySupplement(String[] data) {
        String type = data[0];
        return this.controller.deliverySupplement(type);
    }

    private String supplementForField(String[] data) {
        String name = data[0];
        String type = data[1];
        return this.controller.supplementForField(name, type);
    }

    private String addPlayer(String[] data) {
        String fieldName = data[0];
        String playerType = data[1];
        String playerName = data[2];
        String playerNationality = data[3];
        int strength = Integer.parseInt(data[4]);
        return this.controller.addPlayer(fieldName,playerType,playerName,playerNationality,strength);
    }

    private String dragPlayer(String[] data) {
        String fieldName = data[0];
        return this.controller.dragPlayer(fieldName);
    }

    private String calculateStrength(String[] data) {
        String fieldName = data[0];
        return this.controller.calculateStrength(fieldName);
    }

    private String getStatistics() {

        return this.controller.getStatistics();
    }
}
